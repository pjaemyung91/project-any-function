INSERT INTO users (username, password, enabled) VALUES ('admin', '12345', '1');
INSERT INTO users (username, password, enabled) VALUES ('user', '12345', '1');
INSERT INTO authorities(username, authority) VALUES ('admin', 'admin');
INSERT INTO authorities(username, authority) VALUES ('user', 'write');

INSERT INTO customer (email, pwd, `role`) VALUES ('admin@email.com', '12345', 'admin');