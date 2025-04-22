package fr.diginamic.geoff.shopping;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "LIVRAISON")
public class Livraison
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "DATE_LIV")
    private Date dateLivraison;

    @ManyToOne
    @JoinColumn(name = "ID_COMMANDE", referencedColumnName = "ID")
    private List<Commande> commandes;

}