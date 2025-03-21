CREATE TABLE addresses
(
    id      BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    street  VARCHAR(255),
    city    VARCHAR(255),
    zip     VARCHAR(255),
    state   VARCHAR(255),
    user_id BIGINT,
    CONSTRAINT pk_addresses PRIMARY KEY (id)
);

CREATE TABLE categories
(
    id   SMALLINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE products
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    price       DECIMAL,
    category_id SMALLINT,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE profiles
(
    id             BIGINT NOT NULL,
    bio            VARCHAR(255),
    phone_number   VARCHAR(255),
    date_of_birth  date,
    loyalty_points INTEGER,
    CONSTRAINT pk_profiles PRIMARY KEY (id)
);

CREATE TABLE tags
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_tags PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE wishlist
(
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    CONSTRAINT pk_wishlist PRIMARY KEY (product_id, user_id)
);

ALTER TABLE addresses
    ADD CONSTRAINT FK_ADDRESSES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);

ALTER TABLE profiles
    ADD CONSTRAINT FK_PROFILES_ON_ID FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_product FOREIGN KEY (product_id) REFERENCES products (id);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_user FOREIGN KEY (user_id) REFERENCES users (id);