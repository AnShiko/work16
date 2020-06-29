CREATE TABLE products (id serial, title varchar(100), price numeric(6, 2));

CREATE TABLE users (
  id                    serial,
  username              varchar(50) NOT NULL,
  password              varchar(80) NOT NULL,
  name                  varchar(100) NOT NULL,
  email                 varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  id                    serial,
  name                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  user_id               int NOT NULL,
  role_id               int NOT NULL,

  PRIMARY KEY (user_id, role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES users (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES roles (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (username, password, name, email)
VALUES
('admin','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Bob Johnson', 'bob@gmail.ru');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2);