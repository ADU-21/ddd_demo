package com.adu21.ddd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String token;

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, userName='%s', email='%s']",
                id, userName, email
        );
    }
}
