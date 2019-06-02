package by.itacademy.pinchuk.jd2.service;

import by.itacademy.pinchuk.jd2.dao.ContentDao;
import by.itacademy.pinchuk.jd2.dto.ContentFilterDto;
import by.itacademy.pinchuk.jd2.entity.Content;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ContentService {

    public static final ContentService INSTANCE = new ContentService();
    private ContentDao contentDao = ContentDao.getInstance();

    public Optional<Content> get(Long id, Session session) {
        return ContentDao.getInstance().get(id, session);
    }

    public List<Content> getFiltered(ContentFilterDto filterDto, Session session) {
        return contentDao.getFiltered(filterDto, session);
    }

    public static ContentService getInstance() {
        return INSTANCE;
    }
}
