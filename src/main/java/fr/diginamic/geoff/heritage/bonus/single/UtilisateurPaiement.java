package fr.diginamic.geoff.heritage.bonus.single;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class UtilisateurPaiement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy = "utilisateurPaiement")

    private Set<MoyenPaiement> moyenPaiements = new HashSet<>();


}