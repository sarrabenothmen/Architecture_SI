package tn.esprit.autolock_sarrabenothmen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;

    private BigDecimal montantTotal;

    private Boolean valide;

    // Contrat 1 ---- 1 Reservation (Contrat = cote proprietaire)
    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Reservation reservation;

    // Contrat 1 <>---- * Paiement (composition)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Paiement> paiements;
}
