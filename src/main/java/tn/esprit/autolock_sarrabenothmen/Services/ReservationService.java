package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.ReservationRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Reservation;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    private ReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> recupererReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation recupererReservationParId(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation modifierReservation(Reservation r) {
        return reservationRepository.save(r);
    }
}
