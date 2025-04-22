package fr.diginamic.geoff.heritage.avance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestTrajet
{
    public static void main(String[] args)
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_heritage");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try
        {
            transaction.begin();

            Bus bus = new Bus();
            bus.setImmatriculation("AB-123-CD");
            bus.setCapacite(5);
            em.persist(bus);

            Trajet trajet = new Trajet();
            trajet.setDepart("Paris");
            trajet.setArrivee("Lyon");
            trajet.setVehicule(bus);
            em.persist(trajet);

            bus.getTrajets().add(trajet);

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