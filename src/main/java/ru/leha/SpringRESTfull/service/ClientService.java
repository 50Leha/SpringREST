package ru.leha.SpringRESTfull.service;

import ru.leha.SpringRESTfull.model.Client;

import java.util.List;

/**
 * Simple interface for {@link Client} class.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
public interface ClientService {
    Client getById(Long id);

    void save(Client client);

    void delete(Long id);

    Client update(Client client, Long id);

    List<Client> getAll();
}
