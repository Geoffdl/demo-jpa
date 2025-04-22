package fr.diginamic.geoff.dao;

import fr.diginamic.geoff.bibliotheque.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class ClientDao
{
    private EntityManager em;

    public ClientDao(){
        this.em = JpaConnection.getEntityManager();
    }

    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public Client findById(Long id){
        return em.find(Client.class, id);
    }

    public List<Client> findAll(){
        try {
            return em.createQuery("SELECT c FROM ClientHeritage c", Client.class).getResultList();
        } catch (Exception e){
            throw new RuntimeException("Error finding all clients", e);
        }
    }

    public void save(Client client) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error saving client", e);
        }
    }

    public void update(Client client) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error updating client", e);
        }
    }

    public void delete(Client client) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(client) ? client : em.merge(client));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error deleting client", e);
        }
    }

    public List<Client> findByNomAndPrenom(String nom, String prenom) {
        try {
            Client client = em.createQuery(
                            "SELECT c FROM ClientHeritage c WHERE c.nom = :nom AND c.prenom = :prenom",
                            Client.class)
                    .setParameter("nom", nom)
                    .setParameter("prenom", prenom)
                    .getSingleResult();
            return List.of(client);
        } catch (NoResultException e) {
            return null;
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

}