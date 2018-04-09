package com.adu21.ddd.model;

import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.mapper.HomePolicyMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Random;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HomePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int policyNumber;
    private String ownerEmail;
    private Date startDate;
    private String buildingMaterial;
    private String buildingType;
    private int numberOfRooms;
    private double price;
    private String quoteId;
    private Date holderBirthday;
    private String holderEmail;
    private String holderId;

    public HomePolicy apply(CreateHomePolicyCommand createHomePolicyCommand) {
        HomePolicyMapper homePolicyMapper = new HomePolicyMapper();
        return homePolicyMapper.map(createHomePolicyCommand, HomePolicy.class);
    }
}
