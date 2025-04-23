package fr.diginamic.geoff.requetes;

import fr.diginamic.geoff.requetes.entity.Genre;
import jakarta.persistence.*;

import java.time.Year;

public class TestRequetesExtra
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_requetes");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();


        try
        {
            // Le genre le plus représenté parmi tous les films

            Query query1 = em.createQuery("SELECT g.nom, COUNT(f) as filmCount FROM Genre g JOIN g.films f GROUP BY g.nom ORDER BY COUNT(f) DESC").setMaxResults(1);

            // La durée moyenne des films par genre

            Query query2 = em.createQuery("SELECT g.nom, AVG(f.annee) FROM Genre g JOIN g.films f GROUP BY g.nom, f.annee ORDER BY f.annee DESC");

            // Les acteurs ayant travaillé avec plus de 3 réalisateurs différents

            Query query3 = em.createQuery("SELECT r.acteur.identite AS acteur, COUNT(DISTINCT real) FROM Role r JOIN r.film f JOIN f.realisateurs real GROUP BY acteur HAVING COUNT(DISTINCT real) > 3 ");

            // Les réalisateurs ayant dirigé des films dans au moins 2 genres différents

            Query query4 = em.createQuery("SELECT r.identite, COUNT(DISTINCT g) FROM Realisateur r JOIN r.films f JOIN f.genres g GROUP BY r.identite HAVING COUNT(DISTINCT g) >= 2");
            // Les pays ayant produit le plus de films dans les 10 dernières années

            Query query5 = em.createQuery("SELECT p.nom, COUNT(DISTINCT f) FROM Pays p JOIN p.films f WHERE f.annee >= :year GROUP BY p.nom ORDER BY COUNT(DISTINCT f) DESC ");
            query5.setParameter("year", Year.now().getValue() - 10);

            // Les films dont le casting compte plus de 5 acteurs

            Query query6 = em.createQuery("SELECT r.film, COUNT(DISTINCT r.acteur) FROM Role r GROUP BY r.film HAVING COUNT(DISTINCT r.acteur) >5 ");

            // Les genres associés à des films d’un même réalisateur

            Query query7 = em.createQuery("SELECT r.identite, g.nom, count(DISTINCT f) FROM Realisateur r JOIN r.films f JOIN f.genres g GROUP BY r.identite, g.nom");


            // Le nombre de films par pays et par genre

            Query query8 = em.createQuery("SELECT p.nom, g.nom, COUNT(DISTINCT f) FROM Film f JOIN f.pays p JOIN f.genres g GROUP BY p.nom, g.nom");

            // Les acteurs qui n’ont jamais travaillé avec un certain réalisateur

            Query query9 = em.createQuery("SELECT DISTINCT a.identite FROM Acteur a WHERE NOT EXISTS (SELECT 1 FROM Role r JOIN r.film f JOIN f.realisateurs real WHERE r.acteur = a AND real.identite = :realisateur) ORDER BY a.identite");


        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            if (em != null)
            {
                em.close();
            }
            if ((emf != null))
            {
                emf.close();
            }
        }

    }
}