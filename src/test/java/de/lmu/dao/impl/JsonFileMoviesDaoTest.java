package de.lmu.dao.impl;

import de.lmu.dao.api.MoviesDao;
import de.lmu.dao.domain.Movie;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class JsonFileMoviesDaoTest {

    private static final String moviesJson = """
            [{"id":1,"price":100,"releaseDateTimestamp":1000,"title":"Movie"}]
            """;

    @Test
    void shouldSaveMovie() {
        var fileDecoratorMock = Mockito.mock(IOFileDecorator.class);
        Mockito.when(fileDecoratorMock.readTextFromFile()).thenReturn("[]");

        MoviesDao moviesDao = new JsonFileMoviesDao(fileDecoratorMock);
        moviesDao.saveMovie(new Movie(1, 100, 1000L, "Movie"));
    }
}