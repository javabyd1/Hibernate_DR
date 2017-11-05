
import entity.BooksEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration ();
            configuration.configure ();
            ourSessionFactory = configuration.buildSessionFactory ();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError (ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession ();
    }

    public static void main(String[] args) throws Exception {
        Session session = ourSessionFactory.openSession ();
        Transaction tx = null;
        try {
            tx = session.beginTransaction ();
            List<BooksEntity> books =
                    session.createQuery (" FROM " + BooksEntity.class.getName ()).list ();

            for (BooksEntity book : books) {
                System.out.println (" Author:" + book.getAuthor ());
                System.out.println (" Tytul: " + book.getTitle ());
            }
            tx.commit ();
//dodawanie do bazy tabela book dane:autohor i nr ISBN
            tx =session.beginTransaction ();
//            BooksEntity booksEntity = new BooksEntity ();
//            booksEntity.setAuthor ("Author");
//            booksEntity.setIsbn ("ISBN 1233");
//            session.save (booksEntity);
//
//            tx.commit ();

            BooksEntity b1;
            b1 = (BooksEntity) session.load (BooksEntity.class, 5);
            session.delete (b1);
            tx.commit ();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback ();
            }
            e.printStackTrace ();
        } finally {
            session.close ();
        }
    }


}

