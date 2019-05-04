package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.dao.UserDao;
import by.itacademy.pinchuk.jd2.entity.User;

/**
 * UserService.
 */
public class UserService {

    private static final UserService INSTANCE = new UserService();
    private UserDao userDao = UserDao.getInstance();

    public User get(long id) {
        return userDao.get(id);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
