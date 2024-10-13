insert into roles(role)
values ('TEACHER'),
       ('ADMIN');

insert into users(name, surname, patronymic, email, password, enabled, token)
VALUES('Канат', 'Cыдыков', 'Кадырбекович', 'kanat@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, '123456789'),
('Арген', 'Ашимов', 'Чынгызбекович', 'retreatpm@icloud.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, '123456789'),
('', '', '', 'maksatkanybekov2004@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, null),
      ('', '', '', 'comtehno.kg@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, null)
    ('', '', '', 'asanovkurmanbek342@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, null)
('', '', '', 'malabakievramzan@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, null),
('', '', '', 'malabakievramzan@gmail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, null);



insert into user_roles(user_id, role_id) VALUES (1, 2),
                                                (2, 2),
                                                (3, 2),
                                                (4, 2),
                                                (5, 2),
                                                (6, 2),
                                                (7, 2);

insert into audiences_type(name)
values ('Компьютерная'),
       ('Лекционная'),
       ('Обычная')