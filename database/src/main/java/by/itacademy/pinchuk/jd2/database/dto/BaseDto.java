package by.itacademy.pinchuk.jd2.database.dto;

import java.io.Serializable;

public interface BaseDto<ID extends Serializable> {

    ID getId();
}
