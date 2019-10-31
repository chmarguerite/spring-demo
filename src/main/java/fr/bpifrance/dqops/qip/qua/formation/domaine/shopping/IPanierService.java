package fr.bpifrance.dqops.qip.qua.formation.domaine.shopping;

import fr.bpifrance.dqops.qip.qua.formation.domaine.models.Stagiaire;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Article;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Panier;

import java.util.List;

public interface IPanierService {
    public List<Article> listeArticles();
    public void ajouterArticle(String nom, Integer quantité);
    public Double calculerPrixPanier();
    public boolean estVide();
}
