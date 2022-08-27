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

import co.edu.usergioarboleda.alquiler.cabin.app.models.Category;
import co.edu.usergioarboleda.alquiler.cabin.app.services.CategoryService;


@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping("/all")
    public List<Category> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category update (@RequestBody Category category){
        return service.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Category category){
        service.delete(category);
    }
}
