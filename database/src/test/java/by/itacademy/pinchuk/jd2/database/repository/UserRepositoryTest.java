package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.BaseTest;
import by.itacademy.pinchuk.jd2.database.config.DatabaseConfig;
import by.itacademy.pinchuk.jd2.database.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.iterableWithSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkFindAll() {
        Iterable<User> all = userRepository.findAll();
        assertThat(all, iterableWithSize(10));
    }
}