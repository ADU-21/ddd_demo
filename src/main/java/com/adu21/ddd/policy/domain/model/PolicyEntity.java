package com.adu21.ddd.policy.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PolicyEntity {
    @Id
    private String policyNumber;
    private String ownerEmail;
}
