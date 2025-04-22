package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.bibliotheque.Client;
import fr.diginamic.geoff.bibliotheque.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class EmpruntDao
{
    private EntityManager em;

    public EmpruntDao() {
        this.em = JpaConnection.getEntityManager();
    }

    public EmpruntDao(EntityManager em) {
        this.em = em;
    }

    public Emprunt findById(Long id) {
        return em.find(Emprunt.class, id);
    }

    public List<Emprunt> findAll() {
        try {
            return em.createQuery("SELECT e FROM Emprunt e", Emprunt.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all emprunts", e);
        }
    }

    public void save(Emprunt emprunt) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(emprunt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error saving emprunt", e);
        }
    }

    public List<Emprunt> findByClient(Client client) {
        try {
            return em.createQuery(
                            "SELECT e FROM Emprunt e WHERE e.client = :client",
                            Emprunt.class)
                    .setParameter("client", client)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding emprunts by client", e);
        }
    }

    public List<Emprunt> findActiveEmprunts() {
        try {
            return em.createQuery(
                            "SELECT e FROM Emprunt e WHERE e.dateFin > CURRENT_TIMESTAMP",
                            Emprunt.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding active emprunts", e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}