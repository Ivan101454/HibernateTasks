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
@Table(name = "transactions", schema = "leetcode")
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "visit_id")
    private int visitId;
    private int values;
}
