package de.lmu.dao.domain;

import java.util.List;

public record Booking(int id,
                      String customerName,
                      long showTimestamp,
                      List<Integer> seats,
                      int movieId) {
}
