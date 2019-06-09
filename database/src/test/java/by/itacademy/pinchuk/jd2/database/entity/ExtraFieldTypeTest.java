package by.itacademy.pinchuk.jd2.database.entity;

import by.itacademy.pinchuk.jd2.database.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.database.util.TestEntityBuilder;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExtraFieldTypeTest extends BaseEntityTest {

    @Test
    public void checkPersist() {
        Session session = HibernateHelper.getSession();
        session.beginTransaction();

        ExtraField extraField = TestEntityBuilder.buildExtraField();
        ExtraFieldType extraFieldType = TestEntityBuilder.buildExtraFieldType();
        extraFieldType.addExtraField(extraField);
        session.persist(extraField);
        session.persist(extraFieldType);

        session.getTransaction().commit();
        assertNotNull(extraFieldType.getId());
    }

    @Test
    public void checkFind() {
        Session session = HibernateHelper.getSession();
        session.beginTransaction();

        ExtraField extraField = TestEntityBuilder.buildExtraField();
        ExtraFieldType extraFieldType = TestEntityBuilder.buildExtraFieldType();
        extraFieldType.addExtraField(extraField);
        session.persist(extraField);
        session.persist(extraFieldType);
        session.flush();
        session.clear();
        ExtraFieldType findExtraFieldType = session.find(ExtraFieldType.class, extraFieldType.getId());

        session.getTransaction().commit();
        assertNotNull(findExtraFieldType);
        assertTrue(findExtraFieldType.getExtraFields().size() > 0);
    }
}
