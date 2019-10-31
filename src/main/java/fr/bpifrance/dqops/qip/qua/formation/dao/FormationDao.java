package fr.bpifrance.dqops.qip.qua.formation.dao;

import fr.bpifrance.dqops.qip.qua.formation.dao.repositories.NoteRepository;
import fr.bpifrance.dqops.qip.qua.formation.dao.repositories.StagiaireRepository;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("FormationRepository")
public class FormationDao implements IFormationDao{

    public FormationDao(){

    }
    @Autowired
    public NoteRepository noteRepository;
    @Autowired
    public StagiaireRepository stagiaireRepository;

    public List<Stagiaire> obtenirListeStagiaires() {
        return stagiaireRepository.findAll();
    }

    public Stagiaire trouverStagiaire(String matricule) {
        return stagiaireRepository.trouverStagiaire(matricule);
    }

    public List<Note> obtenirNotesStagiaire(String matricule) {
        return noteRepository.obtenirNotesStagiaire(matricule);
    }

    public Note ajouterNote(Note note) {
        if(note!= null){
            return noteRepository.save(note);
        }else{
            return null;
        }
    }
}
