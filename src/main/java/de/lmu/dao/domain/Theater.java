package de.lmu.dao.domain;

import java.util.List;

public record Theater(int numberOfSeats,
                      List<Movie> movies) {
}
