package by.itacademy.pinchuk.jd2.dao;


import by.itacademy.pinchuk.jd2.entity.User;

/**
 * UserDao.
 */
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public User get(Long id) {
        return User.builder()
                .id(id)
                .name("John")
                .build();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
