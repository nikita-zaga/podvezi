-- Создание таблицы для хранения токенов
CREATE TABLE auth_tokens
(
    id         SERIAL PRIMARY KEY,
    token      TEXT NOT NULL UNIQUE,
    username   TEXT NOT NULL,
    expires_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);
