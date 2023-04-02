# Cours-de-java
RPG Harry Potter (Constance PERSAD G2D)

1.	Choix des caractéristiques du personnage.

Dans mon jeu la class « principale » est Exécution, c’est elle qui va appeler les méthodes qui vont donner des attributs a notre sorcier (maison, animal, baguette…). La méthode qui contient toute la logique du jeu, et celle qu'on appelle dans le Main est startGame(). L'autre class important est la class Game, dans laquelle des méthodes de saisie et d'affichage sont créées.   			
- Le joueur rentre ces caractéristiques en commençant par son prénom. La méthode "readInt" dans la class Game permet de vérifier que l'utilisateur renvoi une réponse correcte.				
- Puis on crée une instance de la class Wizard avec le nom du sorcier, son nombre de xp, une méthode your_house de la class House. Dans cette class 3 méthodes permettent de poser des questions aux joueurs, de récupérer ces réponses, et de définir sa maison. On fait de même avec la méthode choosePet() de la class Pet et pour finir avec la méthode choose_wand de la class Wand.
-On créer également un Boolean pour vérifier que le jeu tourne toujours, et dans notre boucle de jeu nous l’initialiserons a True si le personnage meurt, ou si il souhaite quitter le jeu la variable prendra False et le jeu s’arrêteras.

2.	Fonction pour la dynamique du jeu.						
À la suite de la création de notre personnage, nous afficherons un menu pour qu'il puisse soit voir ces informations, soit continuer le jeu, soit quitter le jeu. Ce menu s'affichera à la fin de chaque niveau. Nous allons ensuite dans la fonction checkAct() qui définit selon le niveau, l'ennemie que vous allez devoir affronter. À chaque niveau, on affiche l'histoire grâce a des méthodes de la class Story, on appeler les méthodes battle (même méthode pour level 1,2, et3). Puis on affiche l'histoire de fin et on incrémente le niveau ainsi les xp du joueur.

3.	Battle niveau 1,2, et 3.									
Dans la méthode battle, on vérifie grâce a une boucle while on vérifie que tant que le sorcier ou l'ennemi sont en vie le jeu continue. On demande au joueur ce qu'il souhaite faire, soit affronté l'ennemi, soit récupérer de la vie ou bien quitter le combat. Si le joueur souhaite se battre alors, le sorcier est celui qui attaque en premier. Pour le niveau 1, le sorcier ne peut utiliser que "Wingardium Leviosa", dans le niveau 2, il a le choix entre le sort précédent et le nouveau sort "Accio". Pour le troisième niveau, le joueur ne peut utiliser qu'Expecto patronum, le type d'animal de son patronus est défini via un questionnaire, selon l'animal choisi les dégâts infliger a l'ennemie seront différent. Sinon pour les sorts les dégâts sont inscrit dans la méthode  Choose_spell(), et retourne un dégâts différent en fonction du sort choisi. Il faut également prendre en compte que les potions de vie sont plus efficaces pour les membres de Hufflepuff. Les sorts font plus de dégâts pour les membres de Slytherin. Les sorciers de Gryffindor sont plus résistants aux dégâts.Les sorciers de Ravenclaw sont plus précis.Donc le choix de la maison du sorcier au début du jeu, à une importance.

4.	Battle niveau 4,5,6 et 7.
Dans le niveau 4, on fait face à deux ennemies, dont Voldemort. J'ai considéré  que le sorcier n'était pas assez fort pour vaincre les deux ennemis donc le but est d'utiliser au moins trois fois le sort "Accio" pour attraper le portoloin et quitter le combat. Lors du combat, vous avez le choix entre plusieurs sorts, mais utiliser bien uniquement "Accio" pour ne pas perdre trop de points de vie.
