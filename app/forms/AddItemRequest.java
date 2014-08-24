package forms;

/**
 * Created by dustin on 2014/08/17.
 */
public class AddItemRequest {

    public String name;
    public String description;

    public AddItemRequest() {
    }

    public AddItemRequest(String itemName, String itemDescription) {
        this.name = itemName;
        this.description = itemDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        this.name = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String itemDescription) {
        this.description = itemDescription;
    }
}
