package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.BaseTest;
import by.itacademy.pinchuk.jd2.database.entity.Content;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import by.itacademy.pinchuk.jd2.database.util.DslPredicateBuilder;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static by.itacademy.pinchuk.jd2.database.entity.QContent.content;
import static org.junit.Assert.assertThat;

public class ContentRepositoryTest extends BaseTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    public void checkFindAllWithPredicate() {
        Iterable<Content> contents = contentRepository.findAll(
                new DslPredicateBuilder()
                        .containsIgnoreCase(content.translations.get(Lang.ru_RU).title, "Test")
                        .build()
        );
        assertThat(contents, Matchers.iterableWithSize(10));
    }
}