-- Создание таблицы пользователей
CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    enabled  BOOLEAN DEFAULT TRUE
);

-- Добавление индекса на username
CREATE INDEX IF NOT EXISTS idx_passengers_username ON users (username);

CREATE TABLE authorities
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    authority VARCHAR(45) NOT NULL
)

