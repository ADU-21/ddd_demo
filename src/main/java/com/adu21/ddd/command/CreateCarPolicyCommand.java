package com.adu21.ddd.command;

import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.mapper.HomePolicyMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarPolicyCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int policyNumber;
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

