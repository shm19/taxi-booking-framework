package com.taxi.fleet.service;

import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.framework.fleet.service.AbstractFleetService;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;


@Service
public class FleetServiceImpl extends AbstractFleetService<BaseFleetUserDTO, BaseFleetDriverDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    public FleetServiceImpl() {
        super(
                "http://localhost:10002/api"
        );
    }

    @Timed(value = "fleet.register_vehicle", description = "Tracks the time taken to register a vehicle")
    @Override
    public void registerVehicle(BaseFleetUserDTO vehicleDTO) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "register vehicle");
        // Existing logic for registering vehicle
    }

    @Timed(value = "fleet.update_vehicle_status", description = "Tracks the time taken to update vehicle status")
    @Override
    public void updateVehicleStatus(BaseFleetDriverDTO vehicleDTO, String status) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "update vehicle status to " + status);
        // Existing logic for updating vehicle status
    }
}
