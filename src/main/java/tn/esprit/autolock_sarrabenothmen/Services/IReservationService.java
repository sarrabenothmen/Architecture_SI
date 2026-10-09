package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation r);
    void supprimerReservation(Long id);
    List<Reservation> recupererReservation();
    Reservation recupererReservationParId(Long id);
    Reservation modifierReservation(Reservation r);

}
