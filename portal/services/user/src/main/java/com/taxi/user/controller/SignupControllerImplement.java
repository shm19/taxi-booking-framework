package com.taxi.user.controller;

import com.taxi.framework.user.controller.AbstractSignupController;
import com.taxi.framework.user.dto.BaseUserSignupDTO;
import com.taxi.user.logging.UserActionLogger;
import com.taxi.user.service.SignupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/user")
@RestController
public class SignupControllerImplement extends AbstractSignupController<BaseUserSignupDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private SignupServiceImpl signupService;

    protected SignupControllerImplement(SignupServiceImpl signupService, UserActionLogger userActionLogger) {
        super(signupService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody BaseUserSignupDTO userSignupDTO) {
        userActionLogger.logUserAction(userSignupDTO.getUsername(), "signup attempt");
        BaseUserSignupDTO signedUpUser = signupService.signUp(userSignupDTO);
        return ResponseEntity.ok(signedUpUser);
    }
}
