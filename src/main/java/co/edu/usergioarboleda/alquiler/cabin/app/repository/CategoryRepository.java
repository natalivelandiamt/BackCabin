package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Category;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository repository;

    /**
     * Metodo que retorna todas las categorias en DB
     * @return List<Category>
     */
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    /**
     * Metodo que retorna una categoria consultada por su id
     * @param id
     * @return Category
     */
    public Category findById(Integer id){
        return repository.findById(id).orElse(null);
    }


    /**
     * Metood para guardar una categoria
     * @param category
     * @return Category
     */
    public Category save(Category category) {
        return repository.save(category);
    }

    /**
     * Meotod para eliminar una categoria usando su instancia
     * @param category
     */
    public void delete(Category category) {
        repository.delete(category);
    }

    /**
     * Metodo para eliminar una categorua usando su id 
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
