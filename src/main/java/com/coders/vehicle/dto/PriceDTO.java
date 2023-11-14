package com.coders.vehicle.dto;

import com.coders.vehicle.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private Integer id;
    private BigDecimal amount;
    private Currency currency;
}
