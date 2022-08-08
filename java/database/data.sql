BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, email_address, phone_number)
    VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'User', 'User', 'user@techelevator.com', '555-5555');
INSERT INTO users (username,password_hash,role, first_name, last_name, email_address, phone_number)
    VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Admin', 'Admin', 'admin@techelevator.com', '555-5555');

INSERT INTO customers(customer_id, user_id) VALUES (1, 1);

INSERT INTO vehicles(vehicle_id, customer_id, make, model, year, color) VALUES (1, 1, 'Honda', 'Accord', '2012', 'blue');

INSERT INTO requests (request_id, customer_id, vehicle_id, description) VALUES (1, 1, 1, 'my car is broke');

COMMIT TRANSACTION;
