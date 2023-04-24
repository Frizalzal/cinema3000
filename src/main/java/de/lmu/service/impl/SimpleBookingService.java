package de.lmu.service.impl;

import de.lmu.dao.api.BookingsDao;
import de.lmu.dao.domain.Booking;
import de.lmu.dao.exception.ProcessingException;
import de.lmu.service.api.BookingService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleBookingService implements BookingService {

    private final BookingsDao bookingsDao;

    public SimpleBookingService(BookingsDao bookingsDao) {
        this.bookingsDao = bookingsDao;
    }

    @Override
    public void bookTicket(int movieId, String customerName, long showTime, List<Integer> seats) {
        var currentBookings = bookingsDao.getAllBookingsByMovieIdAndShowTime(movieId, showTime);

        checkSeatsAvailable(currentBookings, seats);

        bookingsDao.saveBooking(new Booking(generateIdForNewBooking(), customerName, showTime, seats, movieId));
    }

    /**
     * Check that in given bookings list provided seats aren't taken
     *
     * @param bookings - list of bookings to check
     * @param seats    - list of seats that should be checked for occupation
     */
    private void checkSeatsAvailable(List<Booking> bookings, List<Integer> seats) {
        var takenSeats = bookings.stream()
                .filter(booking -> booking.seats().stream().anyMatch(seats::contains))
                .toList();

        if (!takenSeats.isEmpty()) {
            throw new ProcessingException("Cannot make booking, seats are already taken: " + takenSeats);
        }
    }

    /**
     * Generate a new ID for a booking object
     * by retrieving the existing bookings from DAO,
     * finding the maximum ID among those bookings, and incrementing that ID by one.
     * If there are no existing bookings,
     * the method returns the integer 1 as the ID for the new booking.
     *
     */
    private int generateIdForNewBooking() {
        return bookingsDao.getAllBookings()
                .stream()
                .max(Comparator.comparingInt(Booking::id))
                .map(booking -> booking.id() + 1)
                .orElse(1);
    }
}
