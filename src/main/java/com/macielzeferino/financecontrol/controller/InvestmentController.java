package com.macielzeferino.financecontrol.controller;

import com.macielzeferino.financecontrol.entity.Investment;
import com.macielzeferino.financecontrol.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{investmentId}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable("investmentId")String investmentId){

        var investment = investmentService.getInvestmentById(investmentId);
        return investment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<Investment>> listInvestments(){
       var  investments = investmentService.listInvestments();
       return ResponseEntity.ok(investments);
    }

    @PutMapping("/{investmentId}")
     public ResponseEntity<Void> updateInvestmentById(@PathVariable("investmentId")String investmentId,
                                                 @RequestBody UpdateInvestmentDto updateInvestmentDto){
        investmentService.updateInvestmentById(investmentId, updateInvestmentDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{investmentId}")
    public ResponseEntity<Void> deleteInvestmentById(@PathVariable("investmentId") String investmentId){
        investmentService.deleteInvestmentById(investmentId);
        return ResponseEntity.noContent().build();
    }
}


