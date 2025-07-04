CREATE TABLE addresses(
                          id int auto_increment PRIMARY KEY,
                          street varchar(255),
                          zip varchar(250),
                          city varchar(250),
                          country varchar(255),
                          creation datetime default current_timestamp

);