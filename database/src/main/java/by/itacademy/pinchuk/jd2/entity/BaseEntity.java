package by.itacademy.pinchuk.jd2.entity;

import java.io.Serializable;

public interface BaseEntity<ID extends Serializable> {

    ID getId();
}
