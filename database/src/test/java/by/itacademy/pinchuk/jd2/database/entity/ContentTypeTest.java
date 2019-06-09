package by.itacademy.pinchuk.jd2.database.entity;

import by.itacademy.pinchuk.jd2.database.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.database.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContentTypeTest extends BaseEntityTest {

    @Test
    public void checkPersist() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        ExtraField extraField = TestEntityBuilder.buildExtraField();
        Content content = TestEntityBuilder.buildContent();
        ContentType contentType = TestEntityBuilder.buildContentType();
        contentType.addExtraField(extraField);
        contentType.addContent(content);
        session.persist(content);
        session.persist(extraField);
        session.persist(contentType);
        session.getTransaction().commit();
        assertNotNull(contentType.getId());
    }

    @Test
    public void checkFind() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        ExtraField extraField = TestEntityBuilder.buildExtraField();
        ContentType contentType = TestEntityBuilder.buildContentType();
        Content content = TestEntityBuilder.buildContent();
        contentType.addExtraField(extraField);
        contentType.addContent(content);
        session.persist(content);
        session.persist(extraField);
        session.persist(contentType);
        session.clear();
        ContentType findContentType = session.find(ContentType.class, contentType.getId());
        session.getTransaction().commit();
        assertNotNull(findContentType);
        assertTrue(findContentType.getExtraFields().size() > 0);
        assertTrue(findContentType.getContents().size() > 0);
    }
}
