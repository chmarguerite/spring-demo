package fr.bpifrance.dqops.qip.qua.formation.test.ut;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import cucumber.deps.com.thoughtworks.xstream.converters.Converter;
import fr.bpifrance.dqops.qip.qua.formation.dao.IFormationDao;
import fr.bpifrance.dqops.qip.qua.formation.dao.shopping.IShoppingDao;
import fr.bpifrance.dqops.qip.qua.formation.domaine.StagiaireService;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Article;
import fr.bpifrance.dqops.qip.qua.formation.domaine.shopping.PanierService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class PanierStepDefinitions {

    IShoppingDao shoppingDao;
    PanierService panierService;
    @Before
    public void setup(){
        shoppingDao = Mockito.mock(IShoppingDao.class);
        panierService = new PanierService(shoppingDao);

    }
    @Etantdonné("^je suis un visiteur du site connecté$")
    public void je_suis_un_visiteur_du_site_connecté() throws Exception {
        System.out.println("Je suis connecté sur l'application");
    }

    @Etantdonné("^mon panier est vide$")
    public void mon_panier_est_vide() throws Exception {

        assertThat(panierService.estVide()).isTrue();
    }

    Article article;
    @Etantdonné("^l'article \"([^\"]*)\" est référencé$")
    public void l_article_est_référencé(String libellé) throws Exception {
        article = new Article();
        article.setNom(libellé);

    }

    @Etantdonné("^le prix de cet article est (\\d+)€$")
    public void le_prix_de_cet_article_est_€(double prix) throws Exception {
        article.setPrixUnitaire(prix);
        when(shoppingDao.trouverArticle(article.getNom())).thenReturn(article);
    }

    @Lorsque("^j'ajoute une quantité de (\\d+) de cet article$")
    public void j_ajoute_une_quantité_de_de_l_article(int quantité) throws Exception {
        panierService.ajouterArticle(article.getNom(), quantité);
    }

    @Lorsque("^j'ajoute une quantité de (\\d+) de l'article \"([^\"]*)\"$")
    public void j_ajoute_une_quantité_de_de_l_article(int quantité, String nom) throws Exception {
        panierService.ajouterArticle(nom, quantité);

    }

    @Alors("^le prix de mon panier est de (\\d+)€$")
    public void le_prix_de_mon_panier_est_de_€(int prixCalculé) throws Exception {
        assertThat(panierService.getPrixTotal()).isEqualTo(prixCalculé);
    }


    @Etantdonné("^les articles suivants$")
    public void les_articles_suivants(List<Article> articles) throws Exception {
        articles.stream().forEach(
                article -> {
                    when(shoppingDao.trouverArticle(article.getNom())).thenReturn(article);
                });
    }

    @Lorsque("^j'ajoute les quantités suivantes$")
    public void j_ajoute_une_quantité_de_de_l_article(List<Map<String, String>> nombreArticles) throws Exception {
        nombreArticles.stream().forEach(
                quantitéArticle -> {
                    System.out.println(quantitéArticle.get("article"));
                    panierService.ajouterArticle(quantitéArticle.get("article"), Integer.valueOf(quantitéArticle.get("quantité")));
                }
        );
    }

}
