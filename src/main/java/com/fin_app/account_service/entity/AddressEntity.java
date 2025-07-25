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
public class AddressEntity {
    @Column( name ="address_line" , nullable = false)
    private String addressLine;

    @Column( name ="city" , nullable = false)
    private String city;

    @Column( name ="zip_code" , nullable = false)
    private Integer postalCode;

    @Column( name ="state" , nullable = false)
    private String state;
}

