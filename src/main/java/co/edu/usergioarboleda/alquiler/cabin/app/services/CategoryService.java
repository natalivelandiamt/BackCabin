package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Category;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    /**
     * metodo que obtiene una categoria por su id
     * @param id
     * @return
     */
    public Category getById(Integer id){
        return repository.findById(id);
    }

    /**
     * metodo que obtiene una lista de categorias
     * @return
     */
    public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    
    /**
     * Metodo para eliminar una ccategoria empleando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * metodo para eliminar una categoria usando su instancia 
     * @param category
     */
    public void delete(Category category){
        repository.delete(category);
    }

    /**
     * Metodo que guarda una categoria
     * @param category
     * @return
     */
    public Category save(Category category){
        if(category.getId() == null){
            return repository.save(category);
        } else{
            if(repository.findById(category.getId()) == null){
                return repository.save(category);
            } else{
                return category;
            }
        }
    }

    /**
     * Metodo para actuaizar una categoria
     * @param category
     * @return
     */
    public Category update(Category category){
        if(category.getId() != null){
            Category newCategory = repository.findById(category.getId());
            if(newCategory != null){
                if(category.getName() != null){
                    newCategory.setName(category.getName());
                }
                if(category.getDescription() != null){
                    newCategory.setDescription(category.getDescription());
                }
                if(category.getCabins() != null){
                    newCategory.setCabins(category.getCabins());
                }
                return repository.save(newCategory);
            } else {
                return category;
            }
        } else {
            return category;
        }
    }
}
