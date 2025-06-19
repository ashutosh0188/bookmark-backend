CREATE TABLE bookmark (
    id bigint not null,
    title varchar(255),
    url varchar(255),
    created_at timestamp,
    primary key (id)
);

INSERT INTO bookmark(id, title, url, created_at) VALUES (1, 'test1', 'http://localhost1', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (2, 'test2', 'http://localhost2', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (3, 'test3', 'http://localhost3', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (4, 'test4', 'http://localhost4', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (5, 'test5', 'http://localhost5', current_timestamp());