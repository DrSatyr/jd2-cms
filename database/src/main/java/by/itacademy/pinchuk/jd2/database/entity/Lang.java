package by.itacademy.pinchuk.jd2.database.entity;

import lombok.AllArgsConstructor;

import java.util.Locale;

@AllArgsConstructor
public enum Lang {
    ru_RU(new Locale("ru", "RU")),
    en_US(new Locale("en", "US"));
    
    private Locale locale;
}
