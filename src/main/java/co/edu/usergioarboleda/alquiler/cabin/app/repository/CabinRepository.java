package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Cabin;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.CabinCrudRepository;

@Repository
public class CabinRepository {

    @Autowired
    private CabinCrudRepository repository;
    
    /**
     * Metodo que retorna todas las cabanias encontradas en DB
     * @return
     */
    public List<Cabin> findAll() {
        return (List<Cabin>) repository.findAll();
    }

    /**
     * Metodo que retorna una cabina, consultada por su id
     * @param id
     * @return
     */
    public Cabin findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Metodo que guarda una cabania 
     * @param cabin
     * @return
     */
    public Cabin save(Cabin cabin) {
        return repository.save(cabin);
    }

    /**
     * Metodo para eliminar una cabania usando la instancia 
     * @param cabin
     */
    public void delete(Cabin cabin) {
        repository.delete(cabin);
    }

    /**
     * Metodo para eliminar una cabania usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
