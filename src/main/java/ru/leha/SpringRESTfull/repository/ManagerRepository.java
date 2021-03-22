package ru.leha.SpringRESTfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leha.SpringRESTfull.model.Manager;

/**
 * Repository interface for {@link Manager} class
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
