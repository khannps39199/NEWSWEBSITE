use NEWSWEBSITE;

INSERT INTO users (userName, email, password, isVeritify, isAdmin) VALUES
('admin', 'adminNewsWebSite@gmail.com', 'pass123', 1, 0),
('john_doe', 'john@example.com', 'pass123', 1, 0),
('jane_smith', 'jane@example.com', 'pass456', 1, 0),
('admin_user', 'admin@example.com', 'admin123', 1, 1),  -- admin user
('kevin_nguyen', 'kevin@example.com', 'kevinpass', 1, 0),
('emily_watson', 'emily@example.com', 'emilypass', 1, 0),
('michael_lee', 'michael@example.com', 'michaelpass', 1, 0),
('sara_connor', 'sara@example.com', 'sarapass', 1, 0),
('david_hoang', 'david@example.com', 'davidpass', 1, 0),
('anna_kim', 'anna@example.com', 'annapass', 0, 0),      -- not verified
('tony_stark', 'tony@example.com', 'ironman', 1, 0);
go

INSERT INTO posts (userId, title, createAt, picturesSrc, content)
VALUES
(1, 'Welcome to the News Website!', '2025-04-01', '/img/news1.jpg', 'This is our first post.'),
(2, 'Breaking News: Tech Trends 2025', '2025-04-03', '/img/tech.jpg', 'AI and robotics are booming.'),
(3, 'Admin Announcement', '2025-04-05', '/img/admin.jpg', 'Site maintenance on Sunday.');
go
INSERT INTO comments (userId, postId, comment)
VALUES
(4, 1, 'Great start!'),
(5, 1, 'Looking forward to more content.'),
(6, 2, 'Very informative post!'),
(7, 3, 'Thanks for the update.');
go
INSERT INTO likes (userId, postId)
VALUES
(4, 1),
(5, 1),
(6, 2),
(7, 3),
(1, 2);
INSERT INTO shares (userId, postId)
VALUES
(4, 1),
(5, 2),
(6, 3);

