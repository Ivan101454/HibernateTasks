package by.ivan101454.entities.news;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record DurationData(LocalDate createDate) {
    @Override
    public LocalDate createDate() {
        return createDate;
    }

    public long getDuration() {
        return ChronoUnit.DAYS.between(createDate, LocalDate.now());
    }
}
