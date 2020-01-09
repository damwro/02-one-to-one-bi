package sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sdacademy.demo.entity.Driver;
import sdacademy.demo.entity.DriverDetail;

public class GetInstructorDetailDemo {

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
            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();

            Long id = 2L;
            DriverDetail driverDetail = session.get(DriverDetail.class, id);

            System.out.println(driverDetail);

            System.out.println("---------Kierowca pobrany ze szczegółów-----------");
            System.out.println(driverDetail.getDriver());

            //zakomituj transakcję
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            session.close();
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }

}
