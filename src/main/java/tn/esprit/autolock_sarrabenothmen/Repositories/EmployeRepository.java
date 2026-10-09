package tn.esprit.autolock_sarrabenothmen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolock_sarrabenothmen.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
