package com.adu21.ddd.quote.command;

import com.adu21.ddd.model.Gender;
import com.adu21.ddd.quote.domain.model.Quotation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnquiryCarPolicyCommand extends Quotation {
    private String productiveYear;
    private String carBrand;
    private String carModel;
    private String parkPlace;
    private String distancePreYear;
    private LocalDate driverBirthDay;
    private Gender driverGender;
}
