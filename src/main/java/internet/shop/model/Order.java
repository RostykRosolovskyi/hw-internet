package internet.shop.model;

import internet.shop.idstorage.OrderIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private List<Item> items;
    private Long userId;

    public Order() {
        this.id = OrderIdGenerator.generateId();
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

    @Override
    public String toString() {
        return "Order id = " + id + ", user id = " + userId + "\n" + items;
    }
}
