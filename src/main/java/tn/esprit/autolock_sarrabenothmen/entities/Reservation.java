package tn.esprit.autolock_sarrabenothmen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.autolock_sarrabenothmen.entities.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // Reservation * ---- 1 Vehicule
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicule vehicule;

    // Reservation * ---- 1 Client
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;

    // Reservation 1 ---- 1 Contrat
    @OneToOne(mappedBy = "reservation")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;
}
