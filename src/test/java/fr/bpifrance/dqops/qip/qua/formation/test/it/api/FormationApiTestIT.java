package fr.bpifrance.dqops.qip.qua.formation.test.it.api;

import fr.bpifrance.dqops.qip.qua.formation.api.NoteMoyenneJson;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-it.properties")
public class FormationApiTestIT {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort //permet d'utiliser le port local du serveur, sinon une erreur "Connection refused"
    private int port;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void obtenirStagiairesVide() throws Exception {
        //Pas de formation normalement
        ResponseEntity<Object> responseEntity =
                restTemplate.getForEntity("/api/stagiaires",  Object.class);
        List<Stagiaire> stagiaires = (List<Stagiaire>) responseEntity.getBody();
        assertThat(stagiaires).hasSize(0);
    }

    @Test
    @Sql(scripts ="/data/init1.sql" ) // Initialisation de la db de test
    @Sql(scripts ="/data/close.sql",executionPhase = AFTER_TEST_METHOD ) // Vidage de la db à la fin du test
    public void obtenirStagiaire1() throws Exception {

        ResponseEntity<Stagiaire> responseEntity =
                restTemplate.getForEntity("/api/stagiaires/m00001",  Stagiaire.class);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getMatricule()).isEqualTo("m00001");
        assertThat(responseEntity.getBody().getNom()).isEqualTo("Homer Simpson");

    }

    @Test
    @Sql(scripts ="/data/init1.sql" ) // Initialisation de la db de test
    @Sql(scripts ="/data/close.sql",executionPhase = AFTER_TEST_METHOD ) // Vidage de la db à la fin du test
    public void obtenirMoyenne() throws Exception {

        ResponseEntity<NoteMoyenneJson> responseEntity =
                restTemplate.getForEntity("/api/stagiaires/m00002/moyenne",  NoteMoyenneJson.class);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getMatricule()).isEqualTo("m00002");
        assertThat(responseEntity.getBody().getMoyenne()).isEqualTo(15.0);

    }

    @Test
    @Sql(scripts ="/data/init1.sql" ) // Initialisation de la db de test
    @Sql(scripts ="/data/close.sql",executionPhase = AFTER_TEST_METHOD ) // Vidage de la db à la fin du test
    public void ajouterNotes() throws Exception {
        Note note = new Note("m00003","Java",20);
        ResponseEntity<?> responseEntity =
                restTemplate.postForEntity("/api/notes", note, ResponseEntity.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
        Query q = entityManager.createNativeQuery("Select * from note where matricule='m00003'", Note.class);
        Note noteDB= (Note) q.getSingleResult();
        assertThat(noteDB.getNote()).isEqualTo(20);

    }
}
