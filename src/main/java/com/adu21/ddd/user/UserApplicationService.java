package com.adu21.ddd.user;

import com.adu21.ddd.exception.UserNotExistException;
import com.adu21.ddd.user.command.CreateUserCommand;
import com.adu21.ddd.user.command.SetPasswordCommand;
import com.adu21.ddd.user.command.UserLoginCommand;
import com.adu21.ddd.user.domain.model.User;
import com.adu21.ddd.user.domain.service.LoginService;
import com.adu21.ddd.user.domain.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    public String register(CreateUserCommand command) {
        return registerService.registration(command.getOwnerEmail(), command.getPolicyNumber());
    }

    public void setPassword(SetPasswordCommand command) {
        User user = userRepository.findByUuid(command.getUuid()).orElseThrow(UserNotExistException::new);
        user.setPassWord(command.getPassWord());
        userRepository.save(user);
    }

    public boolean login(UserLoginCommand command) {
        return loginService.login(command.getEmail(), command.getPassword());
    }
}
