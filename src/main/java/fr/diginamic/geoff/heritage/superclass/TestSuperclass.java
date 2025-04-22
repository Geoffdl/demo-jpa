package fr.diginamic.geoff.heritage.superclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSuperclass
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_heritage");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date specificDate = sdf.parse("2023-02-12 10:30:00");

            transaction.begin();
            Article a = new Article();
            a.setTitre("article");
            a.setCreePar("Geoff");
            a.setDateCreation(specificDate);
            a.setDateModification(specificDate);

            em.persist(a);
            Commentaire b = new Commentaire();
            b.setContenu("This is a comment");
            b.setCreePar("Geoff");
            b.setDateCreation(specificDate);
            b.setDateModification(specificDate);
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