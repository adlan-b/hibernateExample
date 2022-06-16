import main.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        chekCourse(session);
        chekTeacher(session);
        chekStudent(session);
        chekSubscription(session);
        transaction.commit();
        sessionFactory.close();
    }

    private static void chekCourse(Session session) {
        String hql = "SELECT c FROM Course c where c.type = \'" + CourseType.PROGRAMMING + "'";
        List<Course> list = session.createQuery(hql, Course.class).getResultList();
        list.forEach(System.out::println);
    }

    private static void chekTeacher(Session session) {
        String hql = "SELECT t FROM Teacher t where t.id = 12";
        Teacher teacher = session.createQuery(hql, Teacher.class).getSingleResult();
        System.out.println(teacher);
    }

    private static void chekStudent(Session session) {
        String hql = "SELECT s FROM Student s  where s.age > 20 and s.age < 25";
        List<Student> list = session.createQuery(hql, Student.class).getResultList();
        list.forEach(System.err::println);
    }

    private static void chekSubscription(Session session) {
        String hql = "SELECT sub FROM Subscription sub where sub.id.student = 1";
        List<Subscription> list = session.createQuery(hql, Subscription.class).getResultList();
        list.forEach(System.err::println);
    }

}
