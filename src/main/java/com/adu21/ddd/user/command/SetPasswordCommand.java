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
@ApiModel(description = "User reset password request model")
public class SetPasswordCommand {
    @ApiModelProperty(value = "Uuid", example = "5007ce96-6507-43a8-86d3-d9a448271c09")
    private String uuid;
    @ApiModelProperty(value = "Password", example = "123")
    private String passWord;
}
