package fr.diginamic.geoff.heritage.superclass;

import jakarta.persistence.*;

@Entity
@Table(name = "ARTICLE")
public class Article extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITRE")
    private String titre;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}