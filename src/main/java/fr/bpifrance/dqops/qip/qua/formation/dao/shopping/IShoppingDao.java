package fr.bpifrance.dqops.qip.qua.formation.dao.shopping;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Note;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Article;

import java.util.List;

public interface IShoppingDao {
    public Article trouverArticle(String nom);
}
