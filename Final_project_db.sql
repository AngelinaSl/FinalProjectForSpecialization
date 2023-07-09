-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
--  Создание БД
DROP DATABASE IF EXISTS `humans_friends`;
CREATE DATABASE IF NOT EXISTS `humans_friends`;

-- Используем созданную базу данных
USE `humans_friends`;

-- 8. Создать таблицы с иерархией из диаграммы в БД

-- Создаем таблицу "animals"
CREATE TABLE `animals` (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
  animals_class VARCHAR(30)
);

-- Создаем таблицу "dogs"
CREATE TABLE `dogs` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- Создаем таблицу "cats"
CREATE TABLE `cats` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- Создаем таблицу "hamsters"
CREATE TABLE `hamsters` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- Создаем таблицу "horses"
CREATE TABLE `horses` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- Создаем таблицу "camels"
CREATE TABLE `camels` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- Создаем таблицу "donkeys"
CREATE TABLE `donkeys` (
   id INT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `skills` VARCHAR(100) NOT NULL,
  `animal_class_id` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`animal_class_id`) REFERENCES `animals` (`id`) ON DELETE CASCADE -- используем внешний ключ на таблицу `animals`
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами, которые они выполняют, и датами рождения

-- Заполняем таблицу "animals", так как в низкоуровневых таблицах есть внешний ключ на данную таблицу
INSERT INTO `animals`
VALUES 
	('1', 'pet'),
    ('2', 'pack_animal');

-- Заполняем таблицу "dogs"
INSERT INTO `dogs` (`name`, `DOB`, `skills`, `animal_class_id`)
VALUES
  ('Bobik', '2018-05-11', 'Speak, Sit, Stay', 1),
  ('Scharik', '2020-01-08', 'Sit, Stay', 1),
  ('Nikki', '2020-08-22', 'Sit, Stay, Jump', 1),
  ('Akbar', '2015-10-31', 'Speak', 1);

-- Заполняем таблицу "cats"
INSERT INTO `cats` (`name`, `DOB`, `skills`, `animal_class_id`) 
VALUES
  ('Tishka', '2020-05-17', 'Meow, Sit', 1),
  ('Bars', '2009-09-14', 'Sit, Play', 1),
  ('Busya', '2013-08-06', 'Sit, Stay, Play, Meow', 1),
  ('Murka', '2023-01-31', 'Sit', 1);

-- Заполняем таблицу "hamsters"
INSERT INTO `hamsters` (`name`, `DOB`, `skills`, `animal_class_id`)  
VALUES
  ('Gold', '2017-03-15', 'Run, Sleep', 1),
  ('Umka', '2015-08-20', 'Run, Sleep', 1),
  ('Silver', '2020-05-05', 'Run, Sleep', 1),
  ('Sun', '2017-04-09', 'Run, Sleep', 1);

-- Заполняем таблицу "horses"
INSERT INTO `horses` (`name`, `DOB`, `skills`, `animal_class_id`)  
VALUES
  ('Appolon', '2017-11-25', 'Hop, Slower, Gallop, Step, Stop', 2),
  ('Dakar', '2022-03-15', 'Step, Stop', 2),
  ('Buran', '2020-09-05', 'Gallop, Step, Stop', 2),
  ('Aston', '2021-04-22', 'Slower, Gallop, Step, Stop', 2);

-- Заполняем таблицу "camels"

INSERT INTO `camels` (`name`, `DOB`, `skills`, `animal_class_id`)  
VALUES
  ('Hadar', '2023-06-04', 'Go, Stop', 2),
  ('Saif','2019-08-12', 'Go, Stop', 2),
  ('Sahara', '2016-07-24', 'Go, Run, Stop', 2),
  ('Kaf', '2018-02-01', 'Go, Run, Stop', 2);

-- Заполняем таблицу "donkeys"
INSERT INTO `donkeys` (`name`, `DOB`, `skills`, `animal_class_id`)  
VALUES
  ('Dora', '2020-12-16', 'Go, Run, Stop',  2),
  ('Ava', '2017-03-14','Go, Stop',  2),
  ('Choco','2022-04-07', 'Go, Run, Stop', 2),
  ('Cam', '2021-09-03','Go, Run, Stop',  2);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
-- Объединить таблицы лошади, и ослы в одну таблицу.

-- Удалить таблицу "camels"
  DROP TABLE IF EXISTS `camels`;

--  Объединить таблицы лошади, и ослы в одну таблицу
SELECT `name`, `DOB`, `skills` FROM horses
UNION SELECT  `name`, `DOB`, `skills` FROM donkeys;

-- 11.Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице
  
CREATE TEMPORARY TABLE `every_animals` AS 
SELECT *, "Dogs" as `kind`
FROM dogs
UNION SELECT *, "Cats" AS `kind` 
FROM cats
UNION SELECT *, "Hamsters" AS `kind`
FROM hamsters
UNION SELECT *, "Horses" AS `kind` 
FROM horses
UNION SELECT *, "Donkeys" AS `kind`
FROM donkeys;

CREATE TABLE `yang_animals` AS
SELECT `name`, `DOB`, `skills`, `kind`, TIMESTAMPDIFF(MONTH, DOB, CURDATE()) AS age_in_month
FROM every_animals 
WHERE DOB BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

CREATE TEMPORARY TABLE `all_animals` AS 
SELECT "Dogs" as `kind`, `animal_class_id` ,`name`, `DOB`, `skills`
FROM dogs
UNION SELECT "Cats" AS `kind`, `animal_class_id` ,`name`, `DOB`, `skills`
FROM cats
UNION SELECT "Hamsters" AS `kind`, `animal_class_id` ,`name`, `DOB`, `skills`
FROM hamsters
UNION SELECT "Horses" AS `kind`, `animal_class_id` ,`name`, `DOB`, `skills`
FROM horses
UNION SELECT "Donkeys" AS `kind`, `animal_class_id` ,`name`, `DOB`, `skills`
FROM donkeys;
