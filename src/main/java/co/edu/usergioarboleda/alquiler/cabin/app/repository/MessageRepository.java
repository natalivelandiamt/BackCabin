package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Message;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository repository;

    /**
     * Metodo que retorna una lista de mensajes alojados en DB
     * @return  List<Message>
     */
    public List<Message> findAll() {
        return (List<Message>) repository.findAll();
    }

    /**
     * Metodo que retorna un mensaje consultado en DB por su id
     * @param id
     * @return Message
     */ 
    public Message findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Metodo que guarda un mensaje en DB
     * @param message
     * @return Message
     */
    public Message save(Message message) {
        return repository.save(message);
    }

   /**
    * Metodo para eliminar un mensaje usando su instancia 
     * @param message
     */
     public void delete(Message message) {
        repository.delete(message);
    }

    /**
     * Metodo para eliminar un mensaje usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
