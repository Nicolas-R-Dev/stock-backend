--CREATE DATABASE IF NOT EXISTS stock DEFAULT CHARACTER SET utf8mb4;
--USE stock;
--
---- 1) Employés
--CREATE TABLE IF NOT EXISTS employee (
--  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
--  unn          VARCHAR(20) NOT NULL UNIQUE,  -- numéro unique salarié
--  first_name   VARCHAR(50),
--  last_name    VARCHAR(50)
--);
--
---- 2) Types & sous-types de device
----    category: PC, PHONE, TABLET, PERIPHERAL...
----    kind:     DEV, TECH, ADMIN, SECRETARY...
--CREATE TABLE IF NOT EXISTS device_type (
--  id        BIGINT PRIMARY KEY AUTO_INCREMENT,
--  category  VARCHAR(20)  NOT NULL,
--  kind      VARCHAR(30)  NOT NULL,
--  UNIQUE (category, kind)
--);
--
---- 3) Matériel (simplifié : pas de purchase_date ni notes)
--CREATE TABLE IF NOT EXISTS device (
--  id             BIGINT PRIMARY KEY AUTO_INCREMENT,
--  asset_tag      VARCHAR(50) UNIQUE,         -- étiquette interne (optionnel)
--  serial_number  VARCHAR(100) UNIQUE,        -- n° de série constructeur
--  brand          VARCHAR(50),
--  model          VARCHAR(80),
--  type_id        BIGINT NOT NULL,
--  status         VARCHAR(20) NOT NULL DEFAULT 'IN_STOCK',  -- IN_STOCK, ASSIGNED, REPAIR, RETIRED
--  CONSTRAINT fk_device_type  FOREIGN KEY (type_id) REFERENCES device_type(id)
--);
--
---- 4) Historique d’attribution
--CREATE TABLE IF NOT EXISTS assignment (
--  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
--  device_id    BIGINT NOT NULL,
--  employee_id  BIGINT NOT NULL,
--  assigned_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
--  returned_at  DATETIME NULL,
--  CONSTRAINT fk_asg_device   FOREIGN KEY (device_id)   REFERENCES device(id),
--  CONSTRAINT fk_asg_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
--);
--


CREATE DATABASE IF NOT EXISTS stock DEFAULT CHARACTER SET utf8mb4;
USE stock;


CREATE TABLE IF NOT EXISTS employee (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  unn          VARCHAR(20) NOT NULL UNIQUE,  -- numéro unique salarié
  first_name   VARCHAR(50),
  last_name    VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS assignment (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  device_id    BIGINT NOT NULL,
  employee_id  BIGINT NOT NULL,
  assigned_at  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  returned_at  DATETIME NULL,
  CONSTRAINT fk_asg_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);

