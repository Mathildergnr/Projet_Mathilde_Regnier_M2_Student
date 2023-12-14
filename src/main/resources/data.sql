--supprimer les lignes de table
DELETE FROM student;
--ajouter des données dans la table
INSERT INTO student(id, name, age) VALUES (1, 'Mathilde', 23);
INSERT INTO student(id, name, age) VALUES (2, 'Guillaume', 21);
INSERT INTO student(id, name, age) VALUES (3, 'Diane', 18);
INSERT INTO student(id, name, age) VALUES (4, 'Vincent', 25);
INSERT INTO student(id, name, age) VALUES (5, 'Michel', 85);
INSERT INTO student(id, name, age) VALUES (6, 'Léa', 8);

-- Laissez la base de données générer automatiquement l'ID
--INSERT INTO student(name, age) VALUES ('Michel', 85);

-- Laissez la base de données générer automatiquement l'ID
--INSERT INTO student(name, age) VALUES ('Léa', 8);
--INSERT INTO student(name, age) VALUES ('Quentin', 23);

--mettre à jour l'âge de l'étudiant où l'id est 4
--UPDATE student SET age=26 WHERE id=4;

--supprimer l'étudiant où l'id est 5
--DELETE FROM student WHERE id = 5;

CREATE SEQUENCE seq START WITH 1 INCREMENT BY 1;

--récupérer toutes les données de la table
SELECT * FROM student;

