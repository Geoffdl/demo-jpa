package fr.diginamic.geoff.heritage.single;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestSingle
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_heritage");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();
            ProduitPhysique a = new ProduitPhysique();
            a.setNom("Table");
            a.setPrix(2000);
            a.setPoids(20);

            ProduitNumerique b = new ProduitNumerique();
            b.setNom("hit 2000");
            b.setPrix(10);
            b.setTaillefichier(1500);

            em.persist(a);
            em.persist(b);
            transaction.commit();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            em.close();
            emf.close();
        }
    }
}