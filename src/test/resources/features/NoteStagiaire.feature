#language: fr
Fonctionnalité: Notes
En tant qu'examinateur, je dois pouvoir gérer les notations d'un stagiaire

Contexte:
Etant donné j'ai un stagiaire nommé "Milouse Van Houten"
Et ce stagiaire a le matricule "m00001"

Scénario: Note moyenne des modules d'un stagiaire
Quand ce stagiaire a obtenu les notes suivantes
| matricule |	cours	|	note	|
| m00001 |	Java	|	85		|
| m00001 |	Cucumber|	62		|
| m00001 |	Selenium|	36		|
Et je calcule la moyenne
Alors ce stagiaire a une note moyenne de 61

Scénario: Note moyenne des modules d'un stagiaire à 50
  Quand ce stagiaire a obtenu les notes suivantes
    | matricule |	cours	|	note	|
    | m00001 |		Java		|	50		|
    | m00001 |		Cucumber	|	50		|
    | m00001 |		Selenium	|	50		|
  Et je calcule la moyenne
  Alors ce stagiaire a une note moyenne de 50

  Plan du scénario: Note moyenne des modules d'un stagiaire
    Quand ce stagiaire a obtenu les notes suivantes
      | matricule |	cours	    |	note	        |
      | m00001 |		Java	|	<note java>	    |
      | m00001 |		Cucumber|	<note cucumber>	|
    Et je calcule la moyenne
    Alors ce stagiaire a une note moyenne de <note moyenne>

    Exemples:
    | note java | note cucumber | note moyenne |
    | 40        | 60            |50            |
    | 90        | 80            |85            |
