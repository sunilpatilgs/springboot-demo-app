DROP TABLE IF EXISTS betslip;
DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  city VARCHAR(250) DEFAULT NULL
);

CREATE TABLE betslip (
  id NUMBER AUTO_INCREMENT  PRIMARY KEY,
  cu_id NUMBER,
  factor_team_a NUMBER NOT NULL,
  factor_tie NUMBER NOT NULL,
  factor_team_b NUMBER NOT NULL,
  status VARCHAR(250) DEFAULT 'CREATED'
);

ALTER TABLE betslip
    ADD FOREIGN KEY (cu_id) 
    REFERENCES customer(id);
 
INSERT INTO customer (first_name, last_name, city) VALUES
  ('Tom', 'Dangote', 'New York'),
  ('Dick', 'Gates', 'New Jersey'),
  ('Harry', 'Alakija', 'SFO');