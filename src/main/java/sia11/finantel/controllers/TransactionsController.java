package sia11.finantel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sia11.finantel.models.User;
import sia11.finantel.repositories.UserRepository;

import static org.springframework.security.crypto.bcrypt.BCrypt.gensalt;
import static org.springframework.security.crypto.bcrypt.BCrypt.hashpw;

@RestController
public class TransactionsController {
    @Autowired

    private UserRepository userRepository;
    @GetMapping("/api/transactions")
    public @ResponseBody
    Iterable<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/api/transactions")
    public @ResponseBody
    User add(@RequestBody User user){
        user.setPassword(hashpw(user.getPassword(), gensalt()));
        userRepository.save(user);
        return user;
    }

    @PutMapping("/api/transactions")
    public @ResponseBody
    User update(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/api/transactions")
    public @ResponseBody
    Iterable<User> delete(@RequestBody User user){
        userRepository.delete(user);
        return userRepository.findAll();
    }


}
