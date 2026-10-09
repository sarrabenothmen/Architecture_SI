package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.VehiculeRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Vehicule;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService {
    private VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public List<Vehicule> recupererVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule recupererVehiculeParId(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule v) {
        return vehiculeRepository.save(v);
    }
}
