package de.lmu.service.api;

import java.util.List;

public interface BookingService {

    void bookTicket(int movieId, String customerName, long showTime, List<Integer> seats);

}
