package com.macielzeferino.financecontrol.controller;

import com.macielzeferino.financecontrol.entity.Investment;
import com.macielzeferino.financecontrol.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping
    public ResponseEntity<Investment>createInvestment(@RequestBody CreateInvestmentDto createInvestmentDto){
        var investmentId = investmentService.createInvestment(createInvestmentDto);
        return  ResponseEntity.created(URI.create("investments/" + investmentId.toString())).build();
    }
}
