package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Contrat;

import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat c);
    void supprimerContrat(Long id);
    List<Contrat> recupererContrat();
    Contrat recupererContratParId(Long id);
    Contrat modifierContrat(Contrat c);

}
