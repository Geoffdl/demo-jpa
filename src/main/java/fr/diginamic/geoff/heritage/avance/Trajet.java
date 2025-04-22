package fr.diginamic.geoff.heritage.avance;

import jakarta.persistence.*;

@Entity
public class Trajet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String depart;
    private String arrivee;

    @ManyToOne
    @JoinColumn(name = "VEHICULE_ID")
    private Vehicule vehicule;

    public Trajet()
    {
    }

    public Long getID()
    {
        return ID;
    }

    public String getDepart()
    {
        return depart;
    }

    public void setDepart(String depart)
    {
        this.depart = depart;
    }

    public String getArrivee()
    {
        return arrivee;
    }

    public void setArrivee(String arrivee)
    {
        this.arrivee = arrivee;
    }

    public Vehicule getVehicule()
    {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule)
    {
        this.vehicule = vehicule;
    }
}