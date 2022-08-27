package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Cabin;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.CabinRepository;

@Service
public class CabinService {

    @Autowired
    private CabinRepository repository;

    /**
     * Metodo para obtener una cabania por su id
     * @param id
     * @return Cabin
     */
    public Cabin getById(Integer id){
        return repository.findById(id);
    }

    /**
     * Metodo que obtiene una lista de cabanias
     * @return
     */
    public List<Cabin> getAll(){
        return (List<Cabin>) repository.findAll();
    }

    /**
     * Metodo que borra una cabania por su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Metodo que borra una cabania usando su isntancia completa
     * @param cabin
     */
    public void delete(Cabin cabin){
        repository.delete(cabin);
    }

    /**
     * Metodo para guardar uuna cabania
     * @param cabin
     * @return
     */
    public Cabin save(Cabin cabin){
        if(cabin.getId() == null){
            return repository.save(cabin);
        } else {
            if(repository.findById(cabin.getId()) == null){
                return repository.save(cabin);
            } else{
                return cabin;
            }
        }
    }

    /**
     * Metodo para actualizar una cabania
     * @param cabin
     * @return
     */
    public Cabin update(Cabin cabin){
        if (cabin.getId() != null) {
            Cabin newCabin = repository.findById(cabin.getId());
            if (newCabin != null) {
                if (cabin.getName() != null) {
                    newCabin.setName(cabin.getName());
                }
                if (cabin.getBrand() != null) {
                    newCabin.setBrand(cabin.getBrand());
                }
                if (cabin.getCategory() != null) {
                    newCabin.setCategory(cabin.getCategory());
                }
                if (cabin.getRooms() != null) {
                    newCabin.setRooms(cabin.getRooms());
                }
                if(cabin.getDescription() != null){
                    newCabin.setDescription(cabin.getDescription());
                }
                return repository.save(newCabin);
            } else {
                return cabin;
            }
        } else {
            return cabin;
        }
    }
}
