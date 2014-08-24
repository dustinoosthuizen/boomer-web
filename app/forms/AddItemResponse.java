package forms;

import model.Item;
import org.bson.types.ObjectId;

/**
 * Created by dustin on 2014/08/17.
 */
public class AddItemResponse {
    private boolean isSuccess;
    private String message;
    private Item addedItem;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSucess) {
        this.isSuccess = isSucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Item getAddedItem() {
        return addedItem;
    }

    public void setAddedItem(Item addedItem) {
        this.addedItem = addedItem;
    }
}
