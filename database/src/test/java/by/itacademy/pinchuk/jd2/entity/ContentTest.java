package by.itacademy.pinchuk.jd2.entity;

import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContentTest extends BaseEntityTest {

    @Test
    public void checkPersist() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Content content = buildContentWithDependencies();
        session.persist(content);

        session.getTransaction().commit();
        assertNotNull(content.getId());
    }

    @Test
    public void checkFind() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Content content = buildContentWithDependencies();
        session.persist(content);
        session.flush();
        session.clear();
        Content findContent = session.find(Content.class, content.getId());

        session.getTransaction().commit();
        assertNotNull(findContent);
        assertNotNull(findContent.getContentType());
        assertNotNull(findContent.getCategory());
        assertNotNull(findContent.getCreatedBy());
        assertTrue(findContent.getComments().size() > 0);
        assertTrue(findContent.getTranslations().size() > 0);
        assertTrue(findContent.getTags().size() > 0);
    }

    private Content buildContentWithDependencies() {
        Content content = TestEntityBuilder.buildContent();
        Comment comment = TestEntityBuilder.buildComment();
        ContentType contentType = TestEntityBuilder.buildContentType();
        Category category = TestEntityBuilder.buildCategory();
        User user = TestEntityBuilder.buildUser();

        contentType.addContent(content);
        category.addContent(content);
        user.addContent(content);
        content.addComment(comment);
        for (Lang lang : Lang.values()) {
            content.addTag(TestEntityBuilder.buildTag(lang));
            content.addTranslation(TestEntityBuilder.buildContentTranslation(lang));
        }
        return content;
    }
}
