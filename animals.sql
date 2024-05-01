use bd_animals;

DROP TABLE Pets;
DROP TABLE PackAnimals;

--  - Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

CREATE TABLE Pets (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(50),
  Type VARCHAR(50),
  BirthDate date,
  Commands VARCHAR(50)
);

--    - Заполнить таблицы данными о животных, их командах и датами рождения.

INSERT INTO Pets (Name, Type, BirthDate, Commands)
VALUES
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

--  - Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

CREATE TABLE PackAnimals (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(50),
  Type VARCHAR(50),
  BirthDate date,
  Commands VARCHAR(50)
);

--    - Заполнить таблицы данными о животных, их командах и датами рождения.

INSERT INTO PackAnimals (Name, Type, BirthDate, Commands)
VALUES
('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Storm', 'Horse', '2023-03-05', 'Trot, Canter'),
('Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
('Burro', 'Donkey', '2022-01-23', 'Walk, Bray, Kick'),
('Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
('Sahara', 'Camel', '2015-08-14', 'Walk, Run');



SELECT * FROM Pets
UNION ALL 
SELECT * FROM PackAnimals;

-- - Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

SELECT * FROM PackAnimals
WHERE NOT Type = 'Camel';

--   - Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

SELECT 
    *,
    TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) - 
    (DATE_FORMAT(CURDATE(), '%y%m%d') < DATE_FORMAT(BirthDate, '%y%m%d')) AS AgeInYears
FROM Pets
WHERE BirthDate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
AND BirthDate >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR)

UNION ALL 

SELECT 
    *,
    TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) - 
    (DATE_FORMAT(CURDATE(), '%y%m%d') < DATE_FORMAT(BirthDate, '%y%m%d')) AS AgeInYears
FROM PackAnimals
WHERE BirthDate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
AND BirthDate >= DATE_SUB(CURDATE(), INTERVAL 3 YEAR);


-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.


SELECT 
    'Pets' AS SourceTable,
    ID,
    Name,
    Type,
    BirthDate,
    Commands,
    TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) - 
    (DATE_FORMAT(CURDATE(), '%y%m%d') < DATE_FORMAT(BirthDate, '%y%m%d')) AS AgeInYears
FROM Pets

UNION ALL 

SELECT 
    'PackAnimals' AS SourceTable,
    ID,
    Name,
    Type,
    BirthDate,
    Commands,
    TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) - 
    (DATE_FORMAT(CURDATE(), '%y%m%d') < DATE_FORMAT(BirthDate, '%y%m%d')) AS AgeInYears
FROM PackAnimals;



