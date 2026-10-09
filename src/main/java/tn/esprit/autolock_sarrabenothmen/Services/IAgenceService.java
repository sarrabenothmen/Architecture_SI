package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Agence;

import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence a);
    void supprimerAgence(Long id);
    List<Agence> recupererAgence();
    Agence recupererAgenceParId(Long id);
    Agence modifierAgence(Agence a);

}
