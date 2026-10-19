package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IContratService;
import tn.esprit.autolock_sarrabenothmen.entities.Contrat;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/contrats") @RequiredArgsConstructor
public class ContratController {
    private final IContratService service;
    @PostMapping public ResponseEntity<Contrat> ajouter(@RequestBody Contrat value) {
        Contrat saved = service.ajouterContrat(value);
        return ResponseEntity.created(URI.create("/api/contrats/" + saved.getIdContrat())).body(saved);
    }
    @GetMapping public List<Contrat> recupererTous() { return service.recupererContrat(); }
    @GetMapping("/{id}") public ResponseEntity<Contrat> recuperer(@PathVariable Long id) {
        Contrat value = service.recupererContratParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Contrat> modifier(@PathVariable Long id, @RequestBody Contrat value) {
        if (service.recupererContratParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdContrat(id); return ResponseEntity.ok(service.modifierContrat(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererContratParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerContrat(id); return ResponseEntity.noContent().build();
    }
}
