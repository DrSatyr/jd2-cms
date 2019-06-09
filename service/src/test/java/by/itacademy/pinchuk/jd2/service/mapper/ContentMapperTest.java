package by.itacademy.pinchuk.jd2.service.mapper;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.dto.FullContentDto;
import by.itacademy.pinchuk.jd2.database.entity.Category;
import by.itacademy.pinchuk.jd2.database.entity.Comment;
import by.itacademy.pinchuk.jd2.database.entity.Content;
import by.itacademy.pinchuk.jd2.database.entity.ContentType;
import by.itacademy.pinchuk.jd2.database.entity.Editor;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import by.itacademy.pinchuk.jd2.database.util.TestEntityBuilder;
import by.itacademy.pinchuk.jd2.service.BaseTest;
import by.itacademy.pinchuk.jd2.service.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@Transactional
public class ContentMapperTest extends BaseTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void checkContentMapper() {
        Content content = BuildContentWithDependencies();

        ContentDto contentDto = contentMapper.toContentDto(content);
        assertNotNull(contentDto);
        assertNotNull(contentDto.getCreatedBy());
        assertNotNull(contentDto.getCategory());
        assertNotNull(contentDto.getContentType());
        assertThat(contentDto.getTranslations(), hasSize(3));

        FullContentDto fullContentDto = contentMapper.toFullContentDto(content);
        assertNotNull(fullContentDto);
        assertNotNull(fullContentDto.getCreatedBy());
        assertNotNull(fullContentDto.getCategory());
        assertNotNull(fullContentDto.getContentType());
        assertThat(fullContentDto.getTranslations(), hasSize(3));
        assertThat(fullContentDto.getComments(), hasSize(1));
        assertThat(fullContentDto.getTags(), hasSize(3));

        Content contentFromDto = contentMapper.fromContentDto(contentDto);
        assertNotNull(contentFromDto);
        assertNotNull(contentFromDto.getCreated());
        assertNotNull(contentFromDto.getCategory());
        assertNotNull(contentFromDto.getContentType());
        assertThat(contentFromDto.getTranslations(), hasSize(3));

        Content contentFromFullDto = contentMapper.fromFullContentDto(fullContentDto);
        assertNotNull(contentFromFullDto);
        assertNotNull(contentFromFullDto.getCreated());
        assertNotNull(contentFromFullDto.getCategory());
        assertNotNull(contentFromFullDto.getContentType());
        assertThat(contentFromFullDto.getTranslations(), hasSize(3));
        assertThat(contentFromFullDto.getComments(), hasSize(1));
        assertThat(contentFromFullDto.getTags(), hasSize(3));
    }

    private Content BuildContentWithDependencies() {
        Content content = TestEntityBuilder.buildContent();
        Comment comment = TestEntityBuilder.buildComment();
        ContentType contentType = TestEntityBuilder.buildContentType();
        Category category = TestEntityBuilder.buildCategory();
        Editor editor = TestEntityBuilder.buildEditor();

        contentType.addContent(content);
        category.addContent(content);
        editor.addContent(content);
        content.addComment(comment);
        for (Lang lang : Lang.values()) {
            content.addTag(TestEntityBuilder.buildTag(lang));
            content.addTranslation(TestEntityBuilder.buildContentTranslation(lang));
        }
        return content;
    }
}