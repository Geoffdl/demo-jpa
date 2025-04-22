package fr.diginamic.geoff.bibliotheque;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE_DEBUT")
    private Date dateDebut;

    @Column(name = "DELAI", length = 10)
    private int delais;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;


    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private List<Livre> livres = new ArrayList<>();

    public Emprunt()
    {
    }

    public Emprunt(Date dateDebut, int delais, Date dateFin, Client client, List<Livre> livres)
    {
        this.dateDebut = dateDebut;
        this.delais = delais;
        this.dateFin = dateFin;
        this.client = client;
        this.livres = livres;
    }

    public Long getId()
    {
        return id;
    }



    public Date getDateDebut()
    {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public int getDelais()
    {
        return delais;
    }

    public void setDelais(int delais)
    {
        this.delais = delais;
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public List<Livre> getLivres()
    {
        return livres;
    }

    public void setLivres(List<Livre> livres)
    {
        this.livres = livres;
    }
}