package com.adu21.ddd.contract;

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
@ApiModel(description = "User request model")
public class UserRequestVO {
    @ApiModelProperty(value = "Name", example = "Yidong")
    private String username;
    @ApiModelProperty(value = "Email", example = "yiddu@thoughtworks.com")
    private String email;
    @ApiModelProperty(value = "Password", example = "Password")
    private String password;
    @ApiModelProperty(value = "Token", example = "c91ff739-f623-45c0-9686-393c03878768")
    private String token;
}
