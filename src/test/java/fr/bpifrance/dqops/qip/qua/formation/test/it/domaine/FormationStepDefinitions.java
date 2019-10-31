package fr.bpifrance.dqops.qip.qua.formation.test.it.domaine;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = DaoTestConfig.class)
@DataJpaTest
public class FormationStepDefinitions {
    Stagiaire stagiaire;
    StagiaireService stagiaireService;
    @Autowired
    FormationDao formationDao;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    DataSource ds;

    @Before
    public void setup() throws SQLException {
        stagiaireService = new StagiaireService(formationDao);
        ScriptUtils.executeSqlScript(ds.getConnection(), new ClassPathResource("/data/close.sql"));
    }

    @Etantdonné("^j'ai un stagiaire nommé \"([^\"]*)\"$")
    public void j_ai_un_stagiaire_nommé(String nom) throws Exception {
        stagiaire = new Stagiaire();
        stagiaire.setNom(nom);
    }

    @Etantdonné("^ce stagiaire a le matricule \"([^\"]*)\"$")
    public void ce_stagiaire_a_le_matricule(String matricule) throws Exception {
        stagiaire.setMatricule(matricule);
        testEntityManager.getEntityManager().persist(stagiaire);
    }

    @Quand("^ce stagiaire a obtenu les notes suivantes$")
    public void ce_stagiaire_a_obtenu_les_notes_suivantes(List<Note> notes) throws Exception {
        notes.stream()
                .forEach(note ->
                    {testEntityManager.getEntityManager().persist(note);}
                );
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
