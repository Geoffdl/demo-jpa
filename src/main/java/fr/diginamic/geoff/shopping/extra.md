## Systeme shopping JPA

Panier
Produit
Commande
Livraison

Panier ----- Produit OneToMany
|
|OneToOne
|
Commande ---- Livraison ManyToOne    

Panier (
    Produit
    Quantité
    Prix_Total
)
Produit (
    Nom
    Prix
)
Commande (
    Client_ID
    Panier_ID
)
Livraison (
    Date_Livraison  
    Commande_ID 
    
)