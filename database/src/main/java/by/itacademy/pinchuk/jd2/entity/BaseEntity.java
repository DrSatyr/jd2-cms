package by.itacademy.pinchuk.jd2.entity;

import java.io.Serializable;

public interface BaseEntity<PK extends Serializable> {

    PK getId();
}
