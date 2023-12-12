DROP DATABASE IF EXISTS jakegodsall_db;
DROP USER IF EXISTS `admin_user`@`localhost`;

CREATE DATABASE jakegodsall_db;
CREATE USER `admin_user`@`localhost` IDENTIFIED BY "password";
GRANT ALL PRIVILEGES ON jakegodsall_db.* TO `admin_user`@`localhost`;
FLUSH PRIVILEGES;