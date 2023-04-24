package de.lmu.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import de.lmu.dao.api.BookingsDao;
import de.lmu.dao.domain.Booking;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.lmu.dao.exception.ProcessingException;


public class JSONFileBookingsDao implements BookingsDao {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JavaType bookingsListType = objectMapper
            .getTypeFactory()
            .constructCollectionType(List.class, Booking.class);

    private final IOFileDecorator bookingsFileDecorator;

    public JSONFileBookingsDao(IOFileDecorator bookingsFile) {
        this.bookingsFileDecorator = bookingsFile;
    }

    @Override
    public List<Booking> getAllBookingsByMovieIdAndShowTime(int movieId, long showTimestamp) {
        return getAllBookings().stream()
                .filter(b -> b.movieId() == movieId && b.showTimestamp() == showTimestamp)
                .toList();
    }

    @Override
    public List<Booking> getAllBookings() {
        try {
            String bookingsStr = bookingsFileDecorator.readTextFromFile();
            return objectMapper.readValue(bookingsStr, bookingsListType);
        } catch (JsonProcessingException e) {
            throw new ProcessingException("Cannot read bookings file: " + e.getMessage());
        }
    }

    @Override
    public void saveBooking(Booking booking) {
        List<Booking> allBookings = getAllBookings();
        allBookings.add(booking);

        try {
            String allBookingsStr = objectMapper.writeValueAsString(allBookings);
            bookingsFileDecorator.saveTextToFile(allBookingsStr);
        } catch (JsonProcessingException e) {
            throw new ProcessingException("Cannot save bookings file: " + e.getMessage());
        }
    }
}
