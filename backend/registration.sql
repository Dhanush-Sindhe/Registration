CREATE TABLE internassesment.registration (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  dob DATE NOT NULL,
  phonenum VARCHAR(45) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE); 
