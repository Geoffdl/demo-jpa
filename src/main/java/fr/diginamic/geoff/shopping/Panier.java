package fr.diginamic.geoff.shopping;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PANIER")
public class Panier
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToMany
    @JoinTable(name = "PANIER_PRODUIT",
            joinColumns = @JoinColumn(name = "ID_PANIER", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"))
    private List<Produit> produits = new ArrayList<>();

    @OneToOne(mappedBy = "panier")
    private Commande commande;

    public Panier()
    {
    }
}