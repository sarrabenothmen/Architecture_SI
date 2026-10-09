package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe e);
    void supprimerEmploye(Long id);
    List<Employe> recupererEmploye();
    Employe recupererEmployeParId(Long id);
    Employe modifierEmploye(Employe e);

}
