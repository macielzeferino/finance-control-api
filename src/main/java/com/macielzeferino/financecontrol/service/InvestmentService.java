package com.macielzeferino.financecontrol.service;

import com.macielzeferino.financecontrol.controller.CreateInvestmentDto;
import com.macielzeferino.financecontrol.entity.Investment;
import com.macielzeferino.financecontrol.repository.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public UUID createInvestment(CreateInvestmentDto createInvestmentDto){
       var entity = new Investment(
                UUID.randomUUID(),
                createInvestmentDto.investmentName(),
                createInvestmentDto.investmentAmount(),
                Instant.now(),
                null);

       var investmentSaved = investmentRepository.save(entity);
       return investmentSaved.getInvestmentId();
    }

}
