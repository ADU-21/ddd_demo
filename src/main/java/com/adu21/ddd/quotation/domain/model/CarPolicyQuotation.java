package com.adu21.ddd.quotation.domain.model;

import com.adu21.ddd.common.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CAR_POLICY_QUOTATION")
public class CarPolicyQuotation extends Quotation {
    private String productiveYear;
    private String carBrand;
    private String carModel;
    private String parkPlace;
    private String distancePreYear;
    private LocalDate driverBirthDay;
    @Enumerated(EnumType.STRING)
    private Gender driverGender;
}
