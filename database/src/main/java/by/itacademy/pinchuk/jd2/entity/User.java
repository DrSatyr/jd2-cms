package by.itacademy.pinchuk.jd2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private String surName;
}
