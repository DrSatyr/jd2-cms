package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.User;

public class UserDao implements BaseDao<Long, User> {

    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
