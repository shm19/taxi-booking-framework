package com.taxi.fleet.controller;

import com.taxi.fleet.service.FleetServiceImpl;
import com.taxi.framework.fleet.controller.AbstractFleetController;
import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/fleet")
@RestController
public class FleetControllerImpl extends AbstractFleetController<BaseFleetUserDTO, BaseFleetDriverDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private FleetServiceImpl fleetService;

    protected FleetControllerImpl(FleetServiceImpl fleetService, UserActionLogger userActionLogger) {
        super(fleetService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVehicle(@RequestBody BaseFleetUserDTO vehicleDTO) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "register vehicle");
        fleetService.registerVehicle(vehicleDTO);
        return ResponseEntity.ok("Vehicle registered");
    }

    @PutMapping("/update-status")
    public ResponseEntity<?> updateVehicleStatus(@RequestBody BaseFleetDriverDTO vehicleDTO, @RequestParam String status) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "update vehicle status to " + status);
        fleetService.updateVehicleStatus(vehicleDTO, status);
        return ResponseEntity.ok("Vehicle status updated");
    }
}
