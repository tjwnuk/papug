CREATE TABLE IF NOT EXISTS PapugUser (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    fullname VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255)
);