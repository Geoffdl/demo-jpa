package fr.diginamic.geoff.clefcomposite;

import jakarta.persistence.Embeddable;


@Embeddable
public class EmployeProjetId
{

    private Long idEmploye;
    private Long idProjet;
}