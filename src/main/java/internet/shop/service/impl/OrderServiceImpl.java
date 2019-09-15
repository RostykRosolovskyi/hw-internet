package internet.shop.service.impl;

import internet.shop.dao.OrderDao;
import internet.shop.dao.UserDao;
import internet.shop.lib.Inject;
import internet.shop.lib.Service;
import internet.shop.model.Item;
import internet.shop.model.Order;
import internet.shop.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private static OrderDao orderDao;
    @Inject
    private static UserDao userDao;

    @Override
    public Order add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public void delete(Long id) {
        orderDao.delete(id);
    }

    @Override
    public Order completeOrder(List<Item> items, Long userId) {
        Order order = new Order();
        order.setItems(items);
        order.setUserId(userId);
        orderDao.add(order);
        userDao.get(userId).getOrders().add(order);
        return order;
    }
}
