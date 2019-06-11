package by.itacademy.pinchuk.jd2.database.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.StringPath;

import java.util.Objects;

public class DslPredicateBuilder {

    private BooleanBuilder predicateBuilder = new BooleanBuilder();

    public DslPredicateBuilder eq(StringPath dslPath, String value) {
        if (Objects.nonNull(value)) {
            predicateBuilder.and(dslPath.eq(value));
        }
        return this;
    }

    public DslPredicateBuilder eq(BooleanPath dslPath, Boolean value) {
        if (Objects.nonNull(value)) {
            predicateBuilder.and(dslPath.eq(value));
        }
        return this;
    }

    public DslPredicateBuilder containsIgnoreCase(StringPath dslPath, String value) {
        if (Objects.nonNull(value)) {
            predicateBuilder.and(dslPath.containsIgnoreCase(value));
        }
        return this;
    }

    public Predicate build() {
        return predicateBuilder.getValue();
    }
}
