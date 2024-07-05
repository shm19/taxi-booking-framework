package com.taxi.user.service;

import com.taxi.user.dto.ExtendedUserSigninDTO;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("AuthService")
public class ExtendedAuthServiceImpl implements ExtendedAuthService {

    @Autowired
    private UserActionLogger userActionLogger;

    @Override
    public ExtendedUserSigninDTO signIn(ExtendedUserSigninDTO dto) {
        userActionLogger.logUserAction(dto.getUsername(), "authentication attempt");
        // Preserving existing logic
        return dto;
    }
}
