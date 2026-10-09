package tn.esprit.autolock_sarrabenothmen.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolock_sarrabenothmen.Repositories.ClientRepository;
import tn.esprit.autolock_sarrabenothmen.entities.Client;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    private ClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> recupererClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client recupererClientParId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client modifierClient(Client c) {
        return clientRepository.save(c);
    }
}
