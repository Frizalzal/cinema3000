package de.lmu.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.lmu.dao.api.MoviesDao;
import de.lmu.dao.domain.Booking;
import de.lmu.dao.domain.Movie;
import de.lmu.dao.exception.ProcessingException;

import java.util.ArrayList;
import java.util.List;

public class JsonFileMoviesDao implements MoviesDao {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JavaType moviesListType = objectMapper
            .getTypeFactory()
            .constructCollectionType(List.class, Movie.class);

    private final IOFileDecorator moviesFileDecorator;

    public JsonFileMoviesDao(IOFileDecorator moviesFileDecorator) {
        this.moviesFileDecorator = moviesFileDecorator;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public void saveMovie(Movie movie) {
        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(movie);

        try {
            String allMoviesStr = objectMapper.writeValueAsString(allMovies);
            moviesFileDecorator.saveTextToFile(allMoviesStr);
        } catch (JsonProcessingException e) {
            throw new ProcessingException("Cannot save bookings file: " + e.getMessage());
        }
    }
}
