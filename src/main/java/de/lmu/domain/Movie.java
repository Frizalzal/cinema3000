package de.lmu.domain;

import java.time.LocalDateTime;

public class Movie {
    private final int id;
    private final int price;
    private final LocalDateTime releaseDate;
    private final String title;

    public Movie(int id, int price, LocalDateTime releaseDate, String title) {
        this.id = id;
        this.price = price;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                '}';
    }

}
