package de.lmu.ui;

import de.lmu.controller.response.CreateBookingResponse;
import de.lmu.dao.domain.Movie;
import de.lmu.controller.request.CreateBookingRequest;

import java.util.List;

public interface UIPresenter {

    void showAvailableMovies(List<Movie> movies);

    void showBookingConfirmation(CreateBookingResponse response);

    CreateBookingRequest parseBookingInfo();
}
