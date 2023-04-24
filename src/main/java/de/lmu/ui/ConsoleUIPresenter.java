package de.lmu.ui;

import de.lmu.controller.response.CreateBookingResponse;
import de.lmu.dao.domain.Movie;
import de.lmu.controller.request.CreateBookingRequest;

import java.util.List;

/**
 * UI presenter that shows data in terminal
 */
public class ConsoleUIPresenter implements UIPresenter {
    @Override
    public void showAvailableMovies(List<Movie> movies) {

    }

    @Override
    public void showBookingConfirmation(CreateBookingResponse response) {

    }

    @Override
    public CreateBookingRequest parseBookingInfo() {
        return null;
    }
}
