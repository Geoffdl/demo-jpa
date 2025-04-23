package fr.diginamic.geoff.requetes.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Pays
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "pays")
    private Set<Film> films;

    public Pays()
    {
    }

    public Long getId()
    {
        return id;
    }


    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public Set<Film> getFilms()
    {
        return films;
    }

    public void setFilms(Set<Film> films)
    {
        this.films = films;
    }
}