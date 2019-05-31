package by.itacademy.pinchuk.jd2.dao;

import by.itacademy.pinchuk.jd2.entity.Content;

public class ContentDao implements BaseDao<Long, Content> {

    private static final ContentDao INSTANCE = new ContentDao();

    public static ContentDao getInstance() {
        return INSTANCE;
    }
}
