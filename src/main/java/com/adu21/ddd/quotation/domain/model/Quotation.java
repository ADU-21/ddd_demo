package com.adu21.ddd.quotation.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Quotation {
    @Id
    private String quoteId = UUID.randomUUID().toString();
    private Double premium;
}
