package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IVehiculeService;
import tn.esprit.autolock_sarrabenothmen.entities.Vehicule;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/vehicules") @RequiredArgsConstructor
public class VehiculeController {
    private final IVehiculeService service;
    @PostMapping public ResponseEntity<Vehicule> ajouter(@RequestBody Vehicule value) {
        Vehicule saved = service.ajouterVehicule(value);
        return ResponseEntity.created(URI.create("/api/vehicules/" + saved.getIdVehicule())).body(saved);
    }
    @GetMapping public List<Vehicule> recupererTous() { return service.recupererVehicule(); }
    @GetMapping("/{id}") public ResponseEntity<Vehicule> recuperer(@PathVariable Long id) {
        Vehicule value = service.recupererVehiculeParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Vehicule> modifier(@PathVariable Long id, @RequestBody Vehicule value) {
        if (service.recupererVehiculeParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdVehicule(id); return ResponseEntity.ok(service.modifierVehicule(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererVehiculeParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerVehicule(id); return ResponseEntity.noContent().build();
    }
}
