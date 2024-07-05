package com.taxi.booking.controller;

import com.taxi.booking.service.BookingCreationServiceImpl;
import com.taxi.framework.booking.controller.AbstractBookingController;
import com.taxi.framework.booking.dto.BaseBookedRequestDTO;
import com.taxi.framework.booking.dto.BaseBookingRequestDTO;
import com.taxi.user.logging.UserActionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/booking")
@RestController
public class BookingControllerImpl extends AbstractBookingController<BaseBookingRequestDTO, BaseBookedRequestDTO> {

    @Autowired
    private UserActionLogger userActionLogger;

    @Autowired
    private BookingCreationServiceImpl bookingCreationService;

    protected BookingControllerImpl(BookingCreationServiceImpl bookingCreationService, UserActionLogger userActionLogger) {
        super(bookingCreationService);
        this.userActionLogger = userActionLogger;
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BaseBookingRequestDTO bookingRequestDTO) {
        userActionLogger.logUserAction(bookingRequestDTO.getUsername(), "create booking");
        BaseBookedRequestDTO bookedRequestDTO = bookingCreationService.createBooking(bookingRequestDTO);
        return ResponseEntity.ok(bookedRequestDTO);
    }

    @PutMapping
    public ResponseEntity<?> updateBooking(@RequestBody BaseBookingRequestDTO bookingRequestDTO) {
        userActionLogger.logUserAction(bookingRequestDTO.getUsername(), "update booking");
        BaseBookedRequestDTO bookedRequestDTO = bookingCreationService.updateBooking(bookingRequestDTO);
        return ResponseEntity.ok(bookedRequestDTO);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable String bookingId, @RequestParam String userId) {
        userActionLogger.logUserAction(userId, "cancel booking");
        bookingCreationService.cancelBooking(bookingId, userId);
        return ResponseEntity.ok("Booking cancelled");
    }
}
