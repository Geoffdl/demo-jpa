package fr.diginamic.geoff.introjpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ConnexionJpa
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
        EntityManager em = emf.createEntityManager();

        List<Region> regions = new ArrayList<>();
        regions.add(new Region("Aquitaine"));
        regions.add(new Region("Limousin"));

        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();
            em.persist(regions.get(0));
            em.persist(regions.get(1));
            transaction.commit();


            Region region = em.find(Region.class, 2L);
            if (region != null)
            {
                transaction.begin();
                region.setName("Bretagne");
                transaction.commit();
            }

            transaction.begin();
            em.createQuery("DELETE FROM Region").executeUpdate();
            transaction.commit();

            List<Region> frenchRegions = List.of(
                    new Region("Auvergne-Rhone-Alpes"),
                    new Region("Bourgogne-Franche-Comté"),
                    new Region("Bretagne"),
                    new Region("Centre-Val de Loire"),
                    new Region("Corse"),
                    new Region("Grand Est"),
                    new Region("Hauts-de-France"),
                    new Region("Ile-de-France"),
                    new Region("Normandie"),
                    new Region("Nouvelle-Aquitaine"),
                    new Region("Occitanie"),
                    new Region("Pays de la Loire"),
                    new Region("Provence Alpes Cote d'Azur")
            );

            transaction.begin();
            for (Region r : frenchRegions)
            {
                em.persist(r);
            }

            transaction.commit();

            TypedQuery<Region> query = em.createQuery("SELECT r FROM Region r",Region.class);
            List<Region> allRegions = query.getResultList();

            for (Region r : allRegions)
            {
                System.out.println(r.getName());
            }


        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            if (em != null)
            {
                em.close();
            }
            if (emf != null)
            {
                emf.close();
            }
        }
    }
}