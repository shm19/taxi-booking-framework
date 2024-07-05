package com.taxi.dispatch.service;

import com.taxi.framework.dispatch.dto.BaseDriverDTO;
import com.taxi.framework.dispatch.dto.BaseUserDTO;
import com.taxi.framework.dispatch.service.AbstractFindCarService;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;

@Service
public class FindCarServiceImpl extends AbstractFindCarService<BaseUserDTO, BaseDriverDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    public FindCarServiceImpl() {
        super(
                "http://localhost:10003/api",
                "http://localhost:10001/api"
        );
    }

    @Timed(value = "find_car.assign_driver", description = "Tracks the time taken to assign a driver to a booking")
    @Override
    public void assignDriver(BaseDriverDTO driverDTO, String bookingId) {
        userActionLogger.logUserAction(driverDTO.getDriverId(), "assign driver to booking " + bookingId);
        // Existing logic for assigning driver
    }

    @Timed(value = "find_car.update_driver_location", description = "Tracks the time taken to update driver location")
    @Override
    public void updateDriverLocation(BaseDriverDTO driverDTO, String location) {
        userActionLogger.logUserAction(driverDTO.getDriverId(), "update driver location to " + location);
        // Existing logic for updating driver location
    }
}
