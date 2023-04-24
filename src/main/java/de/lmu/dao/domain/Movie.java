package de.lmu.dao.domain;

import java.time.LocalDateTime;

public record Movie(int id,1
                    int price,
                    long releaseDateTimestamp,
                    String title) {
}
