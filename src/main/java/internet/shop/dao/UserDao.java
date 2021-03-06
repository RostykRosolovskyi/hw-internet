package internet.shop.dao;

import internet.shop.model.User;

public interface UserDao {
    User add(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);
}
