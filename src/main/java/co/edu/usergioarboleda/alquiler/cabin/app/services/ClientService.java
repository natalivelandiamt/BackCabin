package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    /**
     * Metodo para obtener un cliente por su id
     * @param id
     * @return Client
     */
    public Client getById(Integer id){
        return repository.findById(id);
    }

    /**
     * Metodo que obtiene una lita de clientes
     * @return List<Client>
     */
    public List<Client> getAll(){
        return (List<Client>) repository.findAll();
    }

    /**
     * metodo para eliminar un cliente de DB usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Metodo para eliminar un cliente de DB usando su instancia
     * @param client
     */
    public void delete(Client client){
        repository.delete(client);
    }

    /**
     * metodo para guardar un cliente
     * @param client
     * @return Client
     */
    public Client save(Client client){
        if(client.getIdClient() == null){
            return repository.save(client);
        } else{
            if(repository.findById(client.getIdClient()) == null){
                return repository.save(client);
            } else{
                return client;
            }
        }
    }

    /**
     * Metodo para actualizar un cliente
     * @param client
     * @return Client
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Client newClient = repository.findById(client.getIdClient());
            if (newClient != null) {
                if (client.getName() != null) {
                    newClient.setName(client.getName());
                }
                if (client.getEmail() != null) {
                    newClient.setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    newClient.setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    newClient.setAge(client.getAge());
                }
                return repository.save(newClient);
            } else {
                return client;
            }
        } else {
            return client;
        }
    }
}
