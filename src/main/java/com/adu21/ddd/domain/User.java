package com.adu21.ddd.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String passWord;
    private String email;

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, userName='%s', passWord='%s', email='%s']",
                id, userName, passWord, email
        );
    }
}
