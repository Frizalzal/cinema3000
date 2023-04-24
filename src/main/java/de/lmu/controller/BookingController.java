package de.lmu.controller;

import de.lmu.controller.response.CreateBookingResponse;
import de.lmu.service.api.BookingService;
import de.lmu.controller.request.CreateBookingRequest;

public class BookingController {

    BookingService bookingService = null;

    // Controller accepts request
    public CreateBookingResponse makeBooking(CreateBookingRequest bookingRequest) {
        bookingService.bookTicket(bookingRequest.movieId(),
                bookingRequest.customerName(),
                bookingRequest.showTimestamp(),
                bookingRequest.seats()
        );
        return null;
    }
}
