package com.taxi.user.service;

import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.framework.user.service.SignupService;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;

@Service
@Qualifier("SignupService")
public class SignupServiceImpl implements SignupService<BaseUserSignupDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Override
    @Timed(value = "pricing.signup", description = "Tracks the time taken to signup user")
    public BaseUserSignupDTO signUp(BaseUserSignupDTO dto) {
        userActionLogger.logUserAction(dto.getUsername(), "signup");
        return dto;
    }
}
