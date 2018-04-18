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
    @ApiModelProperty(value = "Uuid", example = "5007ce96-6507-43a8-86d3-d9a448271c09")
    private String uuid;

    @NotBlank(message = "password can not be empty")
    @ApiModelProperty(value = "Password", example = "123")
    private String password;
}
