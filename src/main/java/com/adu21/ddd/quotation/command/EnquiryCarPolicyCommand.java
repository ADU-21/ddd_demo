package com.adu21.ddd.quotation.command;

import com.adu21.ddd.common.Gender;
import com.adu21.ddd.quotation.domain.model.Quotation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EnquiryCarPolicyCommand extends Quotation {

    @NotBlank(message = "productiveYear can not be empty")
    private String productiveYear;

    @NotBlank(message = "carBrand can not be empty")
    private String carBrand;

    @NotBlank(message = "carModel can not be empty")
    private String carModel;

    @NotBlank(message = "parkPlace can not be empty")
    private String parkPlace;

    @NotBlank(message = "distancePreYear can not be empty")
    private String distancePreYear;

    @NotNull(message = "driverBirthDay can not be null")
    private LocalDate driverBirthDay;

    @NotNull(message = "driverGender can not be null")
    private Gender driverGender;
}
