package by.ivan101454;

import by.ivan101454.entities.Transaction;
import by.ivan101454.entities.Visit;
import by.ivan101454.entities.news.Article;
import by.ivan101454.entities.news.Picture;
import by.ivan101454.entities.news.Text;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Visit.class);
        configuration.addAnnotatedClass(Transaction.class);
//        configuration.addAnnotatedClass(Text.class);
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            System.out.println("OK");
            session.beginTransaction();
            Text text = Text.builder()
                    .textId(1)
                    .textLink("input.txt")
                    .build();

            Picture picture = Picture.builder()
                    .pictureId(1)
                    .pictureLink("picture.jpeg")
                    .build();
//
//            Article article = Article.builder()
//                    .articleId(1)
//                    .articleName("Break News")
//                    .articleText(text)
//                    .articlePicture(picture)
//                    .articleAuthor("I am")
//                    .build();
//
            session.persist(text);
            session.persist(picture);
//            session.persist(article);

//            Visit visit = Visit.builder()
//                    .visitId(11)
//                    .customerId(54)
//                    .build();
//            session.persist(visit);
//            var result = session.createQuery("select v.visitId from Visit v", Visit.class).list();
            session.getTransaction().commit();
        }
    }
}
