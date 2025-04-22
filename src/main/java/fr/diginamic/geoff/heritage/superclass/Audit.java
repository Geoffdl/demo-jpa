package fr.diginamic.geoff.heritage.superclass;

import jakarta.persistence.*;

import java.util.Date;


@MappedSuperclass
public abstract class Audit
{
    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    private Date dateModification;

    @Column(name = "CREE_PAR")
    private String creePar;

    public Date getDateCreation()
    {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation)
    {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification()
    {
        return dateModification;
    }

    public void setDateModification(Date dateModification)
    {
        this.dateModification = dateModification;
    }

    public String getCreePar()
    {
        return creePar;
    }

    public void setCreePar(String creePar)
    {
        this.creePar = creePar;
    }
}