package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.ContratRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Contrat;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    private ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void supprimerContrat(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public List<Contrat> recupererContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat recupererContratParId(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat modifierContrat(Contrat c) {
        return contratRepository.save(c);
    }
}
