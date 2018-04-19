package com.adu21.ddd.policy.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateHomePolicyCommand {

    @NotBlank(message = "startData can not be empty")
    @ApiModelProperty(value = "startDate", example = "2018-01-01")
    private LocalDate startDate;

    @NotBlank(message = "quoteId can not be empty")
    @ApiModelProperty(value = "quoteId", example = "b0c83be5-c9bf-4ac4-bc5d-120af78afd7f")
    private String quoteId;

    @NotNull(message = "holderBirthday can not be null")
    @ApiModelProperty(value = "holderBirthday", example = "1999-11-11")
    private LocalDate holderBirthday;

    @NotBlank(message = "holderEmail can not be empty")
    @ApiModelProperty(value = "holderEmail", example = "email")
    private String holderEmail;

    @NotBlank(message = "quoteId can not be empty")
    @ApiModelProperty(value = "holderId", example = "id")
    private String holderId;

    @NotBlank(message = "holderName can not be empty")
    @ApiModelProperty(value = "holderName", example = "holderName")
    private String holderName;
}
