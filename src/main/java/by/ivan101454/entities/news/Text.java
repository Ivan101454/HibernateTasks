package by.ivan101454.entities.news;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
