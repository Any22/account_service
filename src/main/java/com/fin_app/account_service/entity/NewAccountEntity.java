package com.fin_app.account_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account_table")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountEntity {
    // private String customerId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private UUID accountId;

    @Column(name = "account_name", nullable = false)
    private String accountHolderName;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "amount", nullable = false)
    private BigDecimal value;

    @Column(name = "branch_code", nullable = false)
    private String branchCode;

    @Column(name = "interest_rate", nullable = false)
    private Double interestRate;

}
