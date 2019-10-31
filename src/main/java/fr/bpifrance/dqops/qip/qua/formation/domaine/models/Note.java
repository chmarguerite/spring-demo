package fr.bpifrance.dqops.qip.qua.formation.domaine.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Note  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    private static final long serialVersionUID = 1L;

    private String matricule;
    private String cours;
    private Integer note;

    public Note(){}

    public Note(String matricule, String cours, Integer note){
        this.matricule = matricule;
        this.cours = cours;
        this.note = note;
    }

}
