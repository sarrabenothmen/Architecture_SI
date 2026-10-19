package tn.esprit.autolock_sarrabenothmen.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolock_sarrabenothmen.Services.IClientService;
import tn.esprit.autolock_sarrabenothmen.entities.Client;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<Client> ajouter(@RequestBody Client client) {
        Client cree = clientService.ajouterClient(client);
        return ResponseEntity.created(URI.create("/api/clients/" + cree.getIdClient())).body(cree);
    }

    @GetMapping
    public List<Client> recupererTous() { return clientService.recupererClient(); }

    @GetMapping("/{id}")
    public ResponseEntity<Client> recuperer(@PathVariable Long id) {
        Client client = clientService.recupererClientParId(id);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifier(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.recupererClientParId(id) == null) return ResponseEntity.notFound().build();
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.modifierClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (clientService.recupererClientParId(id) == null) return ResponseEntity.notFound().build();
        clientService.supprimerClient(id);
        return ResponseEntity.noContent().build();
    }
}
