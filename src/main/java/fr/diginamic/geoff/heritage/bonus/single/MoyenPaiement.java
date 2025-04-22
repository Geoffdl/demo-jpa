package fr.diginamic.geoff.heritage.bonus.single;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Paiement")
public abstract class MoyenPaiement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private UtilisateurPaiement utilisateurPaiement;

    public MoyenPaiement()
    {
    }

    public Long getID()
    {
        return ID;
    }


}