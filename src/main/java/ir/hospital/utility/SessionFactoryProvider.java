package ir.hospital.utility;

import ir.hospital.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {


    public static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Secretary.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(Clinic.class)
                .addAnnotatedClass(Prescription.class)
                .addAnnotatedClass(Queuing.class)
                .buildMetadata()
                .buildSessionFactory();
    }
}
