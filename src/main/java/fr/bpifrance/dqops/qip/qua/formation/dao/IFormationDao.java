package fr.bpifrance.dqops.qip.qua.formation.dao;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;

import java.util.List;

public interface IFormationDao {
    public List<Stagiaire> obtenirListeStagiaires();
    public Stagiaire trouverStagiaire(String matricule);
    public List<Note> obtenirNotesStagiaire(String matricule);
    public Note ajouterNote(Note note);
}
