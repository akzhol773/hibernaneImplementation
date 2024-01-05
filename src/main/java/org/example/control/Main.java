package org.example.control;
import org.example.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


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



            Query query = session.createQuery("from Player where playerId = : Id");
            query.setString("Id", "1");
            List<Player> playerList = query.list();
            for(Player p: playerList){
                System.out.println(p);
            }

            transaction.commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}