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

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.services.ClientService;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {
    @Autowired
    private ClientService service;
    @GetMapping("/all")
    public List<Client> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return service.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client update (@RequestBody Client client){
        return service.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Client client){
        service.delete(client);
    }
}
