package com.adu21.ddd.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(description = "User reset password request model")
public class SetPasswordCommand {

    @NotBlank(message = "uuid can not be empty")
    @ApiModelProperty(value = "Uuid", example = "2")
    private String uuid;

    @NotBlank(message = "password can not be empty")
    @ApiModelProperty(value = "Password", example = "123")
    private String password;
}
