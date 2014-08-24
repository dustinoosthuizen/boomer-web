package controllers;

import forms.AddItemRequest;
import forms.AddItemResponse;
import forms.ItemPageResponse;
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
        List<Item> items = Item.pageItems(page,pageSize);
        System.out.println("getting items "+items.size());
        ItemPageResponse itemPageReponse = new ItemPageResponse();
        itemPageReponse.setItems(items);
        return ok(Json.toJson(itemPageReponse));
    }

    public static Result addItem() {

        Form<AddItemRequest> addItemForm = Form.form(AddItemRequest.class);
        AddItemRequest addItemRequest = addItemForm.bindFromRequest().get();

        String name = addItemRequest.getName();
        String description = addItemRequest.getDescription();
        System.out.println(name);
        System.out.println(description);
        AddItemResponse addItemResponse = new AddItemResponse();

        Item existingItem = Item.findByName(name);

        if(existingItem==null) {
            Item item = Item.newEntity(name, description);
            Item.save(item);

            addItemResponse.setSuccess(true);
            addItemResponse.setMessage("Success");
            addItemResponse.setAddedItem(item);
        }else
        {
            addItemResponse.setSuccess(false);
            addItemResponse.setMessage("Item with name already exists");
        }

        return ok(Json.toJson(addItemResponse));
    }


}
