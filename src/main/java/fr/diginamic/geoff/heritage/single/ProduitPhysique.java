package fr.diginamic.geoff.heritage.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PHYS")
public class ProduitPhysique extends ProduitSingle
{
    private float poids;

    public float getPoids()
    {
        return poids;
    }

    public void setPoids(float poids)
    {
        this.poids = poids;
    }
}