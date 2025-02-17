package com.macielzeferino.financecontrol.service;

import com.macielzeferino.financecontrol.controller.CreateInvestmentDto;
import com.macielzeferino.financecontrol.controller.UpdateInvestmentDto;
import com.macielzeferino.financecontrol.entity.Investment;
import com.macielzeferino.financecontrol.repository.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
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

    public Optional <Investment> getInvestmentById(String investmentId) {
        return investmentRepository.findById(UUID.fromString(investmentId));
    }

    public List<Investment> listInvestments(){
        return investmentRepository.findAll();
    }


    public void updateInvestmentById(String investmentId, UpdateInvestmentDto updateInvestmentDto) {
        var id = UUID.fromString(investmentId);
        var investmentExists = investmentRepository.findById(id);
        if (investmentExists.isPresent()){
            var investment = investmentExists.get();
            if (updateInvestmentDto.investmentName() !=null) {
                investment.setInvestmentName(updateInvestmentDto.investmentName());
            }
            if(updateInvestmentDto.investmentAmount() !=null){
                investment.setInvestmentAmount(updateInvestmentDto.investmentAmount());
            }
            investmentRepository.save(investment);
        }
    }

    public void deleteInvestmentById(String investmentId){
        var id = UUID.fromString(investmentId);
        var investmentExists = investmentRepository.existsById(id);

        if (investmentExists) {
            investmentRepository.deleteById(id);
        }
    }

}
