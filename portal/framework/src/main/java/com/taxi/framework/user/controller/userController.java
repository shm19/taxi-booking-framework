package com.taxi.user.controller;

import com.taxi.user.dto.UserActionDTO;
import com.taxi.user.dto.BookingDTO;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserActionLogger userActionLogger;

    @PostMapping("/action")
    public ResponseEntity<?> userAction(@RequestBody UserActionDTO userActionDTO) {
        userActionLogger.logUserAction(userActionDTO.getUsername(), userActionDTO.getAction());
        // Perform action logic
        return ResponseEntity.ok("Action recorded");
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookTaxi(@RequestBody BookingDTO bookingDTO) {
        userActionLogger.logUserAction(bookingDTO.getUsername(), "booking taxi");
        // Perform booking logic
        return ResponseEntity.ok("Taxi booked");
    }
}
