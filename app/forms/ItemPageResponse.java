package forms;

import model.Item;

import java.util.List;

/**
 * Created by dustinosthzn on 2014/08/24.
 */
public class ItemPageResponse {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
