package com.fin_app.account_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceEntity {
    @Column( name ="currency" , nullable = false)
    private String currency;

    @Column( name ="amount" , nullable = false)
    private BigDecimal amount;

}
