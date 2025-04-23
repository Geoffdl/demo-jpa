package fr.diginamic.geoff.requetes.entity;


import jakarta.persistence.*;

@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "ID_ACTEUR")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "ID_FILM")
    private Film film;

    public Role()
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

    public Acteur getActeur()
    {
        return acteur;
    }

    public void setActeur(Acteur acteur)
    {
        this.acteur = acteur;
    }

    public Film getFilm()
    {
        return film;
    }

    public void setFilm(Film film)
    {
        this.film = film;
    }
}