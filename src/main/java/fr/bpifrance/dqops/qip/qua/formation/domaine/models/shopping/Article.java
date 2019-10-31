package fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Article implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    private static final long serialVersionUID = 1L;

    private String nom;
    private Double prixUnitaire;
}
