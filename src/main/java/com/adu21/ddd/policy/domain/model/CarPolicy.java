package com.adu21.ddd.policy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarPolicy {
    @Id
    private String policyNumber;
    private String ownerEmail;
    private Date startDate;
    private Date carPurchaseDate;
    private String carBrand;
    private String carType;
    private String carParkPlace;
    private int distancePreYear;
    private double price;
    private Date driverBirthday;
    private String driverSex;
    private String quoteId;
    private Date holderBirthday;
    private String holderEmail;
    private String holderId;

}
