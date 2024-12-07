package com.klef.jfsd.exam.HibernateInheritanceExample;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate and Build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open a new session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create Vehicle
        Vehicle vehicle = new Vehicle() {};
        vehicle.setName("General Vehicle");
        vehicle.setType("Generic");
        vehicle.setMaxSpeed(90);
        vehicle.setColor("Gray");
        session.save(vehicle);

        // Create Car
        Car car = new Car();
        car.setName("Honda Civic");
        car.setType("Car");
        car.setMaxSpeed(200);
        car.setColor("Red");
        car.setNumberOfDoors(4);
        session.save(car);

        // Create Truck
        Truck truck = new Truck();
        truck.setName("TATA Truck");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(7000);
        session.save(truck);

        // Commit Transaction
        transaction.commit();

        // Close session
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully.");
    }
}
