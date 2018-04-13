package com.adu21.ddd.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "User login request model")
public class UserLoginCommand {
    @ApiModelProperty(value = "Email", example = "yiddu@thoughtworks.com")
    private String email;
    @ApiModelProperty(value = "password", example = "123")
    private String password;
}
