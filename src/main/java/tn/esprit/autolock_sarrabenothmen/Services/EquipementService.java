package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.EquipementRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Equipement;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementService implements IEquipementService {
    private EquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement e) {
        return equipementRepository.save(e);
    }

    @Override
    public void supprimerEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public List<Equipement> recupererEquipement() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement recupererEquipementParId(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public Equipement modifierEquipement(Equipement e) {
        return equipementRepository.save(e);
    }
}
