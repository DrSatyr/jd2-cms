package by.itacademy.pinchuk.jd2.database.entity;

import by.itacademy.pinchuk.jd2.database.util.HibernateHelper;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.junit.Before;

@Setter
@NoArgsConstructor
public abstract class BaseEntityTest {

    private static final Class[] USED_ENTITY_CLASSES = {
            ContentTranslation.class,
            CategoryTranslation.class,
            Comment.class,
            Content.class,
            User.class,
            Category.class,
            Tag.class,
            ExtraField.class,
            ExtraFieldType.class,
            ContentType.class
    };

    @Before
    public void cleanDatabase() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        for (Class clazz : USED_ENTITY_CLASSES) {
            session.createQuery(String.format("DELETE FROM %s", clazz.getSimpleName())).executeUpdate();
        }
        session.getTransaction().commit();
    }
}
