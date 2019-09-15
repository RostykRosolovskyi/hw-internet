package internet.shop.idstorage;

public class BucketIdGenerator {
    private static long idValue = 0;

    public static long generateId() {
        return idValue++;
    }
}
