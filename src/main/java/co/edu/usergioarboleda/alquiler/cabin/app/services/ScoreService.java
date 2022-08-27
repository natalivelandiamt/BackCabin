package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Score;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    /**
     * Metodo que obtiene un score por su id
     * @param Id
     * @return
     */
    public Score getById(Integer Id){
        return repository.findById(Id);
    }

    /**
     * Metodo que obtiene una lista de todos los scores
     * @return
     */
    public List<Score> getAll(){
        return (List<Score>) repository.findAll();
    }

    /**
     * Metodo para borrar un score usando su id
     * @param Id
     */
    public void deleteById(Integer Id){
        repository.deleteById(Id);
    }

    /**
     * Metodo para borrar un sore usando su instancia
     * @param score
     */
    public void delete(Score score){
        repository.delete(score);
    }

    /**
     * metodo para guardar un score
     * @param score
     * @return Score
     */
    public Score save(Score score){
        if (score.getId() == null) {
            return repository.save(score);
        } else {
            if (repository.findById(score.getId()) == null) {
                return repository.save(score);
            } else {
                return score;
            }
        }
    }

    /**
     * Metodo para actualizar un score
     * @param score
     * @return
     */
    public Score update(Score score){
        if(score.getId() != null){
            Score existScore = repository.findById(score.getId());
            if(existScore != null){
                if(score.getMessageText() != null){
                    existScore.setMessageText(score.getMessageText());
                }
                if(score.getStars() != null){
                    existScore.setStars(score.getStars());
                }
                if(score.getReservation() != null){
                    existScore.setReservation(score.getReservation());
                }
                return repository.save(existScore);
            } else{
                return score;
            }
        } else{
            return score;
        }
    }
}
