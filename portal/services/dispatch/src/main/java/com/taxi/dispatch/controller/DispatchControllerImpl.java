package com.taxi.dispatch.controller;

import com.taxi.dispatch.service.FindCarServiceImpl;
import com.taxi.framework.dispatch.controller.AbstractFindCarController;
import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/dispatch")
@RestController
public class DispatchControllerImpl extends AbstractFindCarController<BaseUserDTO, BaseDriverDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private FindCarServiceImpl findCarService;

    protected DispatchControllerImpl(FindCarServiceImpl findCarService, UserActionLogger userActionLogger) {
        super(findCarService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assignDriver(@RequestBody BaseDriverDTO driverDTO, @RequestParam String bookingId) {
        userActionLogger.logUserAction(driverDTO.getDriverId(), "assign driver to booking " + bookingId);
        findCarService.assignDriver(driverDTO, bookingId);
        return ResponseEntity.ok("Driver assigned");
    }

    @PutMapping("/update-location")
    public ResponseEntity<?> updateDriverLocation(@RequestBody BaseDriverDTO driverDTO, @RequestParam String location) {
        userActionLogger.logUserAction(driverDTO.getDriverId(), "update driver location to " + location);
        findCarService.updateDriverLocation(driverDTO, location);
        return ResponseEntity.ok("Driver location updated");
    }
}
