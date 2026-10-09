package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.EmployeRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Employe;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {
    private EmployeRepository employeRepository;

    @Override
    public Employe ajouterEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public void supprimerEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public List<Employe> recupererEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public Employe recupererEmployeParId(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public Employe modifierEmploye(Employe e) {
        return employeRepository.save(e);
    }
}
