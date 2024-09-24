insert into roles(role)
values ('TEACHER'),
       ('ADMIN');

insert into users(name, surname, patronymic, email, password, enabled, token)
VALUES('Канат', 'Cыдыков', 'ХЗ', 'kanat@gail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true, '123456789');

insert into user_roles(user_id, role_id) VALUES (2, 2);

insert into audiences_type(name)
values ('Компьютерная'),
       ('Лекционная'),
       ('Обычная')