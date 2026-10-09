package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement e);
    void supprimerEquipement(Long id);
    List<Equipement> recupererEquipement();
    Equipement recupererEquipementParId(Long id);
    Equipement modifierEquipement(Equipement e);

}
