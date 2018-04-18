package com.adu21.ddd.quotation.command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EnquiryHomePolicyCommand {

    @NotBlank(message = "buildingMaterial can not be empty")
    private String buildingMaterial;

    @NotBlank(message = "buildingType can not be empty")
    private String buildingType;

    @NotBlank(message = "numberOfRooms can not be empty")
    private String numberOfRooms;
}
