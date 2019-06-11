package by.itacademy.pinchuk.jd2.database.repository;

import by.itacademy.pinchuk.jd2.database.entity.CategoryTranslation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTranslationRepository extends CrudRepository<CategoryTranslation, CategoryTranslation.ComplexId> {
}
