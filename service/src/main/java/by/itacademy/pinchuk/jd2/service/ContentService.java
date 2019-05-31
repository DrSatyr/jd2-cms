package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.dao.ContentDao;
import by.itacademy.pinchuk.jd2.entity.Content;

import java.util.Optional;

public class ContentService {

    public static final ContentService INSTANCE = new ContentService();

    public Optional<Content> find(Long id) {
        return ContentDao.getInstance().get(id);
    }

    public static ContentService getInstance() {
        return INSTANCE;
    }
}
