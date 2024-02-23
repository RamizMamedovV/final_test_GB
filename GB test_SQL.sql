CREATE DATABASE HumanFriends;

USE HumanFriends;

CREATE TABLE pets(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type varchar(100)
  );
  
INSERT INTO `pets` VALUES
	(1, 'dog'),
    (2, 'cat'),
    (3, 'hamster');
  
CREATE TABLE pack_animals(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type varchar(100)
  );

INSERT INTO `pack_animals` VALUES
	(1, 'horse'),
    (2, 'camel'),
    (3, 'donkey');

CREATE TABLE dogs(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX dog_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pets(id)
 ); 

CREATE TABLE cats(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX cat_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pets(id)
 );

CREATE TABLE hamsters(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX hamsters_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pets(id)
 );
 
 
 CREATE TABLE horses(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX horses_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pack_animals(id)
 ); 
 
 CREATE TABLE camels(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX camels_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pack_animals(id)
 );
 
 CREATE TABLE donkeys(
 id SERIAL,
 type_id INT UNSIGNED NOT NULL,
 name varchar(44) not null,
 birthday date,
 commands varchar(100),
 
 INDEX donkeys_name_idx(name),
 FOREIGN KEY(type_id) REFERENCES pack_animals(id)
 );
 
 
INSERT INTO `dogs` VALUES
	(1, 1, 'dog1', '2023-01-01', 'sit, run, come here'),
	(2, 1, 'dog2', '2024-01-01', 'sit, come here');
    
INSERT INTO `cats` VALUES
	(1, 2, 'cat1', '2022-12-01', 'kiss'),
	(2, 2, 'cat2', '2023-12-01', 'kiss');
    
INSERT INTO `hamsters` VALUES
    (1, 3, 'hammy1', '2023-11-01', 'hide');
INSERT INTO `hamsters`(type_id, name, birthday) VALUES
    (3, 'hammy2', '2023-10-01');
     
INSERT INTO `horses` VALUES
	(1, 1, 'horse1', '2022-11-01', 'go'),
	(2, 1, 'horse2', '2010-11-01', 'go, up');
INSERT INTO `camels` VALUES
    (1, 2, 'camel1', '2013-12-01', 'sit, up'),
    (2, 2, 'camel2', '2009-12-01', 'sit, up, go');
INSERT INTO `donkeys` VALUES
    (1, 3, 'donkey1', '2014-01-01', 'stop, go'),
    (2, 3, 'donkey2', '2010-01-01', 'stop, go');
    
DELETE FROM pack_animals WHERE id = 2;
DROP TABLE camels;

SELECT * 
FROM horses
UNION
SELECT *
FROM donkeys;

SELECT name,
TIMESTAMPDIFF(YEAR, birthday, NOW()) AS `age`
FROM DOGS
WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) >= 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) <= 3
UNION
SELECT name,
TIMESTAMPDIFF(YEAR, birthday, NOW()) as `age`
FROM cats
WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) >= 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) <= 3;


/*Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице*/

CREATE OR REPLACE VIEW young_animals_1_3_years_old AS
SELECT name, birthday, age
FROM (
    SELECT name, birthday, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS `age`
    FROM dogs
    UNION ALL
    SELECT name, birthday, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS `age`
    FROM cats
    UNION ALL
    SELECT name, birthday, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS `age`
    FROM hamsters
    UNION ALL
    SELECT name, birthday, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS `age`
    FROM horses
    UNION ALL
    SELECT name, birthday, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS `age`
    FROM donkeys
) AS combined
WHERE age >= 12 AND age <= 36;

SELECT * FROM young_animals_1_3_years_old;

/*12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.*/

SELECT * 
FROM dogs 
LEFT join pets ON pets.id = dogs.type_id
UNION ALL
SELECT * 
from cats 
left join pets ON pets.id = cats.type_id
UNION ALL
SELECT * 
FROM hamsters 
LEFT join pets ON pets.id = hamsters.type_id
UNION ALL
SELECT * 
FROM donkeys 
LEFT JOIN pack_animals ON pack_animals.id = donkeys.type_id
UNION ALL
SELECT * 
FROM horses 
LEFT JOIN pack_animals ON pack_animals.id = horses.type_id;

 
 
 
 
 
 
 
 
 
 
 