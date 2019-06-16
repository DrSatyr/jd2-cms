package by.itacademy.pinchuk.jd2.service.service;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import by.itacademy.pinchuk.jd2.database.entity.QContent;
import by.itacademy.pinchuk.jd2.database.util.DslPredicateBuilder;
import by.itacademy.pinchuk.jd2.service.BaseTest;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class ContentServiceTest extends BaseTest {

    @Autowired
    private ContentService contentService;

    @Test
    public void checkFindAll() {
        List<ContentDto> contents = contentService.findAll();
        assertThat(contents, hasSize(10));
    }

    @Test
    public void checkFindAllWithPredicateAndPageable() {
        Predicate predicate = new DslPredicateBuilder()
                .containsIgnoreCase(QContent.content.translations.get(Lang.ru_RU).title, "Test")
                .build();
        List<ContentDto> list = contentService.findAllOnPage(predicate, 1, 5);
        assertThat(list, hasSize(5));
    }
}
