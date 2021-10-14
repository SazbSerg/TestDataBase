package Hibernate.Main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class HibernateUtil {

    // private static SessionFactory sessionFactory;
//
// public static SessionFactory getSessionFactory() {
//     if (sessionFactory == null) {
//         try {
//             Configuration configuration = new Configura tion();
//             Properties settings = new Properties();
//             settings.put(Environment.DRIVER, "org.hsqldb.jdbcDriver");
//             settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb");
//             settings.put(Environment.USER, "root");
//             settings.put(Environment.PASS, "7777777");
//             settings.put(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
//             settings.put(Environment.SHOW_SQL, "true");
//             settings.put(Environment.HBM2DDL_AUTO, "update");
//             configuration.setProperties(settings);
//
//          //   configuration.addAnnotatedClass(User.class);
//           //  configuration.addAnnotatedClass(Role.class);
//
//             ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                     .applySettings(configuration.getProperties()).build();
//             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
//     return sessionFactory;
// }
//
    static final Logger logger = LoggerFactory.getLogger("HibernateUtil");

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            logger.error("Создание SessionFactory не удалось" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
