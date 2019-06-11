package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
}
