package com.adu21.ddd.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(description = "User register request model")
public class RegistrationCommand {

    @NotBlank(message = "policyNumber Can not be empty")
    @ApiModelProperty(value = "PolicyNumber", example = "123")
    private String policyNumber;

    @NotBlank(message = "ownerEmail Can not be empty")
    @ApiModelProperty(value = "OwnerEmail", example = "yiddu@thoughtworks.com")
    private String ownerEmail;
}
