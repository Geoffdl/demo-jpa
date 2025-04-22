package fr.diginamic.geoff.shopping;


import fr.diginamic.geoff.bibliotheque.Client;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "COMMANDE")
public class Commande
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    private Client client;

    @OneToOne
    @JoinColumn(name = "ID_PANIER", referencedColumnName = "ID")
    private Panier panier;

    @OneToMany(mappedBy = "commande")
    private Set<Livraison> livraisons;

    @Column(name = "DATE_COMMANDE")
    private LocalDateTime dateCommande;

    public Commande()
    {
    }

    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Panier getPanier()
    {
        return panier;
    }

    public void setPanier(Panier panier)
    {
        this.panier = panier;
    }

    public LocalDateTime getDateCommande()
    {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande)
    {
        this.dateCommande = dateCommande;
    }
}