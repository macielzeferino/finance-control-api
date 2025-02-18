package com.macielzeferino.financecontrol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;
@Data
@NoArgsConstructor
@Entity
@Table(name="investments_table")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID investmentId;

    @Column(name = "investment_name")
    private String investmentName;

    @Column(name = "investment_amount")
    private Double investmentAmount;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updatedTimestamp;

    public Investment(String investmentName, Double investmentAmount) {
        this.investmentName = investmentName;
        this.investmentAmount = investmentAmount;
    }


}
