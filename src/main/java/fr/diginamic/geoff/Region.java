package fr.diginamic.geoff;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String name;

    public Region()
    {
    }

    public Region(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}