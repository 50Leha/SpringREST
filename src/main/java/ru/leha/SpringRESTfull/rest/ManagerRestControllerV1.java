package ru.leha.SpringRESTfull.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.leha.SpringRESTfull.model.Manager;
import ru.leha.SpringRESTfull.service.ManagerService;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link Manager} class.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/managers")
@Api(value = "managerRestController", tags = {"Managers"})
public class ManagerRestControllerV1 {

    private final ManagerService managerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> getManager(@PathVariable("id") Long managerId) {
        if (managerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Manager manager = this.managerService.getById(managerId);

        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(manager, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> saveManager(@RequestBody @Valid Manager manager) {
        HttpHeaders headers = new HttpHeaders();

        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.managerService.save(manager);

        return new ResponseEntity<>(manager, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> updateManager(@PathVariable("id") Long managerId,
                                                 @RequestBody @Valid Manager newManager) {
        HttpHeaders headers = new HttpHeaders();

        if (newManager == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (managerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Manager updatedManager = this.managerService.update(newManager, managerId);

        return new ResponseEntity<>(updatedManager, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manager> deleteManager(@PathVariable("id") Long id) {
        Manager manager = this.managerService.getById(id);

        if (manager == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.managerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = this.managerService.getAll();

        if (managers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }
}
