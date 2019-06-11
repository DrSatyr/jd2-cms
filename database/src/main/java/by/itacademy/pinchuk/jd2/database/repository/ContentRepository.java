package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.Content;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends PagingAndSortingRepository<Content, Long>, QuerydslPredicateExecutor<Content> {

}
