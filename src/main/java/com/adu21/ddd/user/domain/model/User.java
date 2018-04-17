package com.adu21.ddd.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    private String uuid;
    private String passWord;
    private String email;

    public boolean isPassWordCorrect(String password) {
        return this.passWord.equals(password);
    }
}
