package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IPaiementService;
import tn.esprit.autolock_sarrabenothmen.entities.Paiement;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/paiements") @RequiredArgsConstructor
public class PaiementController {
    private final IPaiementService service;
    @PostMapping public ResponseEntity<Paiement> ajouter(@RequestBody Paiement value) {
        Paiement saved = service.ajouterPaiement(value);
        return ResponseEntity.created(URI.create("/api/paiements/" + saved.getIdPaiement())).body(saved);
    }
    @GetMapping public List<Paiement> recupererTous() { return service.recupererPaiement(); }
    @GetMapping("/{id}") public ResponseEntity<Paiement> recuperer(@PathVariable Long id) {
        Paiement value = service.recupererPaiementParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Paiement> modifier(@PathVariable Long id, @RequestBody Paiement value) {
        if (service.recupererPaiementParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdPaiement(id); return ResponseEntity.ok(service.modifierPaiement(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererPaiementParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerPaiement(id); return ResponseEntity.noContent().build();
    }
}
