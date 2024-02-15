INSERT INTO users (username, password, enabled) VALUES ('admin', '12345', '1');
INSERT INTO users (username, password, enabled) VALUES ('user', '12345', '1');
INSERT INTO authorities(username, authority) VALUES ('admin', 'admin');
INSERT INTO authorities(username, authority) VALUES ('user', 'write');

INSERT INTO customer (email, pwd, `role`) VALUES ('admin@email.com', '$2a$12$.nwOhO69Nlj1sVf18GcavOcR/xOzqMiXKWsktOuLagsgPO31pRQLW', 'admin');