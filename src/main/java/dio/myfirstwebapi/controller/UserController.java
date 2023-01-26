package dio.myfirstwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.myfirstwebapi.model.User;
import dio.myfirstwebapi.repository.UserRepository;

@RestController
@RequestMapping("/users") // Essa classe sempre será iniciada com users
public class UserController {
    @Autowired
    public UserRepository repository;

    //MÉTODO DE ADIÇÃO DE 'SUB CAMADA' NA WEB
    @GetMapping()
    public List<User> getUsers(){
        return repository.findAll();

    }
    //MÉTODO DE ADIÇÃO DE USERS NA URI\\
    @GetMapping("{username}")
    public User findOnde(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    //MÉTODO DE EXCLUSÃO DE ID - É NECESSÁRIO UM CLIENT\\
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User usuer){
        repository.save(usuer);
    }
    
}
