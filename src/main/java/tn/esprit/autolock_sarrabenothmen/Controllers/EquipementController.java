package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IEquipementService;
import tn.esprit.autolock_sarrabenothmen.entities.Equipement;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/equipements") @RequiredArgsConstructor
public class EquipementController {
    private final IEquipementService service;
    @PostMapping public ResponseEntity<Equipement> ajouter(@RequestBody Equipement value) {
        Equipement saved = service.ajouterEquipement(value);
        return ResponseEntity.created(URI.create("/api/equipements/" + saved.getIdEquipement())).body(saved);
    }
    @GetMapping public List<Equipement> recupererTous() { return service.recupererEquipement(); }
    @GetMapping("/{id}") public ResponseEntity<Equipement> recuperer(@PathVariable Long id) {
        Equipement value = service.recupererEquipementParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Equipement> modifier(@PathVariable Long id, @RequestBody Equipement value) {
        if (service.recupererEquipementParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdEquipement(id); return ResponseEntity.ok(service.modifierEquipement(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererEquipementParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerEquipement(id); return ResponseEntity.noContent().build();
    }
}
