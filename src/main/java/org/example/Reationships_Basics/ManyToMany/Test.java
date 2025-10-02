package org.example.Reationships_Basics.ManyToMany;

import jakarta.persistence.Transient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .build();


            SessionFactory session_factory = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class)
                    .buildMetadata()
                    .buildSessionFactory();

            Session session = session_factory.openSession(); // Opening a session.
            Transaction transaction = session.beginTransaction();

            // Adding Students and Courses
            Student s1 = new Student();
            s1.setName("Garv");
            Student s2 = new Student();
            s2.setName("Ram");

            Course c1 = new Course();
            c1.setCourse_name("Java");
            Course c2 = new Course();
            c2.setCourse_name("Advanced JAVA");
            Course c3 = new Course();
            c3.setCourse_name("Python");

            // Linking the Student to courses via helper methods we created.
            s1.addCourse(c1);
            s1.addCourse(c2);

            s2.addCourse(c3);

            // Saving

            session.persist(s1);
            session.persist(s2);

            // Commit
            transaction.commit();
            session.close();
            session_factory.close();




    }
}
