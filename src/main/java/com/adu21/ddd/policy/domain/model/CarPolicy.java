package com.adu21.ddd.policy.domain.model;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.mapper.HomePolicyMapper;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
