package com.adu21.ddd.mapper;

import com.adu21.ddd.user.command.CreateUserCommand;
import com.adu21.ddd.user.domain.model.User;

public class UserMapper extends BaseMapper {
    public UserMapper() {
        classMap(CreateUserCommand.class, User.class)
                .byDefault()
                .register();
    }
}
