package sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Driver;
import pl.sdacademy.demo.entity.DriverDetail;

public class CreateDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klas
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(DriverDetail.class)
                .addAnnotatedClass(Driver.class)
                .buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {

            //stwórz obiekty i powiąż je ze sobą
            Driver driver = new Driver("Mariusz", "Nowak");

            DriverDetail driverDetail = new DriverDetail("A", "456789132");

            driver.setDriverDetail(driverDetail);

            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();

            //zapiszą się oba obiekty bo mamy wiązanie Cascade.ALL
            session.save(driver);


            //zakomituj transakcję
            session.getTransaction().commit();

        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }

}
