DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int, PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Monitor', 300), ('Keyboard', 5), ('Mouse', 4), ('Processor', 700), ('Memory', 200);
