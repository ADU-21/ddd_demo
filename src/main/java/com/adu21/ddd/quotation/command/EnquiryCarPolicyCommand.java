package com.adu21.ddd.quotation.command;

import com.adu21.ddd.common.Gender;
import com.adu21.ddd.quotation.domain.model.Quotation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class EnquiryCarPolicyCommand extends Quotation {

    @NotBlank(message = "productiveYear can not be empty")
    @ApiModelProperty(value = "productiveYear", example = "2010-2014")
    private String productiveYear;

    @NotBlank(message = "carBrand can not be empty")
    @ApiModelProperty(value = "carBrand", example = "BMW")
    private String carBrand;

    @NotBlank(message = "carModel can not be empty")
    @ApiModelProperty(value = "carModel", example = "C650")
    private String carModel;

    @NotBlank(message = "parkPlace can not be empty")
    @ApiModelProperty(value = "parkPlace", example = "carport")
    private String parkPlace;

    @NotBlank(message = "distancePreYear can not be empty")
    @ApiModelProperty(value = "distancePreYear", example = "750-1499km")
    private String distancePreYear;

    @NotNull(message = "driverBirthDay can not be null")
    @ApiModelProperty(value = "driverBirthDay", example = "1988-02-02")
    private LocalDate driverBirthDay;

    @NotNull(message = "driverGender can not be null")
    @ApiModelProperty(value = "driverGender", example = "MALE")
    private Gender driverGender;
}
