package com.adu21.ddd.user;

import com.adu21.ddd.exception.UserNotExistException;
import com.adu21.ddd.user.command.CreateUserCommand;
import com.adu21.ddd.user.command.SetPasswordCommand;
import com.adu21.ddd.user.command.UserLoginCommand;
import com.adu21.ddd.user.domain.model.User;
import com.adu21.ddd.user.domain.service.LoginService;
import com.adu21.ddd.user.domain.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    private static Logger logger = LoggerFactory.getLogger(UserApplicationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    public String register(CreateUserCommand command) {
        logger.info("Create user with email [{}]", command.getOwnerEmail());
        return registerService.registration(command.getOwnerEmail(), command.getPolicyNumber());
    }

    public void setPassword(SetPasswordCommand command) {
        logger.info("Set password with uuid [{}]", command.getUuid());
        User user = userRepository.findByUuid(command.getUuid()).orElseThrow(UserNotExistException::new);
        user.setPassWord(command.getPassWord());
        logger.info("Set password success with uuid[{}]", command.getUuid());
        userRepository.save(user);
    }

    public boolean login(UserLoginCommand command) {
        logger.info("User login with email [{}]", command.getEmail());
        return loginService.login(command.getEmail(), command.getPassword());
    }
}
