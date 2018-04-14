package com.adu21.ddd.policy.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Policy {
    private String policyNumber = UUID.randomUUID().toString();
    private LocalDate startDate;
    private String quoteId;
    private PolicyHolder policyHolder;
}
