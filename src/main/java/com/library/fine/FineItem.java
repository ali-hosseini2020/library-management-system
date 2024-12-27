package com.library.fine;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "fine_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "fine_id")
    private Fine fine;
}
