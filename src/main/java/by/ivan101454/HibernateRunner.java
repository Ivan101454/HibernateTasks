package by.ivan101454;

import by.ivan101454.entities.Transaction;
import by.ivan101454.entities.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(Visit.class);
//        configuration.addAnnotatedClass(Transaction.class);
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("OK");
            session.beginTransaction();
            Visit visit = Visit.builder()
                    .visitId(10)
                    .customerId(54)
                    .build();
            session.persist(visit);
//            var result = session.createQuery("select v.visitId from Visit v", Visit.class).list();
            session.getTransaction().commit();
        }
    }
}
