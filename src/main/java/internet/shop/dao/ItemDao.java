package internet.shop.dao;

import internet.shop.model.Item;

public interface ItemDao {
    Item add(Item item);

    Item get(Long id);

    Item update(Item item);

    void delete(Long id);

    void delete(Item item);
}
