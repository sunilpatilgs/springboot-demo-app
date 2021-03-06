package com.task.betslip.service;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.betslip.domain.Betslip;
import com.task.betslip.models.BetslipDetailResponse;
import com.task.betslip.models.CreateBetslipRequest;
import com.task.betslip.models.Status;
import com.task.betslip.repository.BetslipRepository;
import com.task.betslip.repository.CustomerRepository;
import com.task.betslip.status.BetslipStatus;

/**
 * @author sunil
 *
 */
@Service
public class BetslipServiceImpl extends BaseService implements BetslipService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BetslipServiceImpl.class);
	
	private BetslipRepository betslipRepository;
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public BetslipServiceImpl(BetslipRepository betslipRepository, CustomerRepository customerRepository) {
		this.betslipRepository = betslipRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public BetslipDetailResponse getBetslipDetails(Long betId) {
		BetslipDetailResponse betslipDetailResponse = new BetslipDetailResponse();
		Optional<Betslip> betslip = betslipRepository.findById(betId);
		if (betslip.isPresent()) {
			com.task.betslip.models.Betslip betslipData = new com.task.betslip.models.Betslip();
			betslipData.setId(betslip.get().getId());
			betslipData.setTeamAFactor(betslip.get().getTeamAFactor());
			betslipData.setTieFactor(betslip.get().getTieFactor());
			betslipData.setTeamBFactor(betslip.get().getTeamBFactor());
			betslipData.setStatus(betslip.get().getStatus());
			betslipDetailResponse.setBetslip(betslipData);
			betslipDetailResponse.setStatus(createSatus(BetslipStatus.RETRIEVE_SUCCESS));
		}else {
			logger.warn("Betslip not found");
			betslipDetailResponse.setStatus(createSatus(BetslipStatus.BETSLIP_NOT_FOUND));
		}
		return betslipDetailResponse;
	}

	@Override
	public Status deleteBetslip(Long betId) {
		if (betslipRepository.existsById(betId)) {
			betslipRepository.deleteById(betId);
			return createSatus(BetslipStatus.DELETE_SUCCESS);
		}

		return createSatus(BetslipStatus.BETSLIP_NOT_FOUND);
	}

	@Override
	public Status createBetslip(@Valid CreateBetslipRequest betslipRequest) {

		if (!customerRepository.existsById(betslipRequest.getCustomerId())) {
			return createSatus(BetslipStatus.CUSTOMER_NOT_FOUND);
		} else {
			Betslip betslip = new Betslip();
			betslip.setCustomer(customerRepository.findById(betslipRequest.getCustomerId()).get());
			betslip.setTeamAFactor(betslipRequest.getTeamAFactor());
			betslip.setTieFactor(betslipRequest.getTieFactor());
			betslip.setTeamBFactor(betslipRequest.getTeamBFactor());
			betslip.setStatus("created");
			betslipRepository.save(betslip);
		}

		return createSatus(BetslipStatus.CREATION_SUCCESS);
	}

	@Override
	public Status updateBetslip(Long betId, @Valid CreateBetslipRequest betslipRequest) {
		if (!customerRepository.existsById(betslipRequest.getCustomerId())) {
			return createSatus(BetslipStatus.CUSTOMER_NOT_FOUND);
		} else if (!betslipRepository.existsById(betId)) {
			return createSatus(BetslipStatus.BETSLIP_NOT_FOUND);
		} else {
			Optional<Betslip> betslip = betslipRepository.findById(betId);
			betslip.get().setTeamAFactor(betslipRequest.getTeamAFactor());
			betslip.get().setTieFactor(betslipRequest.getTieFactor());
			betslip.get().setTeamBFactor(betslipRequest.getTeamBFactor());
			betslipRepository.save(betslip.get());
		}
		return createSatus(BetslipStatus.UPDATE_SUCCESS);
	}

}
