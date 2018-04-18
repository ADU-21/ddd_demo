package com.adu21.ddd.policy.command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateCarPolicyCommand {

    @NotBlank(message = "quoteId can not be empty")
    private String quoteId;

    @NotNull(message = "holderBirthday can not be empty")
    private LocalDate holderBirthday;

    @NotBlank(message = "holderEmail can not be empty")
    private String holderEmail;

    @NotBlank(message = "holderEmail can not be empty")
    private String holderId;

    @NotBlank(message = "holderEmail can not be empty")
    private String holderName;
}
