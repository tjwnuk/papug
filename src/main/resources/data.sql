INSERT INTO papug_post_entity (id, content, title, date)
VALUES
    (1, 'Just adopted the cutest parrot! 🐦❤️ #ParrotLove #NewFeatheredFriend', 'Meet My New Parrot Friend', '2023-06-01 00:00:00'),
    (2, 'Having a relaxing day at home with my parrot. They really know how to chill! 😎🏠 #LazyDays', 'Chilling with My Parrot Buddy', '2023-06-02 12:30:00'),
    (3, 'Teaching my parrot some new tricks today. Can''t believe how smart they are! 🦜🎩 #SmartBird', 'Training My Clever Parrot', '2023-06-03 08:15:00'),
    (4, 'Took my parrot for a walk in the park. Met so many fellow parrot enthusiasts! 🌳🐦 #ParrotCommunity', 'Parrot Park Adventure', '2023-06-04 14:45:00'),
    (5, 'Parrots make the best companions. Their cheerful chirping always brightens up my day! ☀️🎶 #HappyVibes', 'Joyful Moments with My Parrot', '2023-06-05 09:20:00'),
    (6, 'Feeling grateful for the joy my parrot brings into my life every day. 🙏🐦❤️ #GratefulPetOwner', 'Blessed with My Parrot Companion', '2023-06-06 17:10:00'),
    (7, 'Spent the afternoon teaching my parrot to mimic some funny sounds. We had a blast! 🦜🎤 #ParrotTalks', 'Teaching My Parrot to Mimic Sounds', '2023-06-07 11:55:00'),
    (8, 'Lazy Sunday spent cuddled up with my parrot and a good book. Perfect day! 📖🛋️ #LazySundayVibes', 'Cozy Reading Time with My Parrot', '2023-06-08 19:40:00'),
    (9, 'Took my parrot to a pet-friendly cafe today. They were the center of attention! 🐦☕ #ParrotStar', 'Parrot''s Cafe Adventure', '2023-06-09 06:25:00'),
    (10, 'Parrot playtime is the highlight of my day. Their energy is contagious! 🐦🎾 #PlayfulParrot', 'Fun and Games with My Parrot', '2023-06-10 13:50:00'),
    (11, 'Celebrating my parrot''s birthday today. They bring so much joy to my life! 🎂🐦❤️ #ParrotBirthday', 'Happy Birthday to My Feathered Friend', '2023-06-11 02:05:00'),
    (12, 'Introduced my parrot to some new toys. Their curiosity is always so adorable to watch! 🦜🧸 #CuriousParrot', 'Exploring with My Inquisitive Parrot', '2023-06-12 10:30:00'),
    (13, 'Took my parrot to the beach. They weren''t sure about the sand, but the ocean fascinated them! 🏖️🌊 #ParrotBeachDay', 'Beach Adventure with My Parrot', '2023-06-13 18:55:00'),
    (14, 'Enjoying a movie night with my parrot. Snacks, a cozy blanket, and my feathered friend. 🍿📽️🐦 #MovieNight', 'Cozy Movie Night with My Parrot', '2023-06-14 07:20:00'),
    (15, 'Started clicker training with my parrot today. It''s amazing how fast they pick up new things! 🦜🖱️ #ClickerTraining', 'Clicker Training Progress with My Parrot', '2023-06-15 15:45:00'),
    (16, 'Morning cuddle sessions with my parrot are the best way to start the day. 🌅🐦❤️ #MorningBonding', 'Starting the Day with My Parrot', '2023-06-16 03:10:00'),
    (17, 'Attended a local pet expo with my parrot. They made lots of new friends! 🐾🐦❤️ #PetExpo', 'Parrot''s Day Out at the Pet Expo', '2023-06-17 10:35:00'),
    (18, 'Caught my parrot trying to have a conversation with their reflection today. Silly and adorable! 🦜🪞 #FunnyParrot', 'Amusing Encounters with My Parrot', '2023-06-18 18:00:00'),
    (19, 'Introduced my parrot to a puzzle toy. Watching them solve it was impressive and entertaining! 🦜🧩 #ParrotPuzzle', 'Parrot''s Puzzle-Solving Adventure', '2023-06-19 04:25:00'),
    (20, 'Spent quality time in the garden with my parrot. Nature seems to captivate them! 🌼🐦 #GardenBonding', 'Garden Exploration with My Parrot', '2023-06-20 11:50:00')
    ON CONFLICT (id) DO NOTHING;

ALTER SEQUENCE papug_post_entity_id_seq RESTART 21;
ALTER TABLE papug_post_entity
ALTER COLUMN id SET DEFAULT nextval('papug_post_entity_id_seq'::regclass);

-- Insert the "ROLE_ADMIN" role into the "user_account" table (if it doesn't exist)
INSERT INTO user_account (id, username, password, role) VALUES (1, 'admin', 'pass', 'ROLE_ADMIN') ON CONFLICT (username) DO NOTHING;

-- Insert the "ROLE_USER" role into the "user_account" table (if it doesn't exist)
INSERT INTO user_account (id, username, password, role) VALUES (2, 'user', 'pass', 'ROLE_USER') ON CONFLICT (username) DO NOTHING;
INSERT INTO user_account (id, username, password, role) VALUES (3, 'alice', 'pass', 'ROLE_USER') ON CONFLICT (username) DO NOTHING;
INSERT INTO user_account (id, username, password, role) VALUES (4, 'bob', 'pass', 'ROLE_USER') ON CONFLICT (username) DO NOTHING;
