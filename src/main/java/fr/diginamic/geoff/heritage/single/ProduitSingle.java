package fr.diginamic.geoff.heritage.single;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Produit")
public class ProduitSingle
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String nom;
    private float prix;

    public ProduitSingle()
    {
    }

    public Long getID()
    {
        return ID;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public float getPrix()
    {
        return prix;
    }

    public void setPrix(float prix)
    {
        this.prix = prix;
    }
}