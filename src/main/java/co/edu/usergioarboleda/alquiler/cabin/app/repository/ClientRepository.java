package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository repository;

    /**
     * Metodo que retorna una lista con los clientes en DB
     * @return List<Client>
     */
    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    /**
     * Metodo que retorna un cliente consultado por su id
     * @param id
     * @return Client
     */
    public Client findById(Integer id){
        return repository.findById(id).orElse(null);
    }
    
    /**
     * metodo para guardar un cliente usando la instancia Client
     * @param client
     * @return Client
     */
    public Client save(Client client) {
        return repository.save(client);
    }

    /**
     * Metodo para eliminar un cliente usando su instancia 
     * @param client
     */
    public void delete(Client client) {
        repository.delete(client);
    }

    /**
     * Metodo para elminar un cliente en DB usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
