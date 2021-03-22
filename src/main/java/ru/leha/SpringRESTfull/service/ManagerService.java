package ru.leha.SpringRESTfull.service;

import ru.leha.SpringRESTfull.model.Manager;

import java.util.List;

/**
 * Simple interface for {@link Manager} class.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
public interface ManagerService {
    Manager getById(Long id);

    void save(Manager manager);

    void delete(Long id);

    Manager update(Manager manager, Long id);

    List<Manager> getAll();

}
