package ru.leha.SpringRESTfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leha.SpringRESTfull.model.Client;

/**
 * Repository interface for {@link Client} class
 *
 * @author Aleksei Agishev
 * @version 1.0
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
