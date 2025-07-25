package com.fin_app.account_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolderNameEntity {
    @Column( name ="first_name" , nullable = false)
    private String firstName;

    @Column( name ="last_name" , nullable = false)
    private String lastName;
}
