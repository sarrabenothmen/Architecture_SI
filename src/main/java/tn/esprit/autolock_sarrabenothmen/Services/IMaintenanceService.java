package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance m);
    void supprimerMaintenance(Long id);
    List<Maintenance> recupererMaintenance();
    Maintenance recupererMaintenanceParId(Long id);
    Maintenance modifierMaintenance(Maintenance m);

}
