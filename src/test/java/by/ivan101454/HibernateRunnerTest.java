package by.ivan101454;

import by.ivan101454.entities.Visit;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HibernateRunnerTest {
    @Test
    void checkReflectionApi() throws SQLException, IllegalAccessException {
        Visit visit = Visit.builder()
                .customerId(54)
                .visitId(9)
                .build();

        String sql = """
                INSERT
                INTO
                %s
                (%s)
                VALUES
                (%s)
                """;

        String tableName = Optional.ofNullable(visit.getClass().getAnnotation(Table.class))
                .map(tableAnnotation -> tableAnnotation.schema() + "." + tableAnnotation.name())
                .orElse(visit.getClass().getName());

        Field[] declaredFields = visit.getClass().getDeclaredFields();

        String columnNames = Arrays.stream(declaredFields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName()))
                .collect(Collectors.joining(", "));

        String columnValues = Arrays.stream(declaredFields)
                .map(x -> "?")
                .collect(Collectors.joining(", "));


        System.out.println(sql.formatted(tableName, columnNames, columnValues));

        Connection connection = null;
        PreparedStatement preparedStatement = connection.prepareStatement(sql.formatted(tableName, columnNames, columnValues));

        for (Field declaredField: declaredFields) {
            declaredField.setAccessible(true);
            preparedStatement.setObject(1, declaredField.get(visit));
        }


    }

}