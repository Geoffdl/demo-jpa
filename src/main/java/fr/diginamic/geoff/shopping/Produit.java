package fr.diginamic.geoff.shopping;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PRODUIT")
public abstract class Produit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToMany(mappedBy = "produits")
    private List<Panier> paniers = new ArrayList<>();

    @Column(name = "PRIX")
    private float prix;
}