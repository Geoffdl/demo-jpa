package fr.diginamic.geoff.heritage.joined;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestHeritage
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_heritage");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();


        try
        {
            transaction.begin();
            Employe a = new Employe();
            a.setNom("Dlrm");
            a.setPrenom("Geoff");
            a.setPoste("Boss");
            a.setSalaire(1000000);


            ClientHeritage b = new ClientHeritage();
            b.setNom("Bob");
            b.setPrenom("Dylan");
            b.setEmail("bob@dylan.se");

            em.persist(a);
            em.persist(b);
            transaction.commit();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            if (em != null)
            {
                em.close();
            }
            if (em != null)
            {
                emf.close();
            }
        }
    }


}