package com.adu21.ddd.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(description = "User login request model")
public class UserLoginCommand {

    @NotBlank(message = "email can not be empty")
    @ApiModelProperty(value = "Email", example = "yiddu@thoughtworks.com")
    private String email;

    @NotBlank(message = "password can not be empty")
    @ApiModelProperty(value = "password", example = "password")
    private String password;
}
