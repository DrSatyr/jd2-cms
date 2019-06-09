package by.itacademy.pinchuk.jd2.database;

import by.itacademy.pinchuk.jd2.database.config.DatabaseConfig;
import by.itacademy.pinchuk.jd2.database.util.TestDatabaseHelper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public abstract class BaseTest {

    @Autowired
    private TestDatabaseHelper databaseHelper;

    @Before
    public void init() {
        databaseHelper.clear();
        databaseHelper.fill(10);
    }
}
