package fr.diginamic.geoff.bibliotheque;

import fr.diginamic.geoff.shopping.Produit;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre extends Produit
{

    @Column(name = "TITRE", length = 255)
    private String titre;

    @Column(name = "AUTEUR",length = 50)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunts = new ArrayList<>();

    public Livre()
    {
    }

    public Livre(String auteur, String titre)
    {
        this.auteur = auteur;
        this.titre = titre;
    }

    public String getTitre()
    {
        return titre;
    }

    public void setTitre(String titre)
    {
        this.titre = titre;
    }

    public String getAuteur()
    {
        return auteur;
    }

    public void setAuteur(String auteur)
    {
        this.auteur = auteur;
    }
}