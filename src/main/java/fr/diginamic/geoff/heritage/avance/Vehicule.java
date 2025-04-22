package fr.diginamic.geoff.heritage.avance;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String immatriculation;

    @OneToMany(mappedBy = "vehicule")
    private List<Trajet> trajets = new ArrayList<>();

    public Vehicule()
    {
    }

    public String getImmatriculation()
    {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation)
    {
        this.immatriculation = immatriculation;
    }

    public Long getID()
    {
        return ID;
    }

    public List<Trajet> getTrajets()
    {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets)
    {
        this.trajets = trajets;
    }
}