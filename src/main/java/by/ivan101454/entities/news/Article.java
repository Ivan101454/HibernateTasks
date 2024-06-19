package by.ivan101454.entities.news;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "articles", schema = "leetcode")
public class Article {
    @Id
    @Column(name = "article_id")
    int articleId;
    @Column(name = "article_name")
    String articleName;
    @Column(name = "article_text")
    Text articleText;
    @Column(name = "article_picture")
    Picture articlePicture;
    @Column(name = "article_author")
    String articleAuthor;
    @Column(name = "date")
    LocalDate localDate;
}
