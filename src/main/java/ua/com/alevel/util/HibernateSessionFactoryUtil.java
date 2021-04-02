package ua.com.alevel.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private HibernateSessionFactoryUtil(){
        throw new UnsupportedOperationException();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
