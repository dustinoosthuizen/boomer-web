package controllers;

import forms.AddItemRequest;
import forms.AddItemResponse;
import model.Item;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by dustin on 2014/07/31.
 */
public class ItemController extends Controller {

    public static Result page(int page,int pageSize)
    {
        List<Item> items = Item.all();
        System.out.println("getting items "+items.size());

        return ok(Json.toJson(items));
    }

    public static Result addItem() {

        Form<AddItemRequest> addItemForm = Form.form(AddItemRequest.class);
        AddItemRequest addItemRequest = addItemForm.bindFromRequest().get();

        String name = addItemRequest.getItemName();
        String description = addItemRequest.getItemDescription();
        System.out.println(name);
        System.out.println(description);
        AddItemResponse addItemResponse = new AddItemResponse();

        Item existingItem = Item.findByName(name);

        if(existingItem==null) {
            Item item = Item.newEntity(name, description);
            Item.save(item);

            addItemResponse.setSuccess(true);
            addItemResponse.setMessage("Success");
        }else
        {
            addItemResponse.setSuccess(false);
            addItemResponse.setMessage("Item with name already exists");
        }

        return ok(Json.toJson(addItemResponse));
    }


}
