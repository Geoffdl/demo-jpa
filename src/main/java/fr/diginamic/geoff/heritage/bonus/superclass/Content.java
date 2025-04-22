package fr.diginamic.geoff.heritage.bonus.superclass;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class Content
{
    private String author;
    private Date dateCreation;
    private Date dateModification;

}