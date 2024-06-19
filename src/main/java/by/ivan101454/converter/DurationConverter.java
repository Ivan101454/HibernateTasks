package by.ivan101454.converter;

import by.ivan101454.entities.news.DurationData;
import jakarta.persistence.AttributeConverter;


import java.sql.Date;
import java.util.Optional;

public class DurationConverter implements AttributeConverter<DurationData, Date> {

    @Override
    public Date convertToDatabaseColumn(DurationData attribute) {
        return Optional.ofNullable(attribute)
                .map(DurationData::createDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public DurationData convertToEntityAttribute(Date dbData) {
        return Optional.ofNullable(dbData)
                .map(Date::toLocalDate)
                .map(DurationData::new)
                .orElse(null);
    }
}
