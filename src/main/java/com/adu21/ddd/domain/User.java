package com.adu21.ddd.domain;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String passWord;
}
