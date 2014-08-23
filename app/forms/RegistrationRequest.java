package forms;

/**
 * Created by dustin on 2014/07/20.
 */
public class RegistrationRequest {

    private String email;
    private String password;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
