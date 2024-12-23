package com.library.borrowing;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrowing_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "borrowing_id")
    private Borrowing borrowing;
}
