package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Message;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    /**
     * Metodo para obtener un mensaje por su id
     * @param id
     * @return Message
     */
    public Message getById(Integer id){
        return repository.findById(id);
    }

    /**
     * Metodo que obtiene uns lista de todos los mensajes.
     * @return List<Message>
     */
    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }

    /**
     * Metodo para eliminarun mensaje usando su Id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Metodo para borrar un mensaje usando su instancia 
     * @param message
     */
    public void delete(Message message){
        repository.delete(message);
    }

    /**
     * Metodo para guardar un mensaj
     * @param message
     * @return Message
     */
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return repository.save(message);
        } else {
            if(repository.findById(message.getIdMessage()) == null){
                return repository.save(message);
            } else {
                return message;
            }
        }
    }

    /**
     * Metodo para actualizar un mensaje
     * @param message
     * @return Message
     */
    public Message update(Message message){
        if (message.getIdMessage() != null) {
            Message newMessage = repository.findById(message.getIdMessage());
            if (newMessage != null) {
                if (message.getCabin() != null) {
                    newMessage.setCabin(message.getCabin());
                }
                if (message.getClient() != null) {
                    newMessage.setClient(message.getClient());
                }
                if (message.getMessageText() != null) {
                    newMessage.setMessageText(message.getMessageText());
                }
                return repository.save(newMessage);
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
}
