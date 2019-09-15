package internet.shop.dao.impl;

import internet.shop.dao.OrderDao;
import internet.shop.dao.Storage;
import internet.shop.lib.Dao;
import internet.shop.model.Order;

import java.util.NoSuchElementException;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Order get(Long id) {
        return Storage.orders.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find order with id " + id));
    }

    @Override
    public Order update(Order newOrder) {
        Order order = get(newOrder.getId());
        order.setItems(newOrder.getItems());
        order.setUserId(newOrder.getUserId());
        return order;
    }

    @Override
    public void delete(Long id) {
        Storage.orders
                .removeIf(order -> order.getId().equals(id));
    }
}
