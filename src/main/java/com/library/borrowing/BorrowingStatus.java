package com.library.borrowing;

import com.library.customizedenum.BorrowingStatusType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrowing_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BorrowingStatusType status;

    @OneToOne
    @JoinColumn(name = "borrowing_id")
    private Borrowing borrowing;


}
