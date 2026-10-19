package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IAgenceService;
import tn.esprit.autolock_sarrabenothmen.entities.Agence;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping
    public ResponseEntity<Agence> ajouter(@RequestBody Agence agence) {
        Agence cree = agenceService.ajouterAgence(agence);
        return ResponseEntity.created(URI.create("/api/agences/" + cree.getIdAgence())).body(cree);
    }

    @GetMapping
    public List<Agence> recupererToutes() { return agenceService.recupererAgence(); }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> recuperer(@PathVariable Long id) {
        Agence agence = agenceService.recupererAgenceParId(id);
        return agence == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(agence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> modifier(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.recupererAgenceParId(id) == null) return ResponseEntity.notFound().build();
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.modifierAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (agenceService.recupererAgenceParId(id) == null) return ResponseEntity.notFound().build();
        agenceService.supprimerAgence(id);
        return ResponseEntity.noContent().build();
    }
}
