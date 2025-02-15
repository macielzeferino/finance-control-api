package com.macielzeferino.financecontrol.repository;

import com.macielzeferino.financecontrol.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment,UUID> {
}
