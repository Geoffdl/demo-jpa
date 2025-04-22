package fr.diginamic.geoff.heritage.joined;

import jakarta.persistence.*;

@Entity
public class Employe extends Personne
{

    private String poste;
    private float salaire;

    public Employe()
    {
    }

    public String getPoste()
    {
        return poste;
    }

    public void setPoste(String poste)
    {
        this.poste = poste;
    }

    public float getSalaire()
    {
        return salaire;
    }

    public void setSalaire(float salaire)
    {
        this.salaire = salaire;
    }
}