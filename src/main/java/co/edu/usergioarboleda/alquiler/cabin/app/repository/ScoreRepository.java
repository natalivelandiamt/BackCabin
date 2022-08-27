package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Score;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository repository;

    /**
     * Metodo que retorna una lista de todos los scores
     * @return List<Score>
     */
    public List<Score> findAll() {
        return (List<Score>) repository.findAll();
    }
    
    /**
     * Metodo para encontrar un score por su id
     * @param id
     * @return Score
     */
    public Score findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Metodo para guardar un score usando su instancia
     * @param score
     * @return Score
     */
    public Score save(Score score) {
        return repository.save(score);
    }

    /**
     * Metodo para borrar un score usando su instancia
     * @param score
     */
    public void delete(Score score) {
        repository.delete(score);
    }

    /**
     * metodo para eliminar un score usando su id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
