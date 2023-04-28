package com.sao.hibernate.database;

import com.sao.hibernate.data.Person;
import com.sao.hibernate.data.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

/**
 * @author saozd
 * @project com.sao.hibernate.database courseexample
 * 18.04.2023 Nis 2023
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private final static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(Person.class);
//            configuration.addAnnotatedClass(User.class);
            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.out.println("Session factory error");
            logger.error("Session factory error", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
