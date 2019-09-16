package internet.shop.lib;

import internet.shop.Main;
import internet.shop.dao.BucketDao;
import internet.shop.dao.ItemDao;
import internet.shop.dao.OrderDao;
import internet.shop.dao.UserDao;
import internet.shop.factory.Factory;
import internet.shop.service.BucketService;
import internet.shop.service.ItemService;
import internet.shop.service.OrderService;
import internet.shop.service.UserService;
import internet.shop.service.impl.BucketServiceImpl;
import internet.shop.service.impl.ItemServiceImpl;
import internet.shop.service.impl.OrderServiceImpl;
import internet.shop.service.impl.UserServiceImpl;

import java.lang.reflect.Field;
import java.security.Provider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Injector {
    private static List<Class> classesContainDaoFields = new ArrayList<>();
    private static List<Class> classesContainServiceFields = new ArrayList<>();
    private static Map<Class, Object> injectedFieldClassesWithImpls = new HashMap<>();

    static {
        classesContainDaoFields.add(BucketServiceImpl.class);
        classesContainDaoFields.add(ItemServiceImpl.class);
        classesContainDaoFields.add(OrderServiceImpl.class);
        classesContainDaoFields.add(UserServiceImpl.class);
        classesContainServiceFields.add(Main.class);
        injectedFieldClassesWithImpls.put(BucketDao.class, Factory.getBucketDao());
        injectedFieldClassesWithImpls.put(UserDao.class, Factory.getUserDao());
        injectedFieldClassesWithImpls.put(OrderDao.class, Factory.getOrderDao());
        injectedFieldClassesWithImpls.put(ItemDao.class, Factory.getItemDao());
        injectedFieldClassesWithImpls.put(BucketService.class, Factory.getBucketService());
        injectedFieldClassesWithImpls.put(ItemService.class, Factory.getItemService());
        injectedFieldClassesWithImpls.put(OrderService.class, Factory.getOrderService());
        injectedFieldClassesWithImpls.put(UserService.class, Factory.getUserService());
    }

    public static void injectDependencies() throws IllegalAccessException {
        injectDaoDependencies(classesContainDaoFields, Dao.class);
        injectDaoDependencies(classesContainServiceFields, Service.class);
    }

    private static void injectDaoDependencies(List<Class> classesContainInjectedFields,
                                              Class annotationType) throws IllegalAccessException {
        for (Class containsInjectFieldsClass : classesContainInjectedFields) {
            Field[] fields = containsInjectFieldsClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getDeclaredAnnotation(Inject.class) != null
                        && injectedFieldClassesWithImpls.containsKey(field.getType())
                        && injectedFieldClassesWithImpls.get(field.getType()).getClass()
                        .getDeclaredAnnotation(annotationType) != null) {
                    field.setAccessible(true);
                    field.set(null, injectedFieldClassesWithImpls.get(field.getType()));
                }
            }
        }
    }
}
