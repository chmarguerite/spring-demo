package fr.bpifrance.dqops.qip.qua.formation.dao.repositories;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("select n from Note n where n.matricule = ?1")
    List<Note> obtenirNotesStagiaire(String matricule);
}
