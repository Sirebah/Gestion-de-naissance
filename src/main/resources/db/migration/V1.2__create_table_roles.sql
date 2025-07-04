-- Creation de la table roles
CREATE TABLE roles(
    id int auto_increment primary key,
    name varchar(255),
    description text,
    creation datetime default current_timestamp

);

ALTER table roles
add constraint name_is_unique unique (name);

-- Insertion des rôles de la table

insert into roles(name) values
                            ('PUBLIC'),
                            ('AGENT'),
                            ('ADMINISTRATOR');



