package tn.esprit.autolock_sarrabenothmen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolock_sarrabenothmen.entities.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
