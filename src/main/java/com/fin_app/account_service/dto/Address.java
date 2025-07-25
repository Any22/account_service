package com.fin_app.account_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotBlank(message = "Address Line is required")
    private String addressLine;

    @NotBlank(message = "City is required")
    private String city;

    @Min(value=1000 , message = "Postal Code must be at least 4 digits")
    private Integer postalCode;

    @NotBlank(message = "State is required")
    private String state;
}
