DROP DATABASE IF EXISTS personal_db;
DROP USER IF EXISTS `personal_admin`@`localhost`;

CREATE DATABASE personal_db;
CREATE USER `personal_admin`@`localhost` IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON personal_db.* TO `personal_admin`@`localhost`;
FLUSH PRIVILEGES;