package com.adu21.ddd.quotation.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "HOME_POLICY_QUOTATION")
public class HomePolicyQuotation extends Quotation {
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
