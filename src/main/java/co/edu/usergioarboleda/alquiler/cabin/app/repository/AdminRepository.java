package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Admin;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository repository;

    /**
     * Metodo que retorna todos los admins registrados en DB
     * @return
     */
    public List<Admin> findAll() {
        return (List<Admin>) repository.findAll();
    }

    /**
     * Metodo que retorna un admin consultado por su id, si no existe retorna valor other
     * @param id
     * @return
     */
    public Admin findById(Integer id){
        return repository.findById(id).orElse(null);
    }


    /**
     * Metodo que guarda un administrador y lo retorna
     * @param admin
     * @return
     */
    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    /**
     * Metodo para eliminar un adminsitrador usando la instancia admin completa
     * @param admin
     */
    public void delete(Admin admin) {
        repository.delete(admin);
    }

    /**
     * Metodo para eliminar un administrador de DB usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
