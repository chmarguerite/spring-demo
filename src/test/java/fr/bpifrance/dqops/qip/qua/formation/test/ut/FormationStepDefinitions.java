package fr.bpifrance.dqops.qip.qua.formation.test.ut;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Quand;
import fr.bpifrance.dqops.qip.qua.formation.dao.FormationDao;
import fr.bpifrance.dqops.qip.qua.formation.dao.IFormationDao;
import fr.bpifrance.dqops.qip.qua.formation.domaine.StagiaireService;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class FormationStepDefinitions {
    Stagiaire stagiaire;
    StagiaireService stagiaireService;
    IFormationDao formationDao;

    @Before
    public void setup(){
        formationDao = Mockito.mock(IFormationDao.class);
        stagiaireService = new StagiaireService(formationDao);

    }
    @Etantdonné("^j'ai un stagiaire nommé \"([^\"]*)\"$")
    public void j_ai_un_stagiaire_nommé(String nom) throws Exception {
        stagiaire = new Stagiaire();
        stagiaire.setNom(nom);
    }

    @Etantdonné("^ce stagiaire a le matricule \"([^\"]*)\"$")
    public void ce_stagiaire_a_le_matricule(String matricule) throws Exception {
        stagiaire.setMatricule(matricule);
    }

    @Quand("^ce stagiaire a obtenu les notes suivantes$")
    public void ce_stagiaire_a_obtenu_les_notes_suivantes(List<Note> notes) throws Exception {
        System.out.println(notes.toString());
        when(formationDao.obtenirNotesStagiaire(stagiaire.getMatricule())).thenReturn(notes);
    }
    double moyenneCalculé;
    @Quand("^je calcule la moyenne$")
    public void je_calcule_la_moyenne() throws Exception {
        moyenneCalculé=stagiaireService.calculerNoteMoyenne(stagiaire.getMatricule());
    }

    @Alors("^ce stagiaire a une note moyenne de (\\d+)$")
    public void ce_stagiaire_a_une_note_moyenne_de(int noteMoyenne) throws Exception {
        assertThat(moyenneCalculé).isEqualTo(noteMoyenne);
    }

}
