package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.BaseEntity;
import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import lombok.Cleanup;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface BaseDao<ID extends Serializable, E extends BaseEntity<ID>> {

    default Optional<E> get(ID id) {
        @Cleanup Session session = HibernateHelper.getSession();
        E entity = session.find(getClazz(), id);
        return Optional.ofNullable(entity);
    }

    default ID save(E entity) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    default void update(E entity) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    default void delete(E entity) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    default List<E> findAll() {
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    default Class<E> getClazz() {
        ParameterizedType parameterizedInterface = (ParameterizedType) this.getClass().getGenericInterfaces()[0];
        return (Class<E>) parameterizedInterface.getActualTypeArguments()[1];
    }
}
