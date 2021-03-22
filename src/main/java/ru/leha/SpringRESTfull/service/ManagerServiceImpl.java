package ru.leha.SpringRESTfull.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leha.SpringRESTfull.model.Manager;
import ru.leha.SpringRESTfull.repository.ManagerRepository;

import java.util.List;

/**
 * Implementation on {@link ManagerService} interface.
 *
 * @author Aleksei Agishev
 * @version 1.0
 */

@Slf4j
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Manager getById(Long id){
        log.info("IN ManagerServiceImpl getById {}", id);
        if (managerRepository.existsById(id)) {
            return managerRepository.getOne(id);
        } else {
            return null;
        }
    }

    @Override
    public void save(Manager manager){
        log.info("IN ManagerServiceImpl save {}", manager);
        managerRepository.save(manager);
    }

    @Override
    public void delete(Long id){
        log.info("IN ManagerServiceImpl delete {}", id);
        if (managerRepository.existsById(id)) {
            managerRepository.deleteById(id);
        }
    }

    @Override
    public Manager update(Manager newManager, Long managerId){
        log.info("IN ManagerServiceImpl update {}",newManager, managerId);
        Manager manager = this.getById(managerId);

        manager.setName(newManager.getName());
        manager.setEmail(newManager.getEmail());
        manager.setPhone(newManager.getPhone());

        this.save(manager);

        return manager;
    }

    @Override
    public List<Manager> getAll(){
        log.info("IN ManagerServiceImpl getAll");
        return managerRepository.findAll();
    }
}
