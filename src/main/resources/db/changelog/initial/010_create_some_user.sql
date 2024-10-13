insert into roles(role)
values ('TEACHER'),
       ('ADMIN');

insert into users(name, surname, patronymic, email, password, enabled, token)
VALUES('Канат', 'Cыдыков', 'Кадырбекович', 'kanat@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, '123456789'),
('Арген', 'Ашимов', 'Чынгызбекович', 'retreatpm@icloud.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, '123456789');

insert into user_roles(user_id, role_id) VALUES (1, 2),
                                                (2, 1);

insert into audiences_type(name)
values ('Компьютерная'),
       ('Лекционная'),
       ('Обычная')