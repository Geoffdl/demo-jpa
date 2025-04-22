package fr.diginamic.geoff.heritage.superclass;

import jakarta.persistence.*;

@Entity
@Table(name = "COMMENTAIRE")
public class Commentaire extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENU")
    private String contenu;

    public Long getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}