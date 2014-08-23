package forms;

/**
 * Created by dustin on 2014/08/17.
 */
public class AddItemRequest {

    public String itemName;
    public String itemDescription;

    public AddItemRequest() {
    }

    public AddItemRequest(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
