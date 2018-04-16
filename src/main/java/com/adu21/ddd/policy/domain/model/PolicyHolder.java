package com.adu21.ddd.policy.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class PolicyHolder {
    private String id;
    private String name;
    private String email;
    private LocalDate birthDay;
}
