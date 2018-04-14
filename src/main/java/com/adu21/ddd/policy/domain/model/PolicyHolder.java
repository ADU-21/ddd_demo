package com.adu21.ddd.policy.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PolicyHolder {
    private String id;
    private String name;
    private String email;
    private LocalDate birthDay;
}
