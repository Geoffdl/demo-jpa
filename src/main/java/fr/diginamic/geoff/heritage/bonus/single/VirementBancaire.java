package fr.diginamic.geoff.heritage.bonus.single;

import jakarta.persistence.Entity;

@Entity
public class VirementBancaire extends MoyenPaiement
{
    private String IBAN;
    private String banque;


    public VirementBancaire()
    {
    }

    public String getIBAN()
    {
        return IBAN;
    }

    public void setIBAN(String IBAN)
    {
        this.IBAN = IBAN;
    }

    public String getBanque()
    {
        return banque;
    }

    public void setBanque(String banque)
    {
        this.banque = banque;
    }
}