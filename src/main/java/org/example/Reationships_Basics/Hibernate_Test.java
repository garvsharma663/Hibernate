package org.example.Reationships_Basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.security.auth.login.Configuration;

public class Hibernate_Test {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()

                .build();

        SessionFactory factory = new MetadataSources(registry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Project.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = factory.openSession();
        try {
            session.beginTransaction();

            // Creating Employees

            Employee emp = new Employee();
            emp.setName("Garv");
            emp.setId(348L);
            emp.setPhone_One(999121292L);
            emp.setPhone_Two(7988834933L);

            // Creating Projects

            Project project1 = new Project();
            project1.setEmployee(emp);
            Project project2 = new Project();
            project2.setEmployee(emp);

            // Save the session here.
            session.persist(emp);

            session.getTransaction().commit(); // Commit the transaction.
            System.out.println("Employees Saved Successfully");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
