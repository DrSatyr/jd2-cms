package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.database.util.TestDatabaseHelper;
import by.itacademy.pinchuk.jd2.service.config.ServiceConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public abstract class BaseTest {

    @Autowired
    private TestDatabaseHelper databaseHelper;

    @Before
    public void init() {
        databaseHelper.clear();
        databaseHelper.fill(10);
    }
}
