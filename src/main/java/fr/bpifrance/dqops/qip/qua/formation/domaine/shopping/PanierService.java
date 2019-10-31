package fr.bpifrance.dqops.qip.qua.formation.domaine.shopping;

import fr.bpifrance.dqops.qip.qua.formation.dao.IFormationDao;
import fr.bpifrance.dqops.qip.qua.formation.dao.shopping.IShoppingDao;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Article;
import fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping.Panier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PanierService extends Panier implements IPanierService {
    @Autowired
    public IShoppingDao shoppingDao;

    public PanierService(IShoppingDao shoppingDao){
        this.shoppingDao=shoppingDao;
    }

    @Override
    public List<Article> listeArticles() {
        return  new ArrayList<Article>(this.getArticles().keySet());
    }

    @Override
    public void ajouterArticle(String nom, Integer quantité) {
        Article article = shoppingDao.trouverArticle(nom);
        this.getArticles().put(article, quantité);
        this.setPrixTotal(this.calculerPrixPanier());
    }

    @Override
    public Double calculerPrixPanier() {
        return getArticles().entrySet()
                .stream()
                    .mapToDouble(e-> e.getKey().getPrixUnitaire()*e.getValue())
                        .sum();
    }

    @Override
    public boolean estVide() {
        return getArticles().isEmpty();
    }


}
