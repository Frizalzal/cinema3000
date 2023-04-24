package de.lmu.controller.request;

import java.util.List;

public record CreateBookingRequest(int movieId,
                                   String customerName,
                                   int showTimestamp,
                                   List<Integer> seats) {
}
