package controllers;

import forms.RegistrationRequest;
import forms.RegistrationResponse;
import model.User;
import play.Play;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EncryptionUtil;
import utils.MailSenderUtil;

/**
 * Created by dustin on 2014/07/20.
 */
public class RegistrationController extends Controller {

    public static Result register() {
        Form<RegistrationRequest> registrationForm = Form.form(RegistrationRequest.class);
        RegistrationRequest registrationRequest = registrationForm.bindFromRequest().get();
        String email = registrationRequest.getEmail();
        User user = User.findByMail(email);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setPassword(EncryptionUtil.digest(registrationRequest.getPassword()));
            user.setStatus("awaiting registration confirmation");
            User.save(user);
            try {
                MailSenderUtil.sendConfirmationEmail(email, user.getId());
                registrationResponse.setSuccess(true);
                registrationResponse.setMessage("Registration successfull, email has been sent to " + registrationRequest.getEmail() + " please verify by clicking link in email");
            } catch (Exception exc) {
                exc.printStackTrace();
                registrationResponse.setSuccess(false);
                registrationResponse.setMessage("Error sending confirmation mail, please try again later");
            }
        } else {
            registrationResponse.setSuccess(false);
            registrationResponse.setMessage("Email has already been registered, please try a different email or try and reset your password");

        }


        return ok(Json.toJson(registrationResponse));
    }

    public static Result confirmation(String confirmationId)
    {
        Long userId = EncryptionUtil.decryptLongReplaceForwardSlashWithSalt(confirmationId, "_");
        User user = User.findById(userId);
        String baseUrl = Play.application().configuration().getString("base.url");
        if(user.getStatus().equals("active"))
        {
            return redirect(baseUrl+"/#/registrationConfirmed");
        }else {
            user.setStatus("active");
            User.save(user);
            System.out.println(userId);
            return redirect(baseUrl+"/#/registrationConfirmed");
        }
    }


}
