package fr.diginamic.geoff.bibliotheque;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private List<Emprunt> emprunts = new ArrayList<>();

    public Client()
    {
    }

    public Client(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public List<Emprunt> getEmprunts()
    {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts)
    {
        this.emprunts = emprunts;
    }

    public Long getId()
    {
        return id;
    }


}