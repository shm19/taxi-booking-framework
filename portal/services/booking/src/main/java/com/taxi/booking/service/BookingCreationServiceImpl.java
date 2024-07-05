package com.taxi.booking.service;

import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.framework.booking.service.AbstractBookingCreationServiceImpl;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.micrometer.core.annotation.Timed;

@Service
public class BookingCreationServiceImpl extends AbstractBookingCreationServiceImpl<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    public BookingCreationServiceImpl() {
        super(
                "http://localhost:10002/api"
        );
    }

    @Override
    protected BaseBookedRequestDTO createBookedRequestDTO() {
        return new BaseBookedRequestDTO();
    }

    @Timed(value = "booking.create.time", description = "Time taken to create a booking")
    @Override
    public BaseBookedRequestDTO createBooking(BaseBookingRequestDTO bookingRequestDTO) {
        userActionLogger.logUserAction(bookingRequestDTO.getUsername(), "create booking");
        return super.createBooking(bookingRequestDTO);
    }

    @Timed(value = "booking.update.time", description = "Time taken to update a booking")
    @Override
    public BaseBookedRequestDTO updateBooking(BaseBookingRequestDTO bookingRequestDTO) {
        userActionLogger.logUserAction(bookingRequestDTO.getUsername(), "update booking");
        return super.updateBooking(bookingRequestDTO);
    }

    @Timed(value = "booking.cancel.time", description = "Time taken to cancel a booking")
    @Override
    public void cancelBooking(String bookingId, String userId) {
        userActionLogger.logUserAction(userId, "cancel booking");
        super.cancelBooking(bookingId, userId);
    }
}
