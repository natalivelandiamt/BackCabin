package co.edu.usergioarboleda.alquiler.cabin.app.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>  {
    
}
