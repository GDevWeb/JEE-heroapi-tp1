# Hero API – TP JEE (Partie 1)

Projet Spring Boot permettant de gérer une liste de super-héros via une API REST.  
Ce projet a été réalisé dans le cadre du TP n°1 (partie 1) du module JEE.

## Objectifs

- Créer une application Spring Boot complète avec une base de données persistante
- Implémenter un modèle `Hero` exposé via une API REST
- Utiliser Spring Data JPA pour accéder aux données
- Tester les endpoints en local

---

## Technologies utilisées

- Java 21 (SDK Telurin 23)
- Spring Boot 3.4.4
- Spring Data JPA
- Base de données H2 (mode fichier, persistante)
- IntelliJ IDEA (Gradle)

---

## Structure du projet

```
heroapi/
├── controller/         --> HeroController (REST API)
├── model/              --> Hero.java (entité JPA)
├── repository/         --> HeroRepository (accès BDD)
├── service/            --> HeroService + implémentation métier
└── HeroapiApplication  --> Classe principale Spring Boot
```

---

## Fonctionnalités exposées par l'API

### Lister tous les héros

```
GET /api/heroes
```

Retourne un tableau JSON contenant tous les héros enregistrés.

---

### Obtenir un héros par ID

```
GET /api/heroes/{id}
```

Retourne un objet héros correspondant à l'identifiant, ou une erreur 404 si introuvable.

---

### Rechercher un héros par nom (recherche partielle, insensible à la casse)

```
GET /api/heroes/search?name=bat
```

Retourne tous les héros contenant "bat" dans leur nom.

---

### Obtenir un héros aléatoire

```
GET /api/heroes/random
```

Retourne un héros sélectionné de manière aléatoire dans la base.

---

### Ajouter un nouveau héros

```
POST /api/heroes
Content-Type: application/json
```

Exemple de corps JSON :

```json
{
  "name": "Batman",
  "universe": "DC",
  "powerLevel": 88
}
```

---

## Base de données

Le projet utilise H2 en **mode fichier**, ce qui signifie que les données sont conservées entre les redémarrages.

Chemin de la base : `./data/hero-db.mv.db`

Console H2 accessible à :
```
http://localhost:8082/h2-console
```

Paramètres :
- JDBC URL : `jdbc:h2:file:./data/hero-db`
- Utilisateur : `sa`
- Mot de passe : (laisser vide)

---

## Lancement du projet

1. Ouvrir le projet dans IntelliJ
2. Ouvrir `HeroapiApplication.java`
3. Clic droit → Run

L'application démarre sur le port `8082`.

---

## Exemple de test avec `curl`

```bash
curl -X POST http://localhost:8082/api/heroes \
  -H "Content-Type: application/json" \
  -d '{"name":"Robin","universe":"DC","powerLevel":78}'
```

---

## Remarques

Ce projet constitue la première étape du TP.  
La **Partie 2 (gestion des combats entre héros)** sera ajoutée dès réception du sujet correspondant.
