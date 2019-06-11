package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.ContentTranslation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTranslationRepository extends CrudRepository<ContentTranslation, ContentTranslation.ComplexId> {
}
