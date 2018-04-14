package com.adu21.ddd.policy.command;

import com.adu21.ddd.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarPolicyCommand {
    private LocalDate startDate;
    private String productiveYear;
    private String carBrand;
    private String carModel;
    private String parkPlace;
    private String distancePreYear;
    private LocalDate driverBirthDay;
    private Gender driverGender;
    private String quoteId;
    private double premium;
    private LocalDate holderBirthday;
    private String holderEmail;
    private String holderId;
    private String holderName;
}
