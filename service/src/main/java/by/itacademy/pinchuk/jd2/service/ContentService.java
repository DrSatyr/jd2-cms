package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.dao.Dao;
import by.itacademy.pinchuk.jd2.entity.Content;

public class ContentService {

    public static final ContentService INSTANCE = new ContentService();

    public Content find(Long id) {
        Dao<Content, Long> contentDao = new Dao<>(Content.class);
        return contentDao.find(id);
    }

    public static ContentService getInstance() {
        return INSTANCE;
    }
}
