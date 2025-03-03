CREATE TABLE car (
                      id SERIAL PRIMARY KEY,,
                      model VARCHAR(255),
                      number VARCHAR(255),
                      color VARCHAR(255)
);

CREATE TABLE driver (
                     id SERIAL PRIMARY KEY,,
                     experienceYears VARCHAR(255),
                     tripCount VARCHAR(255),
                     car_id BIGINT,
                     user_id BIGINT,
                     FOREIGN KEY(user_id) REFERENCES user(id),
                     FOREIGN KEY(car_id) REFERENCES car(id)
);

CREATE TABLE trip (
                      id SERIAL PRIMARY KEY,,
                      start_location VARCHAR(255),
                      end_location VARCHAR(255),
                      start_time DATETIME,
                      price VARCHAR(255),
                      count_free_places VARCHAR(255),
                      status VARCHAR(255),
                      car_id BIGINT,
                      FOREIGN KEY(car_id) REFERENCES car(id)
);

CREATE TABLE passenger (
                        id SERIAL PRIMARY KEY,,
                        user_id BIGINT,
                        FOREIGN KEY(user_id) REFERENCES user(id)
);
