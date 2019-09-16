package internet.shop.idstorage;

public class ItemIdGenerator {
    private static long idValue = 0;

    public static long generateId() {
        return idValue++;
    }
}
