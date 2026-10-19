package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IReservationService;
import tn.esprit.autolock_sarrabenothmen.entities.Reservation;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/reservations") @RequiredArgsConstructor
public class ReservationController {
    private final IReservationService service;
    @PostMapping public ResponseEntity<Reservation> ajouter(@RequestBody Reservation value) {
        Reservation saved = service.ajouterReservation(value);
        return ResponseEntity.created(URI.create("/api/reservations/" + saved.getIdReservation())).body(saved);
    }
    @GetMapping public List<Reservation> recupererTous() { return service.recupererReservation(); }
    @GetMapping("/{id}") public ResponseEntity<Reservation> recuperer(@PathVariable Long id) {
        Reservation value = service.recupererReservationParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Reservation> modifier(@PathVariable Long id, @RequestBody Reservation value) {
        if (service.recupererReservationParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdReservation(id); return ResponseEntity.ok(service.modifierReservation(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererReservationParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerReservation(id); return ResponseEntity.noContent().build();
    }
}
