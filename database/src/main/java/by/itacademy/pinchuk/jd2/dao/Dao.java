package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.BaseEntity;
import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import lombok.Cleanup;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class Dao<E extends BaseEntity, ID extends Serializable> implements BaseDao<E, ID> {

    private final Class<E> entityClass;

    public Dao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E find(ID id) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        E entity = session.find(entityClass, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<E> findAll() {
        // TODO: 2019-05-26 implement this method with QueryDSL
        return null;
    }

    @Override
    public void persist(E entity) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }

    @Override
    public void remove(E entity) {
        @Cleanup Session session = HibernateHelper.getSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
    }
}
