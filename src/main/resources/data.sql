-- DOMAINS
INSERT INTO domain (id, name)
SELECT '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'Analiza Matematica'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b811-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO domain (id, name)
SELECT '6ba7b812-9dad-11d1-80b4-00c04fd430c8', 'Tehnologia Informatiei'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b812-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO domain (id, name)
SELECT '6ba7b813-9dad-11d1-80b4-00c04fd430c8', 'Mecanica'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b813-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO domain (id, name)
SELECT '6ba7b814-9dad-11d1-80b4-00c04fd430c8', 'Literatura Universala'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b814-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO domain (id, name)
SELECT '6ba7b815-9dad-11d1-80b4-00c04fd430c8', 'Grafica'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b815-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO domain (id, name)
SELECT '6ba7b816-9dad-11d1-80b4-00c04fd430c8', 'Economie si Finante'
    WHERE NOT EXISTS (SELECT 1 FROM domain WHERE id = '6ba7b816-9dad-11d1-80b4-00c04fd430c8');

-- COURSES
INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b821-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Medicina Generala'),
       'Curs Introductiv Antaopatologie', 100, 2, 10
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b821-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b822-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Medicina Generala'),
       'Curs Avansat Chirurgie', 200, 3, 10
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b822-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b823-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Analiza Matematica'),
       'Curs Introductiv Functii de Gradul 2', 150, 2, 12
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b823-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b824-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Analiza Matematica'),
       'Curs Avansat Derivate', 210, 1, 10
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b824-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b825-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Tehnologia Informatiei'),
       'Curs Introductiv Arhitectura Calculatoarelor', 140, 3, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b825-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b826-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Tehnologia Informatiei'),
       'Curs Introductiv Programarea Calculatoarelor', 300, 2, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b826-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b827-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Mecanica'),
       'Curs Avansat Rezistenta Materialelor', 240, 1, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b827-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b828-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Mecanica'),
       'Curs Introductiv Vectori', 190, 3, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b828-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b829-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Literatura Universala'),
       'Curs Introductiv Stiluri Literare', 210, 2, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b829-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b830-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Literatura Universala'),
       'Curs Modernism', 145, 4, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b830-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b831-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Grafica'),
       'Curs Umbre', 220, 2, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b831-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b832-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Grafica'),
       'Curs Iluzii Optice', 195, 3, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b832-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b833-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Economie si Finante'),
       'Curs Bugete', 180, 4, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b833-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO course (id, domain_id, name, price, duration, number_of_persons)
SELECT '6ba7b834-9dad-11d1-80b4-00c04fd430c8', (SELECT id FROM domain WHERE name = 'Economie si Finante'),
       'Curs Dobanzi', 310, 2, 8
    WHERE NOT EXISTS (SELECT 1 FROM course WHERE id = '6ba7b834-9dad-11d1-80b4-00c04fd430c8');

-- DISCOUNT CATEGORIES

INSERT INTO discount_category (id, name, percentage)
SELECT '6ba7b811-9dad-11d1-80b4-00c04fd430c8', 'Adult', 0
    WHERE NOT EXISTS (SELECT 1 FROM discount_category WHERE id = '6ba7b811-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO discount_category (id, name, percentage)
SELECT '6ba7b812-9dad-11d1-80b4-00c04fd430c8', 'Student', 90
    WHERE NOT EXISTS (SELECT 1 FROM discount_category WHERE id = '6ba7b812-9dad-11d1-80b4-00c04fd430c8');

INSERT INTO discount_category (id, name, percentage)
SELECT '6ba7b813-9dad-11d1-80b4-00c04fd430c8', 'Elev', 50
    WHERE NOT EXISTS (SELECT 1 FROM discount_category WHERE id = '6ba7b813-9dad-11d1-80b4-00c04fd430c8');


