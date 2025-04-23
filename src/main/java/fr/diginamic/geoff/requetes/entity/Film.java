package fr.diginamic.geoff.requetes.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Film
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idlmb;
    private String imdbHref;
    private String nom;
    private int annee;

    @OneToMany(mappedBy = "film")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "FILM_GENRE",
            joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "FILM_REAL",
            joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_REAL", referencedColumnName = "ID")
    )
    private Set<Realisateur> realisateurs = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "FILM_PAYS",
            joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PAYS", referencedColumnName = "ID")
    )
    private Set<Pays> pays = new HashSet<>();

    public Film()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getIdlmb()
    {
        return idlmb;
    }

    public void setIdlmb(String idlmb)
    {
        this.idlmb = idlmb;
    }

    public String getImdbHref()
    {
        return imdbHref;
    }

    public void setImdbHref(String imdbHref)
    {
        this.imdbHref = imdbHref;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getAnnee()
    {
        return annee;
    }

    public void setAnnee(int annee)
    {
        this.annee = annee;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public Set<Genre> getGenres()
    {
        return genres;
    }

    public void setGenres(Set<Genre> genres)
    {
        this.genres = genres;
    }

    public Set<Realisateur> getRealisateurs()
    {
        return realisateurs;
    }

    public void setRealisateurs(Set<Realisateur> realisateurs)
    {
        this.realisateurs = realisateurs;
    }

    public Set<Pays> getPays()
    {
        return pays;
    }

    public void setPays(Set<Pays> pays)
    {
        this.pays = pays;
    }
}