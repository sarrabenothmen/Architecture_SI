package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IEmployeService;
import tn.esprit.autolock_sarrabenothmen.entities.Employe;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/employes") @RequiredArgsConstructor
public class EmployeController {
    private final IEmployeService service;
    @PostMapping public ResponseEntity<Employe> ajouter(@RequestBody Employe value) {
        Employe saved = service.ajouterEmploye(value);
        return ResponseEntity.created(URI.create("/api/employes/" + saved.getIdEmploye())).body(saved);
    }
    @GetMapping public List<Employe> recupererTous() { return service.recupererEmploye(); }
    @GetMapping("/{id}") public ResponseEntity<Employe> recuperer(@PathVariable Long id) {
        Employe value = service.recupererEmployeParId(id);
        return value == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(value);
    }
    @PutMapping("/{id}") public ResponseEntity<Employe> modifier(@PathVariable Long id, @RequestBody Employe value) {
        if (service.recupererEmployeParId(id) == null) return ResponseEntity.notFound().build();
        value.setIdEmploye(id); return ResponseEntity.ok(service.modifierEmploye(value));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (service.recupererEmployeParId(id) == null) return ResponseEntity.notFound().build();
        service.supprimerEmploye(id); return ResponseEntity.noContent().build();
    }
}
