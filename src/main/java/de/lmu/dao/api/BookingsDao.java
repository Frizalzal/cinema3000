package de.lmu.dao.api;

import de.lmu.dao.domain.Booking;

import java.util.List;


public interface BookingsDao {

    List<Booking> getAllBookingsByMovieIdAndShowTime(int movieId, long showTimestamp);

    List<Booking> getAllBookings();

    void saveBooking(Booking booking);
}
