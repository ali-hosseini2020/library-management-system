package com.library.fine;
import com.library.customizedenum.FineStatusType;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "fine_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FineStatusType status;

    @OneToOne
    @JoinColumn(name = "fine_id")
    private Fine fine;
}
