package com.library.fine;
import com.library.customizedenum.FineStatusType;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fine_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fine_id")
    private Fine fine;

    private LocalDateTime actionDate;

    @Enumerated(EnumType.STRING)
    private FineStatusType status;

    private String notes;
}
