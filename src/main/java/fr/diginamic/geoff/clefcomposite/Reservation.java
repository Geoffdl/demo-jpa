package fr.diginamic.geoff.clefcomposite;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reservation
{
    @EmbeddedId
    private ReservationId id;

    private int nbPlaces;
}

@Embeddable
class ReservationId
{
    private Long idClient;
    private Long idEvenement;

}