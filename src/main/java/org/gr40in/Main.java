package org.gr40in;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration
                .addAnnotatedClass(Course.class)
                .configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            System.out.println("ok");
            Course course = Course.builder()
                    .id(1)
                    .title("Java + Lombok")
                    .duration(3)
                    .build();

            session.save(course);
            session.getTransaction().commit();

        }

    }
}