package com.library.fine;
import com.library.customizedenum.FineStatusType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime issueDate;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private FineStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FineUser user;

    @OneToMany(mappedBy = "fine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FineItem> items;

    @OneToMany(mappedBy = "fine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FineHistory> history;
}
