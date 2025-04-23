package fr.diginamic.geoff.requetes;


import fr.diginamic.geoff.requetes.entity.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;


public class TestRequetes
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_requetes");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try
        {
            //Tous les films dans lesquels un acteur donné a joué
            System.out.println("Tous les films dans lesquels un acteur donné a joué");
            TypedQuery<Film> query = em.createQuery(
                    "SELECT DISTINCT r.film FROM Role r " +
                            "WHERE r.acteur.identite = :identite", Film.class);
            query.setParameter("identite", "James Bond");
            List<Film> films = query.getResultList();


            //Tous les acteurs ayant joué dans un film d’un genre donné

            System.out.println("Tous les acteurs ayant joué dans un film d’un genre donné");

            TypedQuery<Acteur> query2 = em.createQuery("SELECT DISTINCT a FROM Acteur a " +
                    "JOIN a.roles r " +
                    "JOIN r.film f " +
                    "JOIN f.genres g " +
                    "WHERE g.nom = :genre", Acteur.class);

            TypedQuery<Acteur> query2alt = em.createQuery("SELECT DISTINCT r.acteur FROM Role r JOIN r.film f JOIN f.genres g WHERE g.nom = :genre ", Acteur.class);
            query2.setParameter("genre", "Action");

            List<Acteur> acteursByGenre = query2.getResultList();

            //Tous les films réalisés par un réalisateur d’un pays donné
            System.out.println("Tous les films réalisés par un réalisateur d’un pays donné");

            TypedQuery<Film> query3 = em.createQuery("SELECT DISTINCT  f FROM Film f JOIN f.realisateurs r JOIN f.pays p WHERE r.identite = :identite AND p.nom = :pays", Film.class);
            query3.setParameter("identite", "Tarantino");
            query3.setParameter("pays", "USA");
            List<Film> filmsByRealAndCountry = query3.getResultList();


            //Tous les genres associés à des films où un acteur donné a joué
            System.out.println("Tous les genres associés à des films où un acteur donné a joué");

            TypedQuery<Genre> query4 = em.createQuery("SELECT DISTINCT g FROM Genre g JOIN g.films f JOIN f.roles r JOIN r.acteur a WHERE a.identite = :acteur", Genre.class);
            TypedQuery<Genre> query4alt = em.createQuery("SELECT DISTINCT g FROM Role r JOIN r.film f JOIN f.genres g WHERE r.acteur.identite = :acteur", Genre.class);
            query4.setParameter("acteur", "James Bond");
            List<Genre> genreWhereActor = query4.getResultList();

            //Tous les pays dans lesquels ont été diffusés les films d’un genre donné
            System.out.println("Tous les pays dans lesquels ont été diffusés les films d’un genre donné");

            TypedQuery<Pays> query5 = em.createQuery("SELECT DISTINCT p FROM Pays p JOIN p.films f JOIN f.genres g WHERE g.nom = :genre", Pays.class);
            query5.setParameter("genre", "Comedie");
            List<Pays> PaysMoviesWhereGenreIs = query5.getResultList();

            //Nombre de films par genre
            System.out.println("Nombre de films par genre");

            TypedQuery<Long> query6 = em.createQuery(
                    "SELECT COUNT(f) " +
                            "FROM Film f " +
                            "JOIN f.genres g " +
                            "WHERE g.nom = :genre", Long.class);
            query6.setParameter("genre", "Action");
            Long countForGenre = query6.getSingleResult();

            TypedQuery<Integer[]> query6alt = em.createQuery("SELECT g.nom, COUNT(f) FROM Genre g JOIN g.films f GROUP BY g.nom", Integer[].class);

            //Tous les réalisateurs ayant travaillé avec un acteur donné
            System.out.println("Tous les réalisateurs ayant travaillé avec un acteur donné");
            TypedQuery<Realisateur> query7 = em.createQuery("SELECT DISTINCT r FROM Realisateur r JOIN r.films f JOIN f.roles rl JOIN rl.acteur a WHERE a.identite = :acteur", Realisateur.class);

            //Tous les films tournés dans un pays donné et appartenant à un genre donné
            System.out.println("Tous les films tournés dans un pays donné et appartenant à un genre donné");

            TypedQuery<Film> query8 = em.createQuery("SELECT DISTINCT f FROM Film f JOIN f.pays p JOIN f.genres g WHERE p.nom = :pays AND g.nom =:genre", Film.class);
            query8.setParameter("pays", "Italie");
            query8.setParameter("genre", "Thriller");
            List<Film> MoviesByCountryAndGenre = query8.getResultList();

            //Le nombre total de rôles joués par chaque acteur
            System.out.println("Le nombre total de rôles joués par chaque acteur");
            TypedQuery<Object[]> query9 = em.createQuery("SELECT a.identite, COUNT(r) FROM Acteur a JOIN a.roles r GROUP BY a.identite", Object[].class);

            //La liste des acteurs ayant joué dans plus de 5 films
            System.out.println("La liste des acteurs ayant joué dans plus de 5 films");
            TypedQuery<Acteur> query10 = em.createQuery("SELECT a.identite FROM Acteur a JOIN a.roles r JOIN r.film f GROUP BY a.identite HAVING COUNT(DISTINCT f) > 5", Acteur.class);
            TypedQuery<Acteur> query10Alt = em.createQuery(
                    "SELECT DISTINCT a FROM Acteur a " +
                            "WHERE (SELECT COUNT(DISTINCT f) FROM Role r " +
                            "JOIN r.film f WHERE r.acteur = a) > 5", Acteur.class);
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