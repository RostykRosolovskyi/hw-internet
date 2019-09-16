package internet.shop.model;

import internet.shop.idstorage.UserIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private List<Order> orders;
    private Bucket bucket;

    public User() {
        this.id = UserIdGenerator.generateId();
        orders = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }
}
