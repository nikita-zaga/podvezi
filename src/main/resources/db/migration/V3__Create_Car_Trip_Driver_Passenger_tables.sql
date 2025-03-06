CREATE TABLE car (
                      id SERIAL PRIMARY KEY,
                      model VARCHAR(255),
                      number VARCHAR(255),
                      color VARCHAR(255)
);

CREATE TABLE driver (
                     id SERIAL PRIMARY KEY,
                     experience_years VARCHAR(255),
                     trip_count VARCHAR(255),
                     car_id BIGINT,
                     user_id BIGINT,
                     FOREIGN KEY(user_id) REFERENCES users(id),
                     FOREIGN KEY(car_id) REFERENCES car(id)
);

CREATE TABLE trip (
                      id SERIAL PRIMARY KEY,
                      route VARCHAR(255),
                      start_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                      price VARCHAR(255),
                      count_free_places VARCHAR(255),
                      status VARCHAR(255),
                      driver_id BIGINT,
                      FOREIGN KEY(driver_id) REFERENCES driver(id)
);

CREATE TABLE passenger (
                        id SERIAL PRIMARY KEY,
                        user_id BIGINT,
                        FOREIGN KEY(user_id) REFERENCES users(id)
);
