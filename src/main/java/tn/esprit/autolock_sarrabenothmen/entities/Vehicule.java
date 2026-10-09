package tn.esprit.autolock_sarrabenothmen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.esprit.autolock_sarrabenothmen.entities.enums.CategorieVehicule;
import tn.esprit.autolock_sarrabenothmen.entities.enums.StatutVehicule;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;

    private String marque;

    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // Vehicule * ---- 1 Agence
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Agence agence;

    // Vehicule 1 ---- * Maintenance
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Maintenance> maintenances;

    // Vehicule * ---- * Equipement (Vehicule = cote proprietaire)
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Equipement> equipements;

    // Vehicule 1 ---- * Reservation
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations;
}
