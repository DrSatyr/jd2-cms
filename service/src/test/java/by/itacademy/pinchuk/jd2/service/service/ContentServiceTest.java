package by.itacademy.pinchuk.jd2.service.service;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.entity.QContent;
import by.itacademy.pinchuk.jd2.database.util.DslPredicateBuilder;
import by.itacademy.pinchuk.jd2.service.BaseTest;
import by.itacademy.pinchuk.jd2.service.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class ContentServiceTest extends BaseTest {

    @Autowired
    ContentService contentService;

    @Test
    public void checkFindAll() {
        List<ContentDto> contents = contentService.findAll();
        assertThat(contents, hasSize(10));
    }

    @Test
    public void checkFindAllWithPredicateAndPageable() {
        List<ContentDto> list = contentService.findAll(
                new DslPredicateBuilder()
                        .containsIgnoreCase(QContent.content.translations.any().title, "Test")
                        .build(),
                PageRequest.of(0, 5));
        assertThat(list, hasSize(5));
    }
}