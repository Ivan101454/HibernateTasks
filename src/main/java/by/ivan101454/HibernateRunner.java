package by.ivan101454;

import by.ivan101454.entities.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println("OK");
            Visit visit = Visit.builder()
                    .customerId(54)
                    .visitId(9)
                    .build();
            session.save(visit);
            session.getTransaction().commit();
        }
    }
}
