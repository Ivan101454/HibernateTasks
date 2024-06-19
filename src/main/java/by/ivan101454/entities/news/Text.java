package by.ivan101454.entities.news;

import by.ivan101454.converter.DurationConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "texts", schema = "leetcode")
public class Text {
    @Id
    @Column(name = "text_id")
    int textId;
    @Column(name = "text_link")
    String textLink;
    @Column(name = "current_solution")
    @Enumerated(value = EnumType.STRING)
    Solution solution;
    @Column(name = "duration_date")
    @Convert(converter = DurationConverter.class)
    private DurationData durationData;

}
