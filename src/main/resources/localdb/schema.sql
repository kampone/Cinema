CREATE SEQUENCE auditorium_sequence START WITH 100;
CREATE SEQUENCE seat_sequence START WITH 100;
CREATE SEQUENCE user_sequence START WITH 100;
CREATE SEQUENCE ticket_sequence START WITH 100;
CREATE SEQUENCE event_sequence START WITH 100;

CREATE TABLE IF NOT EXISTS RATING (
  id   INT PRIMARY KEY,
  name VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS EVENTS (
  id           INT PRIMARY KEY,
  name         VARCHAR(255),
  base_price   DECIMAL(5, 2),
  rating_id    INT,
  description  VARCHAR(255),
  picture_link VARCHAR(255),
  FOREIGN KEY (rating_id) REFERENCES RATING (id)
);
CREATE TABLE IF NOT EXISTS AUDITORIUMS (
  id   INT PRIMARY KEY,
  name VARCHAR(255) UNIQUE
);
CREATE TABLE IF NOT EXISTS SEATS (
  id            INT PRIMARY KEY,
  row           INT,
  place         INT,
  vip           BOOLEAN,
  auditorium_id INT,
  FOREIGN KEY (auditorium_id) REFERENCES AUDITORIUMS (id)
);
CREATE TABLE IF NOT EXISTS USERS (
  id       INT PRIMARY KEY,
  username     VARCHAR(255),
  password    VARCHAR(255),
  email    VARCHAR(255),
  enabled boolean,
  birthday DATE
);

CREATE TABLE IF NOT EXISTS TICKETS (
  id       INT PRIMARY KEY,
  event_id INT,
  datetime TIMESTAMP,
  seat_id  INT,
  user_id  INT,
  booked   BOOLEAN,
  FOREIGN KEY (event_id) REFERENCES EVENTS (id),
  FOREIGN KEY (seat_id) REFERENCES SEATS (id),
  FOREIGN KEY (user_id) REFERENCES USERS (id)
);

CREATE TABLE IF NOT EXISTS COUNTERS (
  event_name VARCHAR(255) PRIMARY KEY,
  name_invocation_count INT,
  book_ticket_count INT
);

CREATE TABLE IF NOT EXISTS DISCOUNT_COUNTERS (
  user_id INT PRIMARY KEY,
  birthday_strategy_count INT,
  ten_tickets_strategy_count INT
);


drop table if exists authorities;
create table authorities(username  varchar(255),authority  varchar(255), UNIQUE(username,authority));
insert into authorities(username,authority) values('user','admin');
insert into authorities(username,authority) values('john','superadmin');
