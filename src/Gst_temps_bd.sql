CREATE DATABASE gst_temps_bd;
USE gst_temps_bd;


-- Table Enseignants
CREATE TABLE Enseignants (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(255),
  prenom VARCHAR(255),
  telephone VARCHAR(20),
  matricule VARCHAR(50),
  email VARCHAR(255)
);

-- Table Matières
CREATE TABLE Matieres (
  id INT PRIMARY KEY AUTO_INCREMENT,
  intitule VARCHAR(255),
  code VARCHAR(50)
);

-- Table Classes
CREATE TABLE Classes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  intitule VARCHAR(255),
  code VARCHAR(50)
);

-- Table Années scolaires
CREATE TABLE AnneesScolaires (
  id INT PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(50),
  dateDebut DATE,
  dateFin DATE
);

-- Table Cours
CREATE TABLE Cours (
  id INT PRIMARY KEY AUTO_INCREMENT,
  idMatiere INT,
  idEnseignant INT,
  idClasse INT,
  idAnneeScolaire INT,
  FOREIGN KEY (idMatiere) REFERENCES Matieres(id),
  FOREIGN KEY (idEnseignant) REFERENCES Enseignants(id),
  FOREIGN KEY (idClasse) REFERENCES Classes(id),
  FOREIGN KEY (idAnneeScolaire) REFERENCES AnneesScolaires(id)
);

-- Table Emplois du temps
CREATE TABLE EmploisDuTemps (
  id INT PRIMARY KEY AUTO_INCREMENT,
  idEnseignant INT,
  idCours INT,
  heureDebut TIME,
  heureFin TIME,
  salle VARCHAR(50),
  FOREIGN KEY (idEnseignant) REFERENCES Enseignants(id),
  FOREIGN KEY (idCours) REFERENCES Cours(id)
);
