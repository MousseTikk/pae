alter sequence hibernate_sequence restart with 63002;

insert into Student(matricule, name, gender, section) values
    (63000, 'Alice', 'FEMALE', 'DEVELOPPEMENT'),
    (63001, 'Bob', 'MALE', 'RESEAU');

insert into Course(id, title, crédits) values
    (1, 'WEBG5', 3),
    (2, 'ERPG5', 5),
    (3, 'TEX5', 1);

insert into student_programmes(programmes_id, subscribers_matricule) values
   (1,63000),
   (2,63000);
