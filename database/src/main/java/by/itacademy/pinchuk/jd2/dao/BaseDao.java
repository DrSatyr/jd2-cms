package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface BaseDao<ID extends Serializable, E extends BaseEntity<ID>> {

    default Optional<E> get(ID id, Session session) {
        E entity = session.find(getClazz(), id);
        return Optional.ofNullable(entity);
    }

    default ID save(E entity, Session session) {
        session.beginTransaction();
        Serializable id = session.save(entity);
        session.getTransaction().commit();
        return entity.getId();
    }

    default void update(E entity, Session session) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    default void delete(E entity, Session session) {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    default List<E> findAll(Session session) {
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    default Class<E> getClazz() {
        ParameterizedType parameterizedInterface = (ParameterizedType) this.getClass().getGenericInterfaces()[0];
        return (Class<E>) parameterizedInterface.getActualTypeArguments()[1];
    }
}
