--supprimer les lignes de table
DELETE FROM student;

--ajouter des données dans la table
INSERT INTO student(id, name, age) VALUES (1, 'Mathilde', 23);
INSERT INTO student(id, name, age) VALUES (2, 'Guillaume', 21);
INSERT INTO student(id, name, age) VALUES (3, 'Diane', 18);
INSERT INTO student(id, name, age) VALUES (4, 'Vincent', 25);
INSERT INTO student(id, name, age) VALUES (5, 'Michel', 85);
INSERT INTO student(id, name, age) VALUES (6, 'Léa', 8);

--mettre à jour l'âge de l'étudiant où l'id est 4
UPDATE student SET age=26 WHERE id=4;

--supprimer l'étudiant où l'id est 5
DELETE FROM student WHERE id = 5;

--récupérer toutes les données de la table
SELECT * FROM student;

