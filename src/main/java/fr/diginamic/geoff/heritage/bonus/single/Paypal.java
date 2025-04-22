package fr.diginamic.geoff.heritage.bonus.single;

import jakarta.persistence.Entity;

@Entity
public class Paypal extends MoyenPaiement
{
    private String email;


    public Paypal()
    {
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}