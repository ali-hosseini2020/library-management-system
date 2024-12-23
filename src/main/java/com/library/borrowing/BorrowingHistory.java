package com.library.borrowing;
import com.library.customizedenum.BorrowingStatusType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrowing_id")
    private Borrowing borrowing;

    private LocalDateTime actionDate;

    @Enumerated(EnumType.STRING)
    private BorrowingStatusType status;

    private String notes;
}
