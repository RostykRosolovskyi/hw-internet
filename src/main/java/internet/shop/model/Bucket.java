package internet.shop.model;

import internet.shop.idstorage.BucketIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long id;
    private List<Item> items;
    private Long userId;

    public Bucket() {
        this.id = BucketIdGenerator.generateId();
        items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
