package com.adu21.ddd.mapper;

import com.adu21.ddd.command.UserRegisterRequestCommand;
import com.adu21.ddd.model.User;

public class UserMapper extends BaseMapper {
    public UserMapper() {
        classMap(UserRegisterRequestCommand.class, User.class)
                .byDefault()
                .register();
    }
}
