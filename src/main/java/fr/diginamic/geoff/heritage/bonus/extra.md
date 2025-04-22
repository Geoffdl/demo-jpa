Exercices bonus :

@Inheritance(strategy = SINGLE_TABLE) avec discriminants et règles métier

Contexte : Tu modélises un système de paiement. Il y a une classe MoyenPaiement, et trois sous-classes : 
- CarteCredit (numero, dateExpiration)
- PayPal (email)
- VirementBancaire (iban, banque) 
Chaque utilisateur peut avoir plusieurs moyens de paiement.

@MappedSuperclass
Tu développes une plateforme de contenus. Les articles, vidéos et podcasts doivent tous conserver une traçabilité complète : qui les a créés, quand, et quand ils ont été modifiés.
Ces informations doivent être partagées, mais aucune table ne doit être créée pour la classe abstraite.