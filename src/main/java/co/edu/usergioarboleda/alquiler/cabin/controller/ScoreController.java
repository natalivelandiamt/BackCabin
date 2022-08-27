package co.edu.usergioarboleda.alquiler.cabin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Score;
import co.edu.usergioarboleda.alquiler.cabin.app.services.ScoreService;

@RestController
@RequestMapping("/Score")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ScoreController {
    @Autowired
    private ScoreService service;
    @GetMapping("/all")
    public List<Score> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Score getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return service.save(score);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Score update (@RequestBody Score score){
        return service.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Score score){
        service.delete(score);
    }
}
