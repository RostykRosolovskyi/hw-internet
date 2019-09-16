package internet.shop.dao;

import internet.shop.model.Order;

public interface OrderDao {
    Order add(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);
}
