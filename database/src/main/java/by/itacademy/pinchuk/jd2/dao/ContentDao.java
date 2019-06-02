package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.dto.ContentFilterDto;
import by.itacademy.pinchuk.jd2.entity.Content;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;

import static by.itacademy.pinchuk.jd2.entity.QContent.content;
import static by.itacademy.pinchuk.jd2.entity.QUser.user;

public class ContentDao implements BaseDao<Long, Content> {

    private static final ContentDao INSTANCE = new ContentDao();

    public List<Content> getFiltered(ContentFilterDto filterDto, Session session) {
        JPAQuery<Content> jpaQuery = new JPAQuery<>(session);
        JPAQuery<Content> query = jpaQuery.select(content)
                .from(content);

        if (Objects.nonNull(filterDto.getActive())) {
            query.where(content.active.eq(filterDto.getActive()));
        }
        if (Objects.nonNull(filterDto.getCreatedBy())) {
            query.innerJoin(content.createdBy, user)
                    .where(user.username.eq(filterDto.getCreatedBy()));
        }
        if (Objects.nonNull(filterDto.getTitle())) {
            query.where(content.translations.any().title.containsIgnoreCase(filterDto.getTitle()));
        }
        if (Objects.nonNull(filterDto.getTag())) {
            query.where(content.tags.any().value.eq(filterDto.getTag()));
        }
        query.limit(filterDto.getPaging().getLimit());
        query.offset(filterDto.getPaging().getOffset());
        return query.fetch();
    }

    public static ContentDao getInstance() {
        return INSTANCE;
    }
}
