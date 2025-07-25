package com.fin_app.account_service.entity;

import com.fin_app.account_service.dto.Balance;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_table")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Embedded
    private Balance balance;

}
