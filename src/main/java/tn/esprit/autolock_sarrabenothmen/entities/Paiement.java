package tn.esprit.autolock_sarrabenothmen.entities;

import tn.esprit.autolock_sarrabenothmen.entities.enums.ModePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    // Paiement * ---- 1 Contrat
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;
}
