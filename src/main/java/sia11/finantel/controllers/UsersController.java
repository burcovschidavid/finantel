package sia11.finantel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sia11.finantel.models.User;
import sia11.finantel.repositories.UserRepository;

import static org.springframework.security.crypto.bcrypt.BCrypt.*;

@RestController
public class UsersController {
    @Autowired

    private UserRepository userRepository;
    @GetMapping("/api/users")
    public @ResponseBody
    Iterable<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/api/users")
    public @ResponseBody
    User add(@RequestBody User user){
        user.setPassword(hashpw(user.getPassword(), gensalt()));
        userRepository.save(user);
        return user;
    }

    @PutMapping("/api/users")
    public @ResponseBody
    User update(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/api/users")
    public @ResponseBody
    Iterable<User> delete(@RequestBody User user){
        userRepository.delete(user);
        return userRepository.findAll();
    }


}
