package com.task.betslip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.betslip.domain.Betslip;

/**
 * @author sunil
 *
 */
@Repository
public interface BetslipRepository extends CrudRepository<Betslip, Long> {

}
