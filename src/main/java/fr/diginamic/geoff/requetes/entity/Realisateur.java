package fr.diginamic.geoff.requetes.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Realisateur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idlmdb;
    private String identite;
    private String href;
    private LocalDate anniversaire;

    @ManyToMany(mappedBy = "realisateurs")
    private Set<Film> films;

    public Realisateur()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getIdlmdb()
    {
        return idlmdb;
    }

    public void setIdlmdb(String idlmdb)
    {
        this.idlmdb = idlmdb;
    }

    public String getIdentite()
    {
        return identite;
    }

    public void setIdentite(String identite)
    {
        this.identite = identite;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public LocalDate getAnniversaire()
    {
        return anniversaire;
    }

    public void setAnniversaire(LocalDate anniversaire)
    {
        this.anniversaire = anniversaire;
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