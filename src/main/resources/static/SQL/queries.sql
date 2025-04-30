INSERT INTO user(adress,email,lname,name,password,tel) VALUES
('California','john@example.com', 'john', 'doe', 'hashed_password_123', "+91054789214"),
('New York','jane@example.com', 'jane','smith', 'hashed_password_456', '+915874695321'),
('UTAH','bob@example.com', 'bob', 'johnson', 'hashed_password_789', +91458745126);

INSERT INTO category (name) VALUES
('Technology'),
('Voyage'),
('Food');

INSERT INTO tag(tag_name) VALUES
('programming'),
('webdev'),
('adventure'),
('recipes'),
('restaurants');

INSERT INTO post(title,content,author_id,category_id,date_pub) VALUES
('Getting Started with Python', 'Python is a great language...', 1, 1, CURRENT_TIMESTAMP),
('My Trip to Paris', 'The Eiffel Tower was amazing...', 2, 2, CURRENT_TIMESTAMP),
('Best Pizza in Town', 'Here are my top 5 pizza places...', 3, 3, CURRENT_TIMESTAMP);

INSERT INTO comment(comment,user_id,post_id) VALUES
('Great tutorial!', 2, 1),
('I prefer JavaScript', 3, 1),
('I went there last year!', 1, 2),
('Try the place on 5th street', 2, 3);

-- Insert post_tags (many-to-many relationship)
INSERT INTO post_tags (post_id, tag_id) VALUES
(1, 1), -- Python post with programming tag
(1, 2), -- Python post with webdev tag
(2, 3), -- Paris post with adventure tag
(3, 4), -- Pizza post with recipes tag
(3, 5); -- Pizza post with restaurants tag