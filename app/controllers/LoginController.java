package controllers;

import forms.LoginRequest;
import forms.LoginResponse;
import model.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EncryptionUtil;
import utils.jwt.JWTUtil;

/**
 * Created by dustin on 2014/07/31.
 */
public class LoginController  extends Controller {

    public static Result login() {

        Form<LoginRequest> loginForm = Form.form(LoginRequest.class);
        LoginRequest loginReguest = loginForm.bindFromRequest().get();
        LoginResponse loginResponse = new LoginResponse();
        User aUser = User.findByMail(loginReguest.getEmail());
        if(aUser!=null) {
            if(aUser.getStatus().equals("active")) {
                boolean validEmail = EncryptionUtil.digesterMatches(loginReguest.getPassword(),aUser.getPassword());
                if (validEmail) {
                    loginResponse.setSuccess(true);
                    loginResponse.setMessage("successful");
                    try {
                        loginResponse.setToken(JWTUtil.generateToken(aUser.getEmail()));
                    } catch (Exception exc) {
                        return internalServerError(exc.getMessage());
                    }
                } else {
                    loginResponse.setSuccess(false);
                    loginResponse.setMessage("Invalid username or password");
                }
            }else
            {
                loginResponse.setSuccess(false);
                loginResponse.setMessage("Please confirm registration by clicking on link sent to email");
            }
        }else
        {
            loginResponse.setSuccess(false);
            loginResponse.setMessage("Please register");
        }
        return ok(Json.toJson(loginResponse));

    }


}
