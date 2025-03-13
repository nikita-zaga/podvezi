CREATE TABLE route (
                           id SERIAL PRIMARY KEY,
                           system_name VARCHAR(45),
                           label_name VARCHAR(45)
);

INSERT INTO route (id, system_name, label_name) VALUES (1, 'K-KC', 'Киров - К-Чепецк');
INSERT INTO route (id, system_name, label_name) VALUES (2, 'KC-K', 'К-Чепецк - Киров');

ALTER TABLE trip RENAME COLUMN route TO route_id;

ALTER TABLE trip ALTER COLUMN route_id TYPE BIGINT USING route_id::BIGINT;

ALTER TABLE trip ADD CONSTRAINT fk_trip_route FOREIGN KEY (route_id) REFERENCES route(id);
