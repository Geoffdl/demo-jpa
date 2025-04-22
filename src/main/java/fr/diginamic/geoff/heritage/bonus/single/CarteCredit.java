package fr.diginamic.geoff.heritage.bonus.single;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class CarteCredit extends MoyenPaiement
{
    private int numero;
    private Date dateexpiration;

    public CarteCredit()
    {
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public Date getDateexpiration()
    {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration)
    {
        this.dateexpiration = dateexpiration;
    }
}