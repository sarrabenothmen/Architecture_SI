package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.PaiementRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Paiement;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementService implements IPaiementService {
    private PaiementRepository paiementRepository;

    @Override
    public Paiement ajouterPaiement(Paiement p) {
        return paiementRepository.save(p);
    }

    @Override
    public void supprimerPaiement(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public List<Paiement> recupererPaiement() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement recupererPaiementParId(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public Paiement modifierPaiement(Paiement p) {
        return paiementRepository.save(p);
    }
}
