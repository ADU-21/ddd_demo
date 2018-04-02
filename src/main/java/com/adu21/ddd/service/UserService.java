package com.adu21.ddd.service;

import com.adu21.ddd.domain.User;

public interface UserService {

    boolean userExist(User user);

    boolean saveUser(User user);

    User findUserByToken(String token);

    User findUserByName(String userName);

    boolean verifyPassword(User user, String password);

    boolean userNameExist(String username);
}
