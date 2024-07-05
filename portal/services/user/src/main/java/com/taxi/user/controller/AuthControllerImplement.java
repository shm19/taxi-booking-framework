package com.taxi.user.controller;

import com.taxi.user.dto.ExtendedUserSigninDTO;
import com.taxi.framework.user.controller.AbstractAuthController;
import com.taxi.user.logging.UserActionLogger;
import com.taxi.user.service.ExtendedAuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/user")
@RestController
public class AuthControllerImplement extends AbstractAuthController<ExtendedUserSigninDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private ExtendedAuthServiceImpl extendedAuthService;

    public AuthControllerImplement(ExtendedAuthServiceImpl extendedAuthService, UserActionLogger userActionLogger) {
        super(extendedAuthService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        userActionLogger.logUserAction(userLoginDTO.getUsername(), "login attempt");
        // Perform login logic
        return ResponseEntity.ok("User logged in");
    }
}
