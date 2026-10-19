package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IMaintenanceService;
import tn.esprit.autolock_sarrabenothmen.entities.Maintenance;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/maintenances") @RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService service;
    @PostMapping public ResponseEntity<Maintenance> ajouter(@RequestBody Maintenance value) {
        Maintenance saved = service.ajouterMaintenance(value);
        return ResponseEntity.created(URI.create("/api/maintenances/" + saved.getIdMaintenance())).body(saved);
    }
    @GetMapping public List<Maintenance> recupererTous() { return service.recupererMaintenance(); }
    @GetMapping("/{id}") public ResponseEntity<Maintenance> recuperer(@PathVariable Long id) {
        Maintenance value = service.recupererMaintenanceParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Maintenance> modifier(@PathVariable Long id, @RequestBody Maintenance value) {
        if (service.recupererMaintenanceParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdMaintenance(id); return ResponseEntity.ok(service.modifierMaintenance(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererMaintenanceParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerMaintenance(id); return ResponseEntity.noContent().build();
    }
}
