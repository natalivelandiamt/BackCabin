package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Admin;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    /**
     * metodo que obtener un adminsitrador por su id
     * @param id
     * @return Admin
     */
    public Admin getById(Integer id){
        return repository.findById(id);
    }

    /**
     * Metodo obtener una lista de administradores
     * @return  List<Admin>
     */
    public List<Admin> getAll(){
        return (List<Admin>) repository.findAll();
    }

    /**
     * Metodo para borrar un admin por su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Metodo para borrar un admin por su instancia completa
     * @param admin
     */
    public void delete(Admin admin){
        repository.delete(admin);
    }

    /**
     * Metodo para guardar un administrador en DB
     * @param admin
     * @return
     */
    public Admin save(Admin admin){
        if(admin.getIdAdmin() == null){
            return repository.save(admin);
        } else{
            if(repository.findById(admin.getIdAdmin()) == null){
                return repository.save(admin);
            } else{
                return admin;
            }
        }
    }

    /**
     * Metodo para actualizar un administrador usando su instancia 
     * @param admin
     * @return
     */
    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Admin newAdmin = repository.findById(admin.getIdAdmin());
            if (newAdmin != null) {
                if (admin.getName() != null) {
                    newAdmin.setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    newAdmin.setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    newAdmin.setPassword(admin.getPassword());
                }
                return repository.save(newAdmin);
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }
}
