package de.lmu.dao.api;

import de.lmu.dao.domain.Movie;

import java.util.List;

public interface MoviesDao {
    List<Movie> getAllMovies();

    void saveMovie(Movie movie);
}
