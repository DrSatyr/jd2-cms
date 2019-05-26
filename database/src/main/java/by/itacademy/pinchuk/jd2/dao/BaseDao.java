package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E extends BaseEntity, ID extends Serializable> {

    E find(ID id);

    List<E> findAll();

    void persist(E entity);

    void remove(E entity);
}
