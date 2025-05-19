# Hopital_Spring_MVC_Partie1

## 🏥 Application Web de Gestion des Patients

## 📘 Activité Pratique N°3 - Spring MVC

Ce projet est une application Web basée sur **Spring Boot**, **Spring MVC**, **Spring Data JPA**, **Thymeleaf** et **H2**. Elle permet la gestion des patients avec plusieurs fonctionnalités utiles.

---

## ✅ Fonctionnalités

- 📄 Affichage de la liste des patients
- 🔎 Recherche dynamique par nom
- 🧮 Pagination des résultats
- 🗑️ Suppression d’un patient
- 🎨 Améliorations visuelles avec Bootstrap :
  - Couleurs conditionnelles
  - Icônes et tooltips
  - Boutons stylisés
  - Interface responsive et claire

---

## 🧱 Technologies utilisées

- Java 17+
- Spring Boot / Spring MVC / Spring Data JPA
- H2 Database (en mémoire)
- Thymeleaf
- Bootstrap 5.3.5
- HTML / CSS

---

## 🖼️ Captures d'écran

### 1️⃣ Affichage initial de la liste des patients

![Liste des patients](static/captures/1.png)

---

### 2️⃣ Console H2 - Contenu de la base de données

![Console H2](static/captures/2.png)

---

### 3️⃣ Exemple de pagination

![Pagination - page 12](static/captures/3.png)

---

### 4️⃣ Une autre page paginée (page 9)

![Pagination - page 9](static/captures/4.png)

---

### 5️⃣ Résultat d'une recherche par nom "imad"

![Recherche IMAD](static/captures/5.png)

---

### 6️⃣ Résultat d'une recherche par lettre "A"

![Recherche par A](static/captures/6.png)

---

### 7️⃣ Résultat de la recherche avec pagination

![Recherche + Pagination](static/captures/7.png)

---

### 8️⃣ Version finale stylisée de l'interface

![UI Bootstrap améliorée](static/captures/8.png)

---

## ▶️ Lancer l'application

1. Cloner le projet dans ton IDE (IntelliJ recommandé)
2. Exécuter la classe `HopitalSpringMvcApplication`
3. Accéder à l’application via :  
   [http://localhost:8084/index](http://localhost:8084/index)

---

## 📂 Structure du projet

```bash
src/
├── main/
│   ├── java/
│   │   └── net.imad.hopital_spring_mvc/
│   │       ├── entities/Patient.java
│   │       ├── Repository/PatientRepository.java
│   │       └── web/PatientController.java
│   ├── resources/
│   │   ├── static/
│   │   │   └── captures/
│   │   │       ├── 1.png ... 8.png
│   │   └── templates/patients.html
│   └── application.properties
```

👤 Auteur
Projet réalisé dans le cadre de l'activité pratique du module Spring MVC - JEE
Nom : IMAD EL KHELYFY

