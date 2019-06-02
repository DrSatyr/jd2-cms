package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.Administrator;
import by.itacademy.pinchuk.jd2.entity.Editor;
import by.itacademy.pinchuk.jd2.entity.User;
import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private UserDao userDao = UserDao.getInstance();

    @Test
    public void checkUserDaoGet () {
        @Cleanup Session session = HibernateHelper.getSession();
        Long userId = userDao.save(TestEntityBuilder.buildUser(), session);
        Long editorId = userDao.save(TestEntityBuilder.buildEditor(), session);
        Long administratorId = userDao.save(TestEntityBuilder.buildAdministrator(), session);
        Optional<User> user = userDao.get(userId, session);
        Optional<User> editor = userDao.get(editorId, session);
        Optional<User> administrator = userDao.get(administratorId, session);
        assertTrue(user.isPresent() && user.get().getClass() == User.class);
        assertTrue(editor.isPresent() && editor.get().getClass() == Editor.class);
        assertTrue(administrator.isPresent() && administrator.get().getClass() == Administrator.class);
    }
}