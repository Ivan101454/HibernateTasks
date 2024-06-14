package by.ivan101454.entities;

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
@Table(name = "visits", schema = "leetcode")
public class Visit {
    @Id
    @Column(name = "visit_id")
    private int visitId;
    @Column(name = "customer_id")
    private int customerId;
}
