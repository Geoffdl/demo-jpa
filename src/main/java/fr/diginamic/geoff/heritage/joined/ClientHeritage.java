package fr.diginamic.geoff.heritage.joined;

import jakarta.persistence.Entity;

@Entity
public class ClientHeritage extends Personne
{
    private String email;

    public ClientHeritage()
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