package com.adu21.ddd.policy.domain.model;

import com.adu21.ddd.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarPolicy extends Policy {
    private String productiveYear;
    private String carBrand;
    private String carModel;
    private String parkPlace;
    private String distancePreYear;
    private LocalDate driverBirthDay;
    private Gender driverGender;
}
