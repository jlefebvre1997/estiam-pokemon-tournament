# estiam-pokemon-tournament

Ce projet d'école a pour but de simuler un tournoi de Pokémons en ligne de commande. 

## Démarrage 

À l'éxecution du projet, un menu apparaît dans le terminal d'éxecution, avec 4 choix possibles : 

- 1 : Tournoi généré aléatoirement avec 2 joueurs possédant chacun une équipe de 6 pokemons.
- 2 : Tournoi personnalisé, avec 2 joueurs possédant chacun une équipe de 6 pokemons. Dans le terminal seront demandés
le nom de l'équipe de chaque joueur, le type du Pokemon par rapport aux types disponibles, le nom du Pokemon et son niveau.
- 3 : Tournoi généré aléatoirement avec uniquement une liste de Pokemons, contenant 10 pokemons (V1)
- 4 : Tournoi personnalisé avec uniquement une liste de Pokemons. Seront demandés dans le terminal le nombre de pokemons participant au tournoi, et pour chaque pokemon le type du Pokemon
par rapport aux types disponibles, le nom du Pokemon, et son niveau. (V1)

## Ce qui a été fait : 

Ayant mal lu le sujet (ma faute, entièrement), j'ai commencé par une application dans le style du jeu Pokemon auquel
j'ai joué : 2 dresseurs avec chacun 6 pokemons qui s'affrontent. J'ai donc mis en place une architecture en conséquence, 
avec utilisation de plusieurs designs patterns : Factory pour créer les Pokemons, Facade pour cacher la logique métier,
Singleton pour s'assurer qu'une seule instance de Facade et de Factory seront disponibles. 

J'ai ensuite réalisé mon erreur, mais j'ai décidé, plutôt que de laisser le projet tel quel, de développer en plus la structure 
du sujet de base. 

J'ai donc découpé mon programme en 4 "jeux" : 1 jeu pour la V1 aléatoire, un jeu pour la V1 personnalisée, et même chose pour la V2. 

J'ai pu réaliser les développements pour la V1 assez rapidement, puisque j'avais déjà une Factory / une Facade qui me permettaient
de créer des Pokemons à la volée. 

J'ai également, dans la Factory, ajouté le moyen d'ajouter des types de Pokemons à la volée. 

## Ce qui reste à faire : 

Techniquement rien :) 