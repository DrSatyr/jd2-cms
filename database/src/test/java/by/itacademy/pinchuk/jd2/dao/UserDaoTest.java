package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.Administrator;
import by.itacademy.pinchuk.jd2.entity.Editor;
import by.itacademy.pinchuk.jd2.entity.User;
import by.itacademy.pinchuk.jd2.util.TestEntityBuilder;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private UserDao userDao = UserDao.getInstance();

    @Test
    public void checkUserDaoGet () {
        Long userId = userDao.save(TestEntityBuilder.buildUser());
        Long editorId = userDao.save(TestEntityBuilder.buildEditor());
        Long administratorId = userDao.save(TestEntityBuilder.buildAdministrator());
        Optional<User> user = userDao.get(userId);
        Optional<User> editor = userDao.get(editorId);
        Optional<User> administrator = userDao.get(administratorId);
        assertTrue(user.isPresent() && user.get().getClass() == User.class);
        assertTrue(editor.isPresent() && editor.get().getClass() == Editor.class);
        assertTrue(administrator.isPresent() && administrator.get().getClass() == Administrator.class);
    }
}