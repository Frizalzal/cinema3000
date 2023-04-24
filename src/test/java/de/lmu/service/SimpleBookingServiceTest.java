package de.lmu.service;

import de.lmu.dao.api.BookingsDao;
import de.lmu.dao.domain.Booking;
import de.lmu.service.api.BookingService;
import de.lmu.service.impl.SimpleBookingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.eq;

public class SimpleBookingServiceTest {

    @Test
    public void shouldGetAllBookings() {
        // given
        BookingsDao bookingsDao = Mockito.mock(BookingsDao.class);

        BookingService service = new SimpleBookingService(bookingsDao);

        var expectedBooking = new Booking(1, "Customer", 1682008110834L, asList(1, 2, 3), 1);

        // when
        service.bookTicket(1, "Customer", 1682008110834L, asList(1, 2, 3));

        // then
        Mockito.verify(bookingsDao).saveBooking(eq(expectedBooking));
    }
}
