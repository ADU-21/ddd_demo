package com.adu21.ddd.policy.command;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateCarPolicyCommand {

    @NotBlank(message = "startData can not be empty")
    @ApiModelProperty(value = "startDate", example = "2018-01-01")
    private LocalDate startDate;

    @NotBlank(message = "quoteId can not be empty")
    @ApiModelProperty(value = "quoteId", example = "22e5b597-3c81-49f6-a245-c917e458874f")
    private String quoteId;

    @NotNull(message = "holderBirthday can not be empty")
    @ApiModelProperty(value = "holderBirthday", example = "1999-11-11")
    private LocalDate holderBirthday;

    @NotBlank(message = "holderEmail can not be empty")
    @ApiModelProperty(value = "holderEmail", example = "email")
    private String holderEmail;

    @NotBlank(message = "holderEmail can not be empty")
    @ApiModelProperty(value = "holderId", example = "id")
    private String holderId;

    @NotBlank(message = "holderEmail can not be empty")
    @ApiModelProperty(value = "holderName", example = "holderName")
    private String holderName;
}
