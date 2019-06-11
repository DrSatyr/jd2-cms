package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.BaseTest;
import by.itacademy.pinchuk.jd2.database.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkFindAll() {
        Iterable<User> all = userRepository.findAll();
        assertThat(all, iterableWithSize(10));
    }
}