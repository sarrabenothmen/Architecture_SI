package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement p);
    void supprimerPaiement(Long id);
    List<Paiement> recupererPaiement();
    Paiement recupererPaiementParId(Long id);
    Paiement modifierPaiement(Paiement p);

}
