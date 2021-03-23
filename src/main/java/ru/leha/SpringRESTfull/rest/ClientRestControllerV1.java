package ru.leha.SpringRESTfull.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.leha.SpringRESTfull.model.Client;
import ru.leha.SpringRESTfull.service.ClientService;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link Client} class.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
@Api(value = "clientsRestController", tags = {"Clients"})
public class ClientRestControllerV1 {

    private final ClientService clientService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long clientId) {
        if (clientId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client client = this.clientService.getById(clientId);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(client, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> saveClient(@RequestBody @Valid Client client) {
        HttpHeaders headers = new HttpHeaders();

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.clientService.save(client);

        return new ResponseEntity<>(client, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId,
                                                 @RequestBody @Valid Client newClient) {
        HttpHeaders headers = new HttpHeaders();

        if (newClient == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (clientId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client updatedClient = this.clientService.update(newClient, clientId);

        return new ResponseEntity<>(updatedClient, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id) {
        Client client = this.clientService.getById(id);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.clientService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = this.clientService.getAll();

        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}