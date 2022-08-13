DROP TABLE IF EXISTS MEMBERS;

-- Create a table from the csv
CREATE TABLE MEMBERS AS SELECT * FROM CSVREAD('Members.csv');

-- Alternatively create an empty table by SQL
-- CREATE TABLE MEMBERS (
--                                id INT AUTO_INCREMENT PRIMARY KEY,
--                                member_id VARCHAR(250) NOT NULL,
--                                birth_year INT NOT NULL,
--                                birth_month INT NOT NULL,
--                                birth_day INT NOT NULL,
--                                birth_country VARCHAR(250) NOT NULL,
--                                first_name VARCHAR(250) NOT NULL,
--                                last_name VARCHAR(250) NOT NULL,
--                                weight INT DEFAULT NULL,
--                                height INT DEFAULT NULL,
-- );