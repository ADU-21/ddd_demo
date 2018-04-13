package com.adu21.ddd.policy.domain.model;

import com.adu21.ddd.quote.domain.model.Quotation;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;

@Getter
@Setter
public class Policy {
    protected static final double BASE_PREMIUM = 100.00;
    private String policyNumber;
    private Data startDate;
    private Quotation quotation;
    private PolicyHolder policyHolder;
}
