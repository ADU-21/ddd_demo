package com.adu21.ddd.model;

import com.adu21.ddd.command.CreateCarPolicyCommand;
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
@Entity
public class CarPolicy {
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

    public CarPolicy apply(CreateCarPolicyCommand createCarPolicyCommand) {
        HomePolicyMapper homePolicyMapper = new HomePolicyMapper();
        return homePolicyMapper.map(createCarPolicyCommand, CarPolicy.class);
    }
}
