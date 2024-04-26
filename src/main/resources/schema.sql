CREATE TABLE IF NOT EXISTS t_user
(
	id SERIAL PRIMARY KEY,
	lastname VARCHAR(30),
	firstname VARCHAR(30) NOT NULL,
	patronymic VARCHAR(30),
	role VARCHAR(20) DEFAULT 'Client',
	email VARCHAR UNIQUE,
	login VARCHAR UNIQUE,
	password VARCHAR
);

CREATE TABLE IF NOT EXISTS product
(
	id SERIAL PRIMARY KEY,
	article VARCHAR UNIQUE,
	name VARCHAR UNIQUE,
	price REAL NOT NULL,
	image VARCHAR,
	size VARCHAR(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS category
(
	id SERIAL PRIMARY KEY,
	name VARCHAR UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS material
(
	id SERIAL PRIMARY KEY,
	name VARCHAR UNIQUE
);

CREATE TABLE IF NOT EXISTS color
(
	id SERIAL PRIMARY KEY,
	name VARCHAR UNIQUE,
	HEX_view VARCHAR(7) UNIQUE
);

CREATE TABLE IF NOT EXISTS t_order
(
	id SERIAL PRIMARY KEY,
	user_id INT REFERENCES t_user (id),
	total_price REAL NOT NULL,
	address VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS product_category
(
	product_id INT REFERENCES product (id),
	category_id INT REFERENCES category (id),
	CONSTRAINT PK_product_category PRIMARY KEY (product_id, category_id)
);

CREATE TABLE IF NOT EXISTS product_material
(
	product_id INT REFERENCES product (id),
	material_id INT REFERENCES material (id),
	CONSTRAINT PK_product_material PRIMARY KEY (product_id, material_id)
);

CREATE TABLE IF NOT EXISTS product_order
(
	id SERIAL PRIMARY KEY,
	product_id INT REFERENCES product (id),
	order_id INT REFERENCES t_order (id),
	count SMALLINT NOT NULL CHECK(count>0),
	chosen_size VARCHAR(8) NOT NULL,
	color_id INT REFERENCES color (id)
);

CREATE TABLE IF NOT EXISTS product_color
(
	product_id INT REFERENCES product (id),
	color_id INT REFERENCES color (id),
	CONSTRAINT PK_product_color PRIMARY KEY (product_id, color_id)
);

-- SELECT * from product as p join product_order as po ON p.id=po.product_id;


CREATE SEQUENCE IF NOT EXISTS product_seq
INCREMENT 1
START 1;