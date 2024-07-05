package com.taxi.fleet.service;

import com.taxi.framework.fleet.dto.BaseFleetDriverDTO;
import com.taxi.framework.fleet.dto.BaseFleetUserDTO;
import com.taxi.framework.fleet.service.AbstractFleetService;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FleetServiceImpl extends AbstractFleetService<BaseFleetUserDTO, BaseFleetDriverDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    public FleetServiceImpl() {
        super(
                "http://localhost:10002/api"
        );
    }

    @Override
    public void registerVehicle(BaseFleetUserDTO vehicleDTO) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "register vehicle");
        // Existing logic for registering vehicle
    }

    @Override
    public void updateVehicleStatus(BaseFleetDriverDTO vehicleDTO, String status) {
        userActionLogger.logUserAction(vehicleDTO.getUsername(), "update vehicle status to " + status);
        // Existing logic for updating vehicle status
    }
}
