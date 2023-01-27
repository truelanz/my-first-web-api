package dio.myfirstwebapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dio.myfirstwebapi.handler.RequiredField;
//import dio.myfirstwebapi.handler.BusinessException;
import dio.myfirstwebapi.model.User;

@Repository
public class UserRepository {
    public void save(User user){
        if(user.getLogin() == null)
        throw new RequiredField("login");

        if(user.getPassword() == null)
        throw new RequiredField("password");
          
        else if(user.getId() == null)
          System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
         System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        
        System.out.println(user);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<User> findAll(){
        System.out.println("LIST - Listando os usários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("alan","password"));
        users.add(new User("truelanz","masterpass"));
        return users;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new User("alan","password");
    }
     public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
        return new User("truelanz","password");
    }
}
    

