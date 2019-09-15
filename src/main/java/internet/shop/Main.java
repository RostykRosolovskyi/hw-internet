package internet.shop;

import internet.shop.lib.Inject;
import internet.shop.lib.Injector;
import internet.shop.model.Bucket;
import internet.shop.model.Item;
import internet.shop.model.User;
import internet.shop.service.BucketService;
import internet.shop.service.ItemService;
import internet.shop.service.OrderService;
import internet.shop.service.UserService;

public class Main {
    static {
        try {
            Injector.injectDependencies();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Inject
    private static UserService userService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;

    public static void main(String[] args) {
        Item ball = itemService.add(new Item("Ball", 120.4));
        Item puppy = itemService.add(new Item("Puppy", 3.2));
        User rostyk = userService.add(new User());

        Bucket rostykBucketid = bucketService.get(rostyk.getBucket().getId());
        bucketService.addItem(rostykBucketid, ball);
        bucketService.addItem(rostykBucketid, puppy);
        orderService.completeOrder(rostykBucketid.getItems(), rostykBucketid.getUserId());
        System.out.println(rostyk.getOrders().get(0).getItems());
    }
}
