CREATE TABLE USERS (
  user_id       sequence primary key,
  uname     VARCHAR(13),
  pass VARCHAR(20),
  admin INT
);

CREATE TABLE PROJECT (
  project_id          sequence primary key,
  project_owner_id    INTEGER,
  pname        VARCHAR(50),
  description VARCHAR(250), 
  goal        DOUBLE
);

CREATE TABLE IOTData (
  IOTData_id        sequence primary key,
  IOTData_owner_id       INTEGER,
  target_id       INTEGER,
  amount     DOUBLE,
  permanent BOOLEAN
);
