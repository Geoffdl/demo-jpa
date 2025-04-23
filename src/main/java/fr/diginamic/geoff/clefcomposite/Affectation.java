package fr.diginamic.geoff.clefcomposite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Affectation
{
    @EmbeddedId
    private EmployeProjetId id;

    private LocalDate dateDebut;
}