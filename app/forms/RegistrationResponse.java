package forms;

/**
 * Created by dustin on 2014/07/20.
 */
public class RegistrationResponse {

    public boolean success;
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
