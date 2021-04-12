INSERT INTO `users` (username, password, active, first_name, last_name, email) VALUES ('raul','$2a$10$ykhXmCAam5FUEF9GN.4Z8OwwWJidvMii6VFYe77cmS2X6oF6p4W86',1, 'Jimy', 'Castrejon','jcastrejon@gmail.com');
INSERT INTO `users` (username, password, active, first_name, last_name, email) VALUES ('admin','$2a$10$qGyDfZLBB.SgLv7GCP3uZe3oM38fVtr58T1iZ1LNOvO61loNUAAaK',1, 'Margot', 'Ruiz Garcia','mruiz@icloud.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);