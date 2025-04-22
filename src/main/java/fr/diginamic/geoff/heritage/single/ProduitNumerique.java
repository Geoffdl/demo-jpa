package fr.diginamic.geoff.heritage.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NUM")
public class ProduitNumerique extends ProduitSingle
{

    private float taillefichier;

    public float getTaillefichier()
    {
        return taillefichier;
    }

    public void setTaillefichier(float taillefichier)
    {
        this.taillefichier = taillefichier;
    }
}