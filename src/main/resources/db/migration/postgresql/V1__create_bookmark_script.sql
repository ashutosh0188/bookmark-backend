CREATE TABLE bookmark (
    id bigint not null,
    title varchar(255),
    url varchar(255),
    created_at timestamp,
    primary key (id)
);

INSERT INTO bookmark(id, title, url, created_at) VALUES (1, 'test1', 'http://localhost1', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (2, 'test2', 'http://localhost2', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (3, 'test3', 'http://localhost3', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (4, 'test4', 'http://localhost4', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (5, 'test5', 'http://localhost5', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (6, 'test6', 'http://localhost6', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (7, 'test7', 'http://localhost7', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (8, 'test8', 'http://localhost8', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (9, 'test9', 'http://localhost9', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (10, 'test10', 'http://localhost10', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (11, 'test11', 'http://localhost11', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (12, 'test12', 'http://localhost12', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (13, 'test13', 'http://localhost13', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (14, 'test14', 'http://localhost14', current_timestamp);
INSERT INTO bookmark(id, title, url, created_at) VALUES (15, 'test15', 'http://localhost15', current_timestamp);