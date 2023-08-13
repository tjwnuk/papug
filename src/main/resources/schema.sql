CREATE TABLE IF NOT EXISTS papug_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255),
    fullname VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255)
);