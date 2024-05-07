package com.company.salesManagementSystem.service;

import com.company.salesManagementSystem.model.Client;
import com.company.salesManagementSystem.repo.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    @Autowired
    private ClientRepository clientRepository;


    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        logger.info("Adding client: {}", client);
        Client saved = clientRepository.save(client);
        logger.info("Client added successfully: {}", saved);
        return saved;
    }

    public Client update(Client newClient) {
        logger.info("Updating client: {}", newClient);
        Client update = clientRepository.save(newClient);
        logger.info("Client updated successfully: {}", update);
        return update;
    }

    public boolean delete(long id) {
        logger.info("deleting client with id : {}", id);
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
            logger.info("Client deleted successfully: {}", id);
            return true;
        }
        logger.info("Cant delete Client", id);
        return false;
    }


}
