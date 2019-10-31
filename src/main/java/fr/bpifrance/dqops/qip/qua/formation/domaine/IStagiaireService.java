package fr.bpifrance.dqops.qip.qua.formation.domaine;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;

import java.util.List;

public interface IStagiaireService {

    public List<Stagiaire> listeStagiaires();
    public Stagiaire consulterStagiaire(String matricule);
    public void ajouterNote(String matricule, String cours,Integer note);
    public Double calculerNoteMoyenne(String matricule);
   // public boolean consulterResultatExamen(String matricule);


}
