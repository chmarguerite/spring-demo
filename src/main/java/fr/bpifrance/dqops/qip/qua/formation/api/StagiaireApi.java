package fr.bpifrance.dqops.qip.qua.formation.api;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import fr.bpifrance.dqops.qip.qua.formation.domaine.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StagiaireApi {

    @Autowired
    private StagiaireService stagiaireService;

    @RequestMapping(path = "/stagiaires")
    public List<Stagiaire> obtenirListeStagiaires(){
        return this.stagiaireService.listeStagiaires();
    }

    @RequestMapping(path = "/stagiaires/{matricule}")
    public Stagiaire obtenirStagiaire(@PathVariable String matricule){
        return this.stagiaireService.consulterStagiaire(matricule);
    }

    @RequestMapping(path = "/stagiaires/{matricule}/moyenne")
    public NoteMoyenneJson obtenirStagiaireMoyenne(@PathVariable String matricule){
        double noteCalculé= this.stagiaireService.calculerNoteMoyenne(matricule);
        NoteMoyenneJson noteJson =  new NoteMoyenneJson();
        noteJson.setMatricule(matricule);
        noteJson.setMoyenne(noteCalculé);
        return noteJson ;
    }



    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public ResponseEntity<?> ajouterNotes(@RequestBody Note note,
                                  UriComponentsBuilder ucBuilder){
        this.stagiaireService.ajouterNote(note.getMatricule(),note.getCours(),note.getNote());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
