package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.ExtraFieldType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraFieldTypeRepository extends PagingAndSortingRepository<ExtraFieldType, Long> {
}
