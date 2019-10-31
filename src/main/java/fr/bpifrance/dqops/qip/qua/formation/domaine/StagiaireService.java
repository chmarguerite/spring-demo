package fr.bpifrance.dqops.qip.qua.formation.domaine;

import fr.bpifrance.dqops.qip.qua.formation.dao.IFormationDao;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StagiaireService implements IStagiaireService {
    private Logger logger = LoggerFactory.getLogger(StagiaireService.class);
    @Autowired
    public IFormationDao formationDao;

    public StagiaireService(IFormationDao formationDao){
        this.formationDao = formationDao;
    }

    public List<Stagiaire> listeStagiaires(){
        return  formationDao.obtenirListeStagiaires();
    }

    public Stagiaire consulterStagiaire(String matricule) {
        return formationDao.trouverStagiaire(matricule);
    }

    public void ajouterNote(String matricule, String cours, Integer note) {
        Note n = new Note(matricule, cours, note);
        formationDao.ajouterNote(n);
    }

    public Double calculerNoteMoyenne(String matricule) {
        List<Note> notes = formationDao.obtenirNotesStagiaire(matricule);
        if(notes != null) {
            return notes.stream().mapToDouble(Note::getNote)
                    .average().getAsDouble();
        }else{
            return null;
        }

    }

}





/****
 return notes.stream().mapToDouble(Note::getNote)
 .average().getAsDouble();****/