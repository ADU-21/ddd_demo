package com.adu21.ddd.policy.domain.model;

import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.mapper.HomePolicyMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomePolicy extends Policy {
    private String buildingMaterial;
    private String buildingType;
    private String numberOfRooms;
}
