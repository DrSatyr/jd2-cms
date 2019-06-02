package by.itacademy.pinchuk.jd2.util;

import by.itacademy.pinchuk.jd2.entity.Administrator;
import by.itacademy.pinchuk.jd2.entity.Category;
import by.itacademy.pinchuk.jd2.entity.CategoryTranslation;
import by.itacademy.pinchuk.jd2.entity.Comment;
import by.itacademy.pinchuk.jd2.entity.CommentStatus;
import by.itacademy.pinchuk.jd2.entity.Content;
import by.itacademy.pinchuk.jd2.entity.ContentTranslation;
import by.itacademy.pinchuk.jd2.entity.ContentType;
import by.itacademy.pinchuk.jd2.entity.Editor;
import by.itacademy.pinchuk.jd2.entity.ExtraField;
import by.itacademy.pinchuk.jd2.entity.ExtraFieldType;
import by.itacademy.pinchuk.jd2.entity.Lang;
import by.itacademy.pinchuk.jd2.entity.Tag;
import by.itacademy.pinchuk.jd2.entity.User;
import by.itacademy.pinchuk.jd2.entity.UserRole;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class TestEntityBuilder {

    public Category buildCategory() {
        return Category.builder()
                .alias("someAlias")
                .created(LocalDateTime.now())
                .active(true)
                .build();
    }

    public CategoryTranslation buildCategoryTranslation(Lang lang) {
        return CategoryTranslation.builder()
                .id(CategoryTranslation.ComplexId.builder().lang(lang).build())
                .title(lang.name() + "_TestName")
                .introText(lang.name() + "_TestIntroText")
                .metaTitle(lang.name() + "_TestTitle")
                .metaDescription(lang.name() + "_TestDescription")
                .metaKeywords(lang.name() + "_TestMetaKeywords")
                .build();
    }

    public User buildUser() {
        return User.userBuilder()
                .username("user")
                .email("user@email.ru")
                .phone("+375447949471")
                .password("testPass")
                .active(true)
                .role(UserRole.USER)
                .registerDate(LocalDateTime.now())
                .birthDate(LocalDateTime.now())
                .name("TestUser")
                .surname("TestUserSurname")
                .build();
    }

    public Editor buildEditor() {
        return Editor.editorBuilder()
                .username("editor")
                .email("editor@email.ru")
                .phone("+375447949471")
                .password("testPass")
                .active(true)
                .role(UserRole.EDITOR)
                .registerDate(LocalDateTime.now())
                .birthDate(LocalDateTime.now())
                .name("TestUser")
                .surname("TestUserSurname")
                .additionalInfo("Some additional info")
                .build();
    }

    public Administrator buildAdministrator() {
        return Administrator.administratorBuilder()
                .username("administrator")
                .email("administrator@email.ru")
                .phone("+375447949471")
                .password("testPass")
                .active(true)
                .role(UserRole.ADMINISTRATOR)
                .registerDate(LocalDateTime.now())
                .birthDate(LocalDateTime.now())
                .name("TestUser")
                .surname("TestUserSurname")
                .additionalInfo("Some additioanl info")
                .build();
    }

    public Comment buildComment() {
        return Comment.builder()
                .created(LocalDateTime.now())
                .fullText("TestFullText")
                .commentStatus(CommentStatus.PUBLISHED)
                .build();
    }

    public Content buildContent() {
        return Content.builder()
                .alias("TestContentAlias")
                .created(LocalDateTime.now())
                .lastModified(LocalDateTime.now())
                .publishUp(LocalDateTime.now())
                .publishDown(LocalDateTime.now())
                .hits(100)
                .active(true)
                .extraFields("")
                .build();
    }

    public ContentTranslation buildContentTranslation(Lang lang) {
        return ContentTranslation.builder()
                .id(ContentTranslation.ComplexId.builder().lang(lang).build())
                .title("TestContentName")
                .introText("TestIntroText")
                .fullText("TestFullText")
                .metaTitle("TestMetaTitle")
                .metaDescription("TestMetaDescription")
                .metaKeywords("TestMetaKeywords")
                .build();
    }

    public ContentType buildContentType() {
        return ContentType.builder()
                .name("TestContentType")
                .active(true)
                .build();
    }

    public ExtraField buildExtraField() {
        return ExtraField.builder().build();
    }

    public ExtraFieldType buildExtraFieldType() {
        return ExtraFieldType.builder()
                .name("TestExtraFieldType")
                .metadata("TestMetaData")
                .build();
    }

    public Tag buildTag(Lang lang) {
        return Tag.builder()
                .lang(lang)
                .value("EN_testTeg")
                .build();
    }
}
