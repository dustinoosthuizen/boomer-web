package model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import morphia.MorphiaObject;
import org.bson.types.ObjectId;
import play.Logger;

import java.util.List;

/**
 * Created by dustin on 2014/06/24.
 */
@Entity
public class Item {

    @Id
    private ObjectId id;
    private String name;
    private String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "{id:\"\" + id + \"\",name:\"" + name + "\",email:\"" + description + "\"}";

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public static List<Item> all() {

        return (List<Item>) MorphiaObject.datastore.find(Item.class).asList();

    }

    public static void save(Item item) {
        MorphiaObject.datastore.save(item);
    }

    public static Item findByName(String name) {

        List<Item> entities  = MorphiaObject.datastore.find(Item.class).field("name").equal(name).asList();
        if (entities.isEmpty()) {
            return null;
        } else {
            return entities.get(0);
        }

    }

    public static List<Item> pageItems(int page, int pageSize){
        return MorphiaObject.datastore.find(Item.class).offset(page*pageSize).limit(pageSize).asList();
    }

//    public static Item findById(Long id) {
//
//        List<Item> entities  = MorphiaObject.datastore.find(Item.class).field("id").equal(id).asList();
//        if (entities.isEmpty()) {
//            return null;
//        } else {
//            return entities.get(0);
//        }
//
//    }

    public static void deleteAllByName(String name) {

        List<Item> entities  = MorphiaObject.datastore.find(Item.class).field("name").equal(name).asList();
        for (Item entity : entities) {
            Logger.info("toDelete: " + entity);
            MorphiaObject.datastore.delete(entity);
           }
    }

    public static void deleteAll() {

        List<Item> entities =  MorphiaObject.datastore.find(Item.class).asList();
        for (Item entity : entities) {
            Logger.info("toDelete: " + entity);
            MorphiaObject.datastore.delete(entity);
        }
    }

    public static Item newEntity(String name, String description)
    {
        Item entity = new Item();
        entity.setDescription(description);
        entity.setName(name);
        return entity;
    }


}
