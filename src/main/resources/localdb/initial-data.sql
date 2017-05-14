INSERT INTO RATING (id, name)
VALUES (1, 'low');
INSERT INTO RATING (id, name)
VALUES (2, 'mid');
INSERT INTO RATING (id, name)
VALUES (3, 'high');
INSERT INTO USERS (id, USERNAME, email, birthday, password, enabled) VALUES ('1', 'admin', 't@test.com' ,  CURRENT_TIMESTAMP, '1234', true);
insert into authorities(username,authority) values('admin','admin');
insert into authorities(username,authority) values('Alex','user');