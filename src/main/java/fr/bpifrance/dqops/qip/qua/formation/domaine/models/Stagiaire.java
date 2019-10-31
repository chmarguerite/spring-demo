package fr.bpifrance.dqops.qip.qua.formation.domaine.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Stagiaire  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    private static final long serialVersionUID = 1L;

    private String matricule;
    private String nom;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Note> notes;

    public Stagiaire(){}

    public Stagiaire(String matricule, String nom){
        this.matricule = matricule;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Stagiaire [matricule=" + matricule + ", nom=" + nom + "]";
    }
}
