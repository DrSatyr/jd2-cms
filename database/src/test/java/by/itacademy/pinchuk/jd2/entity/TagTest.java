package by.itacademy.pinchuk.jd2.entity;

import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TagTest extends BaseEntityTest {

    @Test
    public void checkPersist() {

        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        Tag tag = TestEntityBuilder.buildTag(Lang.EN);
        session.persist(tag);
        session.getTransaction().commit();
        assertNotNull(tag.getId());
    }

    @Test
    public void checkFind() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        Tag tag = TestEntityBuilder.buildTag(Lang.EN);
        session.persist(tag);
        session.clear();
        Tag savedTag = session.get(Tag.class, tag.getId());
        session.getTransaction().commit();
        assertNotNull(savedTag);
    }
}