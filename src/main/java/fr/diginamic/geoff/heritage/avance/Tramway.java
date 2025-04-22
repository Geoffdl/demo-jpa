package fr.diginamic.geoff.heritage.avance;

import jakarta.persistence.Entity;

@Entity
public class Tramway extends Vehicule
{
    private int nbRames;

    public int getNbRames()
    {
        return nbRames;
    }

    public void setNbRames(int nbRames)
    {
        this.nbRames = nbRames;
    }
}