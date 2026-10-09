package tn.esprit.autolock_sarrabenothmen.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolock_sarrabenothmen.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
