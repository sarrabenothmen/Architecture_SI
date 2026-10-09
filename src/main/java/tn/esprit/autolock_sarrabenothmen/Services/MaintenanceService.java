package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.MaintenanceRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Maintenance;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceService implements IMaintenanceService {
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }

    @Override
    public void supprimerMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public List<Maintenance> recupererMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance recupererMaintenanceParId(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }
}
