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
@ApiModel(description = "User register response model")
public class UserResponseVO {
    @ApiModelProperty(value = "Uuid", example = "c91ff739-f623-45c0-9686-393c03878768")
    private String uuid;
}
