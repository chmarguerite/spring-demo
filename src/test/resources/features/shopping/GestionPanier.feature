#language: fr
@Panier
Fonctionnalité:  Ajout d'articles au panier
  En tant que visiteur du site e-Commerce,
  je veux pouvoir sélectionner des produits dans un panier virtuel
  afin de préparer une liste de produits que je pourrais commander en toute sérénité.


  Scénario: Ajouter un premier article avec une quantité 1
    Etant donné mon panier est vide
    Et l'article "Iphone 8" est référencé
    Et le prix de cet article est 500€
    Quand j'ajoute une quantité de 1 de l'article "Iphone 8"
    Alors le prix de mon panier est de 500€


  Scénario: Ajouter un premier article avec une quantité 2
    Etant donné mon panier est vide
    Et l'article "Iphone 7" est référencé
    Et le prix de cet article est 400€
    Quand j'ajoute une quantité de 2 de l'article "Iphone 7"
    Alors le prix de mon panier est de 800€

  #Contexte:
    # Etant donné je suis un visiteur du site connecté
   #  Et mon panier est vide

 # Scénario: Ajouter un premier article avec une quantité nulle
 #   Etant donné l'article "Iphone 8" est référencé
 #   Et le prix de cet article est 500€
 #   Lorsque j'ajoute une quantité de 0 de l'article "Iphone 8"
 #   Alors mon panier est vide

  Scénario: Ajouter un premier article avec une quantité 1
    Etant donné l'article "Iphone 8" est référencé
    Et le prix de cet article est 500€
    Lorsque j'ajoute une quantité de 1 de l'article "Iphone 8"
    Alors le prix de mon panier est de 500€

  Scénario: Ajouter un premier article avec une quantité 5
    Etant donné l'article "Iphone 8" est référencé
    Et le prix de cet article est 500€
    Lorsque j'ajoute une quantité de 5 de cet article
    Alors le prix de mon panier est de 2500€

  Plan du scénario: Ajouter un premier article avec une quantité 5
    Etant donné l'article "<nom>" est référencé
    Et le prix de cet article est <prix unitaire>€
    Lorsque j'ajoute une quantité de <quantité> de l'article "<nom>"
    Alors le prix de mon panier est de <prix total>€
Exemples:
  | nom     | prix unitaire | quantité | prix total |
  | Iphone  | 500           | 2        | 1000       |
  | Samsung | 350           | 2        |  700       |



  Scénario: Ajouter plusieurs articles avec des quantités différentes
    Etant donné les articles suivants
      | nom     | prix unitaire |
      | Iphone  | 500           |
      | Samsung | 350           |
      | TV      | 200           |
    Etant donné j'ajoute les quantités suivantes
      | article |  quantité |
      | Iphone  |  2        |
      | Samsung |  2        |
      | TV      |  3        |
    Alors le prix de mon panier est de 2300€

  Scénario: Ajouter plusieurs articles avec des quantités différentes
    Etant donné les articles suivants
      | nom     | prix unitaire |
      | Iphone  | 500           |
      | Samsung | 350           |
      | TV      | 200           |
    Etant donné j'ajoute les quantités suivantes
      | article |  quantité |
      | Iphone  |  2        |
      | Samsung |  2        |
      | TV      |  4        |
    Alors le prix de mon panier est de 2500€