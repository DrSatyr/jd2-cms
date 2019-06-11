package by.itacademy.pinchuk.jd2.database.entity;

import by.itacademy.pinchuk.jd2.database.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.database.util.TestEntityBuilder;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CategoryTest extends BaseEntityTest {

    @Test
    public void checkPersist() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Category category = TestEntityBuilder.buildCategory();
        for (Lang lang : Lang.values()) {
            category.addTranslation(TestEntityBuilder.buildCategoryTranslation(lang));
        }
        Category childCategory = TestEntityBuilder.buildCategory();
        for (Lang lang : Lang.values()){
            childCategory.addTranslation(TestEntityBuilder.buildCategoryTranslation(lang));
        }
        category.addChildCategory(childCategory);
        Serializable id = session.save(category);
        Serializable childId = session.save(childCategory);

        session.getTransaction().commit();
        assertNotNull(id);
        assertNotNull(childId);
    }

    @Test
    public void checkFind() {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();

        Category category = TestEntityBuilder.buildCategory();
        for (Lang lang : Lang.values()) {
            category.addTranslation(TestEntityBuilder.buildCategoryTranslation(lang));
        }
        Category childCategory = TestEntityBuilder.buildCategory();
        for (Lang lang : Lang.values()){
            childCategory.addTranslation(TestEntityBuilder.buildCategoryTranslation(lang));
        }
        category.addChildCategory(childCategory);
        Serializable id = session.save(category);
        Serializable childId = session.save(childCategory);
        session.flush();
        session.clear();
        Category fetchedCategory = session.get(Category.class, childId);

        session.getTransaction().commit();
        assertNotNull(fetchedCategory);
        assertTrue(fetchedCategory.getTranslations().size() > 0);
        assertNotNull(fetchedCategory.getParentCategory());
        assertTrue(fetchedCategory.getParentCategory().getTranslations().size() > 0);
        assertTrue(fetchedCategory.getParentCategory().getChildCategories().size() > 0);
    }
}