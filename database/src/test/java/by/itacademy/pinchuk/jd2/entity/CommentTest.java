package by.itacademy.pinchuk.jd2.entity;

import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CommentTest extends BaseEntityTest {

    @Test
    public void checkPersist() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Content content = TestEntityBuilder.buildContent();
        Comment comment = TestEntityBuilder.buildComment();
        content.addComment(comment);
        session.persist(content);
        session.persist(comment);

        session.getTransaction().commit();
        assertNotNull(comment.getId());
    }

    @Test
    public void checkFind() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Content content = TestEntityBuilder.buildContent();
        Comment comment = TestEntityBuilder.buildComment();
        content.addComment(comment);
        session.persist(content);
        session.persist(comment);
        session.flush();
        session.clear();
        Comment findComment = session.find(Comment.class, comment.getId());

        session.getTransaction().commit();
        assertNotNull(findComment);
        assertNotNull(findComment.getContent());
    }
}
