package fr.bpifrance.dqops.qip.qua.formation.domaine.models.shopping;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Panier  implements Serializable {
    private Map<Article, Integer> articles=new HashMap<>();
    private Double prixTotal;

}
