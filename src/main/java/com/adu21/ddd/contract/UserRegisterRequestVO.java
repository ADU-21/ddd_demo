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
@ApiModel(description = "User register request model")
public class UserRegisterRequestVO {
    @ApiModelProperty(value = "PolicyNumber", example = "NOP123456789")
    private String policyNumber;
    @ApiModelProperty(value = "Email", example = "yiddu@thoughtworks.com")
    private String email;
}
