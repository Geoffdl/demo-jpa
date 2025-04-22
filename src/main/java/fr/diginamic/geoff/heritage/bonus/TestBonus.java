package fr.diginamic.geoff.heritage.bonus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestBonus
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_heritage");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
    }
}