package de.lmu.domain;

import java.time.LocalDateTime;

public class Booking {
    private final int id;
    private final String customerName;
    private final LocalDateTime dateTime;
    private final int movieId;

    public Booking(int id, String customerName, LocalDateTime dateTime, int movieId) {
        this.id = id;
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getMovieId() {
        return movieId;
    }
}
