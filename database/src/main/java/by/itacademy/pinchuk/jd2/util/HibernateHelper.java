package by.itacademy.pinchuk.jd2.util;

import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateHelper {

    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public Session getSession() {
        return SESSION_FACTORY.openSession();
    }

    public void closeSessionFactory() {
        SESSION_FACTORY.close();
    }
}
