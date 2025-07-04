create table permissions(
    id int auto_increment primary key,
    name varchar(255),
    description text,
    creation datetime default current_timestamp
);

alter table permissions
add constraint name_is_unique unique (name);

insert into permissions(name)
values
    ('AGENT_CREATE'),
    ('AGENT_READ'),
    ('AGENT_UPDATE'),
    ('AGENT_DELETE'),

    ('ADMINISTRATOR_CREATE'),
    ('ADMINISTRATOR_READ'),
    ('ADMINISTRATOR_UPDATE'),
    ('ADMINISTRATOR_DELETE'),

    ('PUBLIC_CREATE'),
    ('PUBLIC_READ'),
    ('PUBLIC_UPDATE'),
    ('PUBLIC_DELETE'),

    ('PROFILE_CREATE'),
    ('PROFILE_READ'),
    ('PROFILE_UPDATE'),
    ('PROFILE_DELETE'),

    ('DECLARATION_CREATE'),
    ('DECLARATION_READ'),
    ('DECLARATION_UPDATE'),
    ('DECLARATION_DELETE'),

    ('REQUEST_CREATE'),
    ('REQUEST_READ'),
    ('REQUEST_UPDATE'),
    ('REQUEST_DELETE');





