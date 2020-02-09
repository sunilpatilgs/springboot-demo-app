package com.task.betslip.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.task.betslip.domain.Betslip;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author sunil
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BetslipRepositoryTest {

	@Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BetslipRepository betslipRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Test
    public void findBetslipTest() {
    	Betslip betslip = new Betslip();
    	betslip.setCustomer(customerRepository.findById(1l).get());
    	betslip.setStatus("created");
    	betslip.setTeamAFactor(10.0);
    	betslip.setTeamBFactor(20.0);
    	betslip.setTieFactor(5.0);
    	
    	testEntityManager.persist(betslip);
    	
    	testEntityManager.flush();
    	testEntityManager.clear();
    	
    	Betslip result = betslipRepository.findById(betslip.getId()).get();
    	
    	
    	assertThat(result, notNullValue());
        assertThat(result.getTeamAFactor(), equalTo(10.0));
        assertThat(result.getTeamBFactor(), equalTo(20.0));
        assertThat(result.getTieFactor(), equalTo(5.0));
    	
    }
    
    @Test
    public void updateBetslipTest() {
		
    	Betslip betslip = new Betslip();
    	betslip.setCustomer(customerRepository.findById(1l).get());
    	betslip.setStatus("created");
    	betslip.setTeamAFactor(10.0);
    	betslip.setTeamBFactor(20.0);
    	betslip.setTieFactor(5.0);
    	
    	testEntityManager.persist(betslip);
    	
    	testEntityManager.flush();
    	testEntityManager.clear();
    	
    	Betslip modifiedBetslip = betslipRepository.findById(betslip.getId()).get();
    	//update team A bet factor
    	modifiedBetslip.setTeamAFactor(25.0);
    	
    	testEntityManager.persist(modifiedBetslip);
    	
    	testEntityManager.flush();
    	testEntityManager.clear();
    	
    	Betslip result = betslipRepository.findById(modifiedBetslip.getId()).get();
    	
    	
    	assertThat(result, notNullValue());
        assertThat(result.getTeamAFactor(), equalTo(25.0));
        assertThat(result.getTeamBFactor(), equalTo(20.0));
        assertThat(result.getTieFactor(), equalTo(5.0));
	}
    
    @Test
    public void deleteBetslipTest() {
    	Betslip betslip = new Betslip();
    	betslip.setCustomer(customerRepository.findById(1l).get());
    	betslip.setStatus("created");
    	betslip.setTeamAFactor(10.0);
    	betslip.setTeamBFactor(20.0);
    	betslip.setTieFactor(5.0);
    	
    	testEntityManager.persist(betslip);
    	
    	testEntityManager.flush();
    	testEntityManager.clear();
    	
    	Betslip result = betslipRepository.findById(betslip.getId()).get();
    	
    	betslipRepository.delete(result);
    	
    	assertThat(betslipRepository.findById(betslip.getId()).isPresent(), equalTo(false));
	}
    
}
