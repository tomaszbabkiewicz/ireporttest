CREATE DATABASE elerning WITH TEMPLATE = template0 ENCODING = 'UTF8';

ALTER DATABASE elerning OWNER TO root;

/* Table structure */

CREATE TABLE "role" (
 role_id SERIAL NOT NULL,
 name VARCHAR(32),  
 CONSTRAINT role_pk PRIMARY KEY (role_id)
);

CREATE TABLE "person" (
 person_id SERIAL NOT NULL,
 role_id INTEGER NOT NULL,
 login VARCHAR(32),
 password VARCHAR(32),
 CONSTRAINT person_pk PRIMARY KEY (person_id),
 CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES role(role_id)
);

/* Sample data */

INSERT INTO role (name) values ('ADMIN');
INSERT INTO role (name) values ('NORMAL');

INSERT INTO person (role_id, login, password) values (1, 'admin', 'admin');
INSERT INTO person (role_id, login, password) values (2, 'user', 'user'); 