package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule v);
    void supprimerVehicule(Long id);
    List<Vehicule> recupererVehicule();
    Vehicule recupererVehiculeParId(Long id);
    Vehicule modifierVehicule(Vehicule v);

}
