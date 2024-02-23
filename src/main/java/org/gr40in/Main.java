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

            // create
            Course course = new Course("Java + Lombok", 3);
//            Course course = Course.builder()
//                    .id(100)
//                    .title("Java + Lombok")
//                    .duration(3)
//                    .build();

            session.save(course);

            Course someCourse = session.get(Course.class, 1);
            System.out.println(someCourse);
            someCourse.setTitle("some another tiitle");

            Course someCourseForDelete = session.get(Course.class, 2);
            session.delete(someCourseForDelete);

            session.getTransaction().commit();

        }

    }
}