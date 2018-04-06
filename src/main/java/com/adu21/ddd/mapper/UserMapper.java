package com.adu21.ddd.mapper;

import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.model.User;

public class UserMapper extends BaseMapper {
    public UserMapper() {
        classMap(UserRegisterRequestVO.class, User.class)
                .byDefault()
                .register();
    }
}
