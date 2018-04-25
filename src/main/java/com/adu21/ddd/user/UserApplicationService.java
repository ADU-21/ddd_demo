package com.adu21.ddd.user;

import com.adu21.ddd.user.exception.UserNotExistException;
import com.adu21.ddd.user.command.RegisterCommand;
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

    public String register(RegisterCommand command) {
        User user = registerService.createUser(command.getOwnerEmail(), command.getPolicyNumber());
        logger.info("Create user with email [{}]", command.getOwnerEmail());
        return user.getUuid();
    }

    public void initialPassword(SetPasswordCommand command) {
        User user = userRepository.findByUuid(command.getUuid()).orElseThrow(UserNotExistException::new);
        user.setPassWord(command.getPassword());
        logger.info("Set password with uuid[{}]", command.getUuid());
        userRepository.save(user);
    }

    public boolean login(UserLoginCommand command) {
        boolean loginSuccess = loginService.login(command.getEmail(), command.getPassword());
        logger.info("User login with email [{}]", command.getEmail());
        return loginSuccess;
    }
}
