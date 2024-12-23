package com.library.borrowing;

import com.library.customizedenum.BorrowingStatusType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "borrowings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime borrowingDate;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private BorrowingStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private BorrowingUser user;

    @OneToMany(mappedBy = "borrowing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowingItem> items;

    @OneToMany(mappedBy = "borrowing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowingHistory> history;
}
