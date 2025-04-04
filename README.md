# Hero API – TP JEE (Partie 1 & 2)

Projet Spring Boot permettant de gérer une liste de super-héros via une API REST.  
Ce projet a été réalisé dans le cadre du TP n°1 (parties 1 et 2) du module JEE.

## Objectifs

- Créer une application Spring Boot complète avec une base de données persistante
- Implémenter un modèle `Hero` exposé via une API REST
- Ajouter la logique de **combats entre héros** et l'enregistrement automatique auprès d'une arène distante
- Utiliser Spring Data JPA pour accéder aux données
- Tester les endpoints en local et via Swagger UI

---

## Technologies utilisées

- Java 21 (SDK Telurin 23)
- Spring Boot 3.4.4
- Spring Data JPA
- Base de données H2 (mode fichier, persistante)
- Springdoc OpenAPI 2.3.0
- Lombok & MapStruct
- IntelliJ IDEA (Gradle)

---

## Structure du projet

```
heroapi/
├── controller/         --> HeroController (REST API)
├── dto/                --> DTOs exposés via Swagger (HeroDTO, BattleRequest, etc.)
├── exception/          --> Gestion centralisée des erreurs
├── mapper/             --> MapStruct (Entity <-> DTO)
├── model/              --> Hero.java (entité JPA)
├── repository/         --> HeroRepository (accès BDD)
├── service/            --> Logique métier (HeroService, BattleService, ArenaRegistrationService)
└── HeroapiApplication  --> Classe principale Spring Boot
```

---

## Fonctionnalités exposées par l'API

### Lister tous les héros
```
GET /api/heroes
```

### Obtenir un héros par ID
```
GET /api/heroes/{id}
```

### Rechercher un héros par nom (insensible à la casse)
```
GET /api/heroes/search?name=bat
```

### Obtenir un héros aléatoire
```
GET /api/heroes/random
```

### Ajouter un nouveau héros
```
POST /api/heroes
Content-Type: application/json
```
Exemple :
```json
{
  "name": "Batman",
  "universe": "DC",
  "powerLevel": 88
}
```

### Combattre dans l’arène (nouveau)
```
POST /api/heroes/battle
Content-Type: application/json
```
Exemple :
```json
{
  "hero1Id": 1,
  "hero2Id": 2
}
```
Retourne le gagnant et les statistiques du combat.

---

## Swagger UI

La documentation interactive est disponible à :
```
http://localhost:8082/swagger-ui/index.html
```

Toutes les routes sont testables en ligne.

---

## Base de données

Le projet utilise H2 en **mode fichier**, les données sont conservées entre les redémarrages.

Console H2 :
```
http://localhost:8082/h2-console
```

- JDBC URL : `jdbc:h2:file:./data/hero-db`
- Utilisateur : `sa`
- Mot de passe : (laisser vide)

---

## Lancement du projet

1. Ouvrir le projet dans IntelliJ
2. Ouvrir `HeroapiApplication.java`
3. Clic droit → Run (profil `dev` actif par défaut)

L'application démarre sur le port `8082`.

---

## Exemple de test avec `curl`
```bash
curl -X POST http://localhost:8082/api/heroes \
  -H "Content-Type: application/json" \
  -d '{"name":"Robin","universe":"DC","powerLevel":78}'
```

---

## Enregistrement auprès de l’arène

Lors du démarrage, l’API tente de s’enregistrer automatiquement auprès du serveur distant d’arène :
```
POST http://51.210.251.137/
```
Corps envoyé :
```json
[
  { "key": "GD@evweb", "value": "Gaëtan" },
  { "key": "baseUrl", "value": "http://localhost:8082" }
]
```
⚠️ Ne fonctionne que pendant la phase de test (serveur distant non accessible en production).

---

## Remarques

Ce projet couvre à présent :
- ✅ Partie 1 : API REST CRUD + recherche + aléatoire
- ✅ Partie 2 : logique de combat + enregistrement à l’arène

Développement conforme aux standards Spring Boot modernes (Lombok, DTO, REST propre, Swagger).

---

## Auteur

Gaëtan D. – Bachelor Développement Web (2025)

