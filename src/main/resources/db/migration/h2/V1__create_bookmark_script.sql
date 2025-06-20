CREATE TABLE bookmark (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    url VARCHAR(255),
    created_at TIMESTAMP
);

INSERT INTO bookmark(id, title, url, created_at) VALUES (1, 'test1', 'http://localhost1', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (2, 'test2', 'http://localhost2', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (3, 'test3', 'http://localhost3', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (4, 'test4', 'http://localhost4', current_timestamp());
INSERT INTO bookmark(id, title, url, created_at) VALUES (5, 'test5', 'http://localhost5', current_timestamp());

-- To avoid conflicts for hibernate. Since hibernate is not aware about the above 5 records
ALTER TABLE bookmark ALTER COLUMN id RESTART WITH 6;