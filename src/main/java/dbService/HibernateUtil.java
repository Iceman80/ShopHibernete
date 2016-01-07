package dbService;


import dbService.dataSets.Items;
import dbService.dataSets.Users;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory =
            createSessionFactory(getMyConfiguration());

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMyConfiguration() {
        Configuration configuration = new Configuration().configure("hibernatePg.cfg.xml");
        configuration.addAnnotatedClass(Items.class);
        configuration.addAnnotatedClass(Users.class);
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}