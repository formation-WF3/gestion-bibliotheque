# gestion-bibliotheque

| :warning: IMPORTANT

Avant le premier lancement du projet, aller dans le fichier "/backend/src/main/resources/application.properties", et vérifier que la ligne :
```properties
spring.jpa.hibernate.ddl-auto=create-drop
```
soit bien telle quelle.
Si ce n'est pas le cas, et qu'elle est, par exemple, comme ceci :
```properties
spring.jpa.hibernate.ddl-auto=update
```
Il faut alors la modifier pour qu'elle soit comme indiquer plus haut.

Une fois le projet lancé, aller dans le logiciel vous permettant d'accéder à la base de données, par exemple, Adminer ou PHPMyAdmin.
Vérifier que la table "category" existe bien et exécuter le fichier "/backend/db-requests.sql" ou copier-coller son contenu dans la partie servant à exécuter des requêtes SQL, puis exécuter.
Vérifier ensuite que la table contient bien 5 lignes.

Avant le prochain lancement du projet, aller dans le fichier "/backend/src/main/resources/application.properties", et modifier la ligne :
```properties
spring.jpa.hibernate.ddl-auto=create-drop
```
     en
```properties
spring.jpa.hibernate.ddl-auto=update
```
A partir de là, plus besoin d'y toucher.

# Projet de gestion d’une bibliothèque

Le projet coté backend a été généré avec spring initializr :

Maven, Spring 3.1.2, Java 17, et les dépendances Spring Web, MySQL Driver, Spring Data JPA, Lombok, Spring Boot DevTools, et Spring Security.

Côté frontend, le projet a été généré avec Angular CLI 16.1.7

# Auteurs

Mr BENELHADJ Saïd, Mr FAURE Vincent, et Mr TAIGNIERE Gilles

# Promotion

Concepteur et Développeur d’Applications Java, avec Webforce3 et Itekway

# Commandes Angular

Création de différents éléments :

- ng generate component <chemin/nom-composant>
- ng generate directive <chemin/nom-directive>
- ng generate pipe <chemin/nom-pipe>
- ng generate service <chemin/nom-service>
- ng generate class <chemin/nom-classe>
- ng generate interface <chemin/nom-interface>
- ng generate enum <chemin/nom-enum>
- ng generate module <chemin/nom-module>
     ou avec routage : ng g m <chemin/nom-module> --routing
- ng generate guard <chemin/nom-guard>
- ng generate interceptor <chemin/nom-interceptor>
- ng generate resolver <chemin/nom-resolver>

# Exemple de titre du niveau le plus haut (niveau 1)

## Exemple de titre du niveau moyen (niveau 2)

### Exemple de titre du niveau le plus bas (niveau 3)

Exemple de ligne de texte
