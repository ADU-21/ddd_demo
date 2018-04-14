package com.adu21.ddd.quote.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Quotation {
    private String quoteId = UUID.randomUUID().toString();
    private Double premium;

    public Quotation(Double premium) {
        this.premium = premium;
    }
}
