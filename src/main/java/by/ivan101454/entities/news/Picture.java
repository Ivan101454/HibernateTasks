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
@Table(name = "pictures", schema = "leetcode")
public class Picture {
    @Id
    @Column(name = "picture_id")
    int pictureId;
    @Column(name = "picture_link")
    String pictureLink;

}
