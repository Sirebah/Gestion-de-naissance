
drop table if exists profiles;
drop table if exists roles;
drop table if exists profiles;
drop table if exists addresses;


CREATE TABLE roles(
                      id int auto_increment,
                      role varchar(50) unique,
                      description text,
                      constraint my_role_primary_key primary key(id)
    -- le mot clé constraint suivi du nom de la contrainte après la contrainte puis le nom à l'intérieur

);

CREATE TABLE addresses(
                          id int auto_increment PRIMARY KEY,
                          street varchar(255),
                          zip varchar(250),
                          city varchar(250),
                          country varchar(255),
                          creation datetime default current_timestamp

);

CREATE TABLE profiles(
                         id int auto_increment,
                         first_name varchar(255),
                         last_name varchar(255),
                         phone varchar(30),
                         email varchar(100),
                         roles_id int,
                         addresses_id int,
                         creation datetime default current_timestamp,


                         primary key(id),
                         constraint profiles_mail_is_unique unique(email),
                         constraint profiles_roles_id foreign key (roles_id) references roles (id),
                         constraint profiles_addresses_id foreign key (addresses_id) references addresses (id)
);





