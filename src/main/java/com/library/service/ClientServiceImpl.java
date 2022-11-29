
package com.library.service;

import com.library.entity.Client;
import com.library.exception.ClientNotFoundException;
import com.library.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Override
    public Client getClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return unwrapClient(client, id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    static Client unwrapClient(Optional<Client> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new ClientNotFoundException(id);
        }
    }

    
}
