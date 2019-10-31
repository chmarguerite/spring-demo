package fr.bpifrance.dqops.qip.qua.formation.test.ut;

import fr.bpifrance.dqops.qip.qua.formation.dao.FormationDao;
import fr.bpifrance.dqops.qip.qua.formation.domaine.StagiaireService;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class StagiaireServiceTest {

    StagiaireService stagiaireService;

    private static FormationDao formationMockDB= Mockito.mock(FormationDao.class);

    public StagiaireServiceTest(){
        stagiaireService = new StagiaireService(formationMockDB);
    }


    @Test
    public void listeStagiaireNonVide(){
        List<Stagiaire> stagiaires= new ArrayList<Stagiaire>();
        stagiaires.add(new Stagiaire("m00001","Jane Doe"));
        stagiaires.add(new Stagiaire("m00002","John Doe"));
        when(formationMockDB.obtenirListeStagiaires()).thenReturn(stagiaires);

        assertThat(stagiaireService.listeStagiaires()).isEqualTo(stagiaires);
    }


    @Test
    public void calculMoyenneRien(){

        when(formationMockDB.obtenirNotesStagiaire("m0000")).thenReturn(null);
        assertThat(stagiaireService.calculerNoteMoyenne("m0000")).isEqualTo(null);
    }



    @Test
    public void calculMoyenneAvec3Notes(){
        List<Note> notes = new ArrayList<Note>();
        notes.add(new Note("m0000","Selenium", 10));
        notes.add(new Note("m0000","Java", 11));
        notes.add(new Note("m0000","Cucumber", 12));

        when(formationMockDB.obtenirNotesStagiaire("m0000")).thenReturn(notes);

        assertThat(stagiaireService.calculerNoteMoyenne("m0000")).isEqualTo(11);
    }

    @Test
    public void calculMoyenneAvec6Notes(){
        List<Note> notes = new ArrayList<Note>();
        notes.add(new Note("m0000","Selenium", 10));
        notes.add(new Note("m0000","Java", 14));
        notes.add(new Note("m0000","Selenium", 10));
        notes.add(new Note("m0000","Java", 14));
        notes.add(new Note("m0000","Selenium", 10));
        notes.add(new Note("m0000","Java", 14));

        when(formationMockDB.obtenirNotesStagiaire("m0000")).thenReturn(notes);

        assertThat(stagiaireService.calculerNoteMoyenne("m0000")).isEqualTo(12);
    }

}
