package com.adu21.ddd.quote.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomePolicyQuotation extends Quotation {
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
