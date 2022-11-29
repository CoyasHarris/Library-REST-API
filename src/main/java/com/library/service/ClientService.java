
package com.library.service;

import com.library.entity.Client;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Client getClient(Long id);
    Client saveClient(Client client);
    void deleteClient(Long id);
    List<Client> getClients();
}
