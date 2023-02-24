package de.lmu.domain;

import java.util.List;

public class Theater {
    private final int numberOfSeats;
    private final List<Movie> movies;

    public Theater(int numberOfSeats, List<Movie> movies) {
        this.numberOfSeats = numberOfSeats;
        this.movies = movies;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
