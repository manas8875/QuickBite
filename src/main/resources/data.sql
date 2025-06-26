INSERT INTO restaurants (name, location, cuisine_type, rating) VALUES
('Spicy Treat', 'Delhi', 'Indian', 4.3),
('Pasta Palace', 'Mumbai', 'Italian', 4.5),
('Sakura Sushi', 'Bangalore', 'Japanese', 4.7);

INSERT INTO menu_items (name, description, price, restaurant_id) VALUES
('Paneer Tikka', 'Grilled paneer', 220.00, 1),
('Chicken Curry', 'Spicy chicken curry', 270.00, 1),
('Butter Naan', 'Soft naan', 40.00, 1),
('Penne Alfredo', 'Creamy pasta', 260.00, 2),
('Garlic Bread', 'Toasted garlic bread', 90.00, 2),
('Tiramisu', 'Coffee dessert', 180.00, 2),
('Salmon Sushi', 'Fresh sushi roll', 300.00, 3),
('Miso Soup', 'Soy soup', 100.00, 3),
('Tempura', 'Crispy fried shrimp', 250.00, 3);

INSERT INTO users (name, email, password, role) VALUES
('Manas Raj', 'manas@example.com', 'pass123', 'user'),
('Ravi Kumar', 'ravi@example.com', 'pass456', 'user'),
('Priya Sharma', 'priya@example.com', 'pass789', 'user'),
('Ankit Verma', 'ankit@example.com', 'pass101', 'user'),
('Neha Joshi', 'neha@example.com', 'pass202', 'user');