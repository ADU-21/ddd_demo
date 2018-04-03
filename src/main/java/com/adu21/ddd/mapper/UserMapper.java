package com.adu21.ddd.mapper;

import com.adu21.ddd.contract.UserRequestVO;
import com.adu21.ddd.model.User;

public class UserMapper extends BaseMapper {
    public UserMapper() {
        classMap(UserRequestVO.class, User.class)
                .field("username", "userName")
                .byDefault()
                .register();
    }
}
