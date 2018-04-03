package com.adu21.ddd.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestVO {
    private String username;
    private String email;
    private String password;
    private String token;
}
