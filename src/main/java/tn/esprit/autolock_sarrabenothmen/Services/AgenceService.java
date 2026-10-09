package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.AgenceRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Agence;

import java.util.List;

@Service
@AllArgsConstructor

public class AgenceService  implements IAgenceService{
    private AgenceRepository agenceRepository;
    @Override
    public Agence ajouterAgence(Agence a) {
        return agenceRepository.save(a);
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);


    }

    @Override
    public List<Agence> recupererAgence() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence recupererAgenceParId(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public Agence modifierAgence(Agence a) {
        return agenceRepository.save(a);
    }
}
