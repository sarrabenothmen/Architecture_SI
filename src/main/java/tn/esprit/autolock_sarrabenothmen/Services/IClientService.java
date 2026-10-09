package tn.esprit.autolock_sarrabenothmen.Services;

import tn.esprit.autolock_sarrabenothmen.entities.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client c);
    void supprimerClient(Long id);
    List<Client> recupererClient();
    Client recupererClientParId(Long id);
    Client modifierClient(Client c);

}
