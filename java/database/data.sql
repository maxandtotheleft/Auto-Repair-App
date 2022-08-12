BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, email_address, phone_number)
    VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'User', 'User', 'user@techelevator.com', '555-5555');
INSERT INTO users (username,password_hash,role, first_name, last_name, email_address, phone_number)
    VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Admin', 'Admin', 'admin@techelevator.com', '555-5555');
INSERT INTO users (username,password_hash,role, first_name, last_name, email_address, phone_number)
    VALUES ('employee','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EMPLOYEE', 'Employee', 'Employee', 'employee@techelevator.com', '555-5555');


INSERT INTO customers(customer_id, user_id) VALUES (1, 1);
INSERT INTO customers(customer_id, user_id) VALUES (2, 2);

INSERT INTO employees(employee_id, user_id) VALUES (1, 3);

INSERT INTO vehicles(vehicle_id, customer_id, make, model, year, color) VALUES (1, 1, 'Honda', 'Accord', 2012, 'blue');
INSERT INTO vehicles(vehicle_id, customer_id, make, model, year, color) VALUES (3, 1, 'Ford', 'F150', 2018, 'black');
INSERT INTO vehicles(vehicle_id, customer_id, make, model, year, color) VALUES (2, 2, 'Toyota', 'Hilux', 1990, 'tan');


INSERT INTO requests (request_id, customer_id, vehicle_id, description) VALUES (1, 1, 1, 'my car is broke');
INSERT INTO requests (request_id, customer_id, vehicle_id, description) VALUES (2, 1, 1, 'wheels dont turn');

INSERT INTO work_orders (work_order_id, employee_id, all_completed, time_completed) VALUES (1, 1, true, '2022-08-08 01:01:01');
INSERT INTO work_orders (work_order_id, employee_id, all_completed, time_completed) VALUES (2, 1, true, '2022-08-09 01:01:01');

INSERT INTO repair_items (repair_id, work_order_id, repair_name, parts_cost, labor_cost, completed) VALUES (1, 1, 'Oil Change', 120.00, 80.00, false);
INSERT INTO repair_items (repair_id, work_order_id, repair_name, parts_cost, labor_cost, completed) VALUES (2, 1, 'Tire Rotation', 90.00, 55.00, false);

COMMIT TRANSACTION;
