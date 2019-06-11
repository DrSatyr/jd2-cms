package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
