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
@ApiModel(description = "User register request model")
public class CreateUserCommand {
    @ApiModelProperty(value = "PolicyNumber", example = "123")
    private String policyNumber;
    @ApiModelProperty(value = "OwnerEmail", example = "yiddu@thoughtworks.com")
    private String ownerEmail;
}
