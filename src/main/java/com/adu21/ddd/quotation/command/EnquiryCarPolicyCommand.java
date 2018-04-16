package com.adu21.ddd.quotation.command;

import com.adu21.ddd.model.Gender;
import com.adu21.ddd.quotation.domain.model.Quotation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EnquiryCarPolicyCommand extends Quotation {
    private String productiveYear;
    @NotNull
    private String carBrand;
    private String carModel;
    private String parkPlace;
    private String distancePreYear;
    private LocalDate driverBirthDay;
    private Gender driverGender;
}
