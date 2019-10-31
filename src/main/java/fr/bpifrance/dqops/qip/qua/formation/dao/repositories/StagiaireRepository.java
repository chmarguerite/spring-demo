package fr.bpifrance.dqops.qip.qua.formation.dao.repositories;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    @Query("select s from Stagiaire s where s.matricule = ?1")
    Stagiaire trouverStagiaire(String matricule);
}
