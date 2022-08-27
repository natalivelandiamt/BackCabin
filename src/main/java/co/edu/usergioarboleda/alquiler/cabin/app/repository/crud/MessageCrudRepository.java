package co.edu.usergioarboleda.alquiler.cabin.app.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>  {
    
}
