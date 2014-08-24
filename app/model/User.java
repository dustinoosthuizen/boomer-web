package model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import morphia.MorphiaObject;
import org.bson.types.ObjectId;
import play.Logger;

import java.util.List;

/**
 * Created by dustin on 2014/06/24.
 */
@Entity
public class User {

    @Id
    @Property("id")
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String status;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "{id:\"\" + id + \"\",name:\"" + name + "\",email:\"" + email + "\"}";

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public static List<User> all() {

        return (List<User>) MorphiaObject.datastore.find(User.class).asList();

    }

    public static User findByMail(String email) {

        List<User> entities  = MorphiaObject.datastore.find(User.class).field("email").equal(email).asList();
        if (entities.isEmpty()) {
            return null;
        } else {
            return entities.get(0);
        }

    }

    public static User findById(String id) {

        List<User> entities  = MorphiaObject.datastore.find(User.class).field("id").equal(id).asList();
        if (entities.isEmpty()) {
            return null;
        } else {
            return entities.get(0);
        }

    }

    public static void deleteAllByEmail(String email) {

        List<User> entities  = MorphiaObject.datastore.find(User.class).field("email").equal(email).asList();
        for (User aUser : entities) {
            Logger.info("toDelete: " + aUser);
            MorphiaObject.datastore.delete(aUser);
           }
    }

    public static void deleteAll() {

        List<User> entities =  MorphiaObject.datastore.find(User.class).asList();
        for (User aUser : entities) {
            Logger.info("toDelete: " + aUser);
            MorphiaObject.datastore.delete(aUser);
        }
    }

    public static void save(User group) {
        MorphiaObject.datastore.save(group);
    }

    public static void delete(String idToDelete) {
        User toDelete = MorphiaObject.datastore.find(User.class).field("_id").equal(new ObjectId(idToDelete)).get();
        if (toDelete != null) {
            Logger.info("toDelete: " + toDelete);
            MorphiaObject.datastore.delete(toDelete);
        } else {
            Logger.debug("ID No Found: " + idToDelete);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User newUser(String email, String password, String name)
    {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
