package controllers;

import model.User;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dustin on 2014/06/24.
 */
public class UserController extends Controller {

//    static List<User> users = new ArrayList();

    public static Result getUsers() {
        List<User> users = new ArrayList();
//        users.clear();
//        users.add(new User("name1","name1@email1"));
//        users.add(new User("name2","name2@email1"));
//        users.add(new User("name3","name3@email1"));
//        users.add(new User("name4","name4@email1"));
//        users.add(new User("name5","name5@email1"));
        //
        //
        users= User.all();
        return ok(Json.toJson(users));
    }


    public static Result getUser(Integer id) {
        System.out.println("this is the user id:" + id);
        return ok("this is the user id:" + id);
    }

    public static Result getUserByEmail(String email) {
        User user = User.findByMail(email);
        return ok(Json.toJson(user));
    }

    public static Result getUserByToken() {
        String authorizationHeader = request().getHeader("Authorization");
        System.out.println(authorizationHeader);
        User aUser = new User();
        aUser.setEmail("testUser");
        aUser.setName("testUser");
        return ok(Json.toJson(aUser));
    }

    public static Result saveUser() {
        Form<User> userForm = Form.form(User.class);
        User user = userForm.bindFromRequest().get();
        User.save(user);
        return ok(Json.toJson(user));
    }

}
