package sia11.finantel.responses;

import sia11.finantel.models.User;

public class LoginResponse {
    public int HTTP_CODE;
    public User user;
    public String message;
    public LoginResponse(int HTTP_CODE, User user, String message) {
        this.HTTP_CODE = HTTP_CODE;
        this.user = user;
        this.message = message;
    }
}
