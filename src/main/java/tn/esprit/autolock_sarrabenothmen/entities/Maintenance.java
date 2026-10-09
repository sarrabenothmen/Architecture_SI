package tn.esprit.autolock_sarrabenothmen.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private String description;

    // Maintenance * ---- 1 Vehicule
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicule vehicule;
}
