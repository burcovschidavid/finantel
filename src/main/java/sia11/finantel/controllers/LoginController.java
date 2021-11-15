package sia11.finantel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sia11.finantel.models.User;
import sia11.finantel.repositories.UserRepository;
import sia11.finantel.requests.LoginRequest;
import sia11.finantel.responses.LoginResponse;
import java.util.Random;

@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/login")
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest request){
        User user = userRepository.findByEmail(request.email);
        if(request.email.equals(user.getEmail()) && BCrypt.checkpw(request.password,user.getPassword())){
            user.setToken(generateAuthToken());
            userRepository.save(user);
            return new LoginResponse(200,user,"Logged in successfuly!");
        }
        return new LoginResponse(403,null,"Invalid email or password");
    }

    public static String generateAuthToken(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 255;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
