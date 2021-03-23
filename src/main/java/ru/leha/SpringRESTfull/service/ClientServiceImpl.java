package ru.leha.SpringRESTfull.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leha.SpringRESTfull.model.Client;
import ru.leha.SpringRESTfull.repository.ClientRepository;

import java.util.List;

/**
 * Implementation on {@link ClientService} interface.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    @Override
    public Client getById(Long id) {
        log.info("IN ClientServiceImpl getById {}", id);
        if (clientRepository.existsById(id)) {
            return clientRepository.getOne(id);
        } else {
            return null;
        }
    }

    @Override
    public void save(Client client) {
        log.info("IN ClientServiceImpl save {}", client);
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        log.info("IN ClientServiceImpl delete {}", id);
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
    }

    @Override
    public Client update(Client newClient, Long clientId) {
        log.info("IN ClientServiceImpl update {}", newClient, clientId);
        Client client = this.getById(clientId);

        client.setName(newClient.getName());
        client.setManager_id(newClient.getManager_id());

        this.save(client);

        return client;
    }

    @Override
    public List<Client> getAll() {
        log.info("IN ClientServiceImpl getAll");
        return clientRepository.findAll();
    }
}
