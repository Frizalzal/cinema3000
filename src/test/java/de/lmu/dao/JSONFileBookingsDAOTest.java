package de.lmu.dao;

import de.lmu.dao.api.BookingsDao;
import de.lmu.dao.domain.Booking;
import de.lmu.dao.exception.ProcessingException;
import de.lmu.dao.impl.IOFileDecorator;
import de.lmu.dao.impl.JSONFileBookingsDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JSONFileBookingsDAOTest {

    private static final String bookingsJson = """
            [
                {
                  "id": 1,
                  "customerName": "Jack",
                  "showTimestamp": 1682349835,
                  "seats": [1, 2, 3],
                  "movieId": 33
                },
                {
                  "id": 2,
                  "customerName": "Pax",
                  "showTimestamp": 1682349835,
                  "seats": [13, 14],
                  "movieId": 33
                }
            ]""";

    @Test
    public void shouldGetAllBookings() {
        // given
        var fileDecoratorMock = Mockito.mock(IOFileDecorator.class);
        Mockito.when(fileDecoratorMock.readTextFromFile()).thenReturn(bookingsJson);

        BookingsDao dao = new JSONFileBookingsDao(fileDecoratorMock);

        List<Booking> expectedBookings = List.of(
                new Booking(1, "Jack", 1682349835L, List.of(1, 2, 3), 33),
                new Booking(2, "Pax", 1682349835L, List.of(13, 14), 33)
        );
        // when
        List<Booking> bookings = dao.getAllBookings();
        // then
        assertEquals(expectedBookings, bookings);
    }

    @Test
    public void shouldProcessBadJson() {
        // given
        var fileDecoratorMock = Mockito.mock(IOFileDecorator.class);
        Mockito.when(fileDecoratorMock.readTextFromFile()).thenReturn("I AM NOT JSON");

        BookingsDao dao = new JSONFileBookingsDao(fileDecoratorMock);

        // when/then
        assertThrows(ProcessingException.class, dao::getAllBookings);
    }
}
