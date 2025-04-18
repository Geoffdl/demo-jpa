package fr.diginamic.geoff.bibliotheque;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;


public class TestJpa
{


    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_asso");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        System.out.println(em.find(Livre.class, 1));

        Client client = new Client("Dlrm", "Geoff");
        em.persist(client);

        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(new Date());
        emprunt.setDelais(14);
        emprunt.setClient(client);
        em.persist(emprunt);

        Livre livre1 = new Livre();
        livre1.setTitre("Le Petit Prince");
        livre1.setAuteur("Antoine de Saint-Exupéry");
        em.persist(livre1);

        Livre livre2 = new Livre();
        livre2.setTitre("1984");
        livre2.setAuteur("George Orwell");
        em.persist(livre2);

        emprunt.getLivres().add(livre1);
        emprunt.getLivres().add(livre2);

        transaction.commit();





    }
}