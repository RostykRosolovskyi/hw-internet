package internet.shop.factory;

import internet.shop.dao.BucketDao;
import internet.shop.dao.ItemDao;
import internet.shop.dao.OrderDao;
import internet.shop.dao.UserDao;
import internet.shop.dao.impl.BucketDaoImpl;
import internet.shop.dao.impl.ItemDaoImpl;
import internet.shop.dao.impl.OrderDaoImpl;
import internet.shop.dao.impl.UserDaoImpl;
import internet.shop.service.BucketService;
import internet.shop.service.ItemService;
import internet.shop.service.OrderService;
import internet.shop.service.UserService;
import internet.shop.service.impl.BucketServiceImpl;
import internet.shop.service.impl.ItemServiceImpl;
import internet.shop.service.impl.OrderServiceImpl;
import internet.shop.service.impl.UserServiceImpl;

public class Factory {
    private static ItemDao itemDaoInstance;
    private static UserDao userDaoInstance;
    private static OrderDao orderDaoInstance;
    private static BucketDao bucketDaoInstance;

    private static ItemService itemServiceInstance;
    private static UserService userServiceInstance;
    private static OrderService orderServiceInstance;
    private static BucketService bucketServiceInstance;

    private Factory() {
    }

    public static ItemDao getItemDao() {
        if (itemDaoInstance == null) {
            itemDaoInstance = new ItemDaoImpl();
        }
        return itemDaoInstance;
    }

    public static UserDao getUserDao() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDaoImpl();
        }
        return userDaoInstance;
    }

    public static OrderDao getOrderDao() {
        if (orderDaoInstance == null) {
            orderDaoInstance = new OrderDaoImpl();
        }
        return orderDaoInstance;
    }

    public static BucketDao getBucketDao() {
        if (bucketDaoInstance == null) {
            bucketDaoInstance = new BucketDaoImpl();
        }
        return bucketDaoInstance;
    }

    public static ItemService getItemService() {
        if (itemServiceInstance == null) {
            itemServiceInstance = new ItemServiceImpl();
        }
        return itemServiceInstance;
    }

    public static UserService getUserService() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserServiceImpl();
        }
        return userServiceInstance;
    }

    public static OrderService getOrderService() {
        if (orderServiceInstance == null) {
            orderServiceInstance = new OrderServiceImpl();
        }
        return orderServiceInstance;
    }

    public static BucketService getBucketService() {
        if (bucketServiceInstance == null) {
            bucketServiceInstance = new BucketServiceImpl();
        }
        return bucketServiceInstance;
    }
}
