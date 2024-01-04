package org.example.control;
import org.example.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(org.example.entity.Player.class);

            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            SessionFactory factory = configuration.buildSessionFactory(builder.build());
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

//            Player p1 = new Player(4, "Akzhol", "Osh", 26);
//            Player p2 = new Player(5, "Bek", "Bishkek", 25);
//            Player p3 = new Player(6, "Ali", "Jalal-Abad", 26);
//
//            session.save(p1);
//            session.save(p2);
//            session.save(p3);

            Player p = session.get(Player.class, 1);
           session.delete(p);

            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}