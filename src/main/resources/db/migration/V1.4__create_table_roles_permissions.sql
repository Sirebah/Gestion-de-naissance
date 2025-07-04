create table roles_permissions(
    id int auto_increment primary key,
    roles_id int,
    permissions_id int,
    creation datetime default current_timestamp,

    constraint fk_roles_roles_permissions foreign key (roles_id) references roles(id),
    constraint fk_permissions_roles_permissions foreign key (permissions_id) references permissions(id),
    --constraint unique_role_and_permissions unique (roles_id, permissions_id)


);

insert into roles_permissions (roles_id, permissions_id)
values
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'AGENT_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'AGENT_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'AGENT_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'AGENT_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'ADMINISTRATOR_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'ADMINISTRATOR_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'ADMINISTRATOR_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'ADMINISTRATOR_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PUBLIC_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PUBLIC_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PUBLIC_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PUBLIC_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PROFILE_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PROFILE_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PROFILE_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'PROFILE_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'DECLARATION_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'DECLARATION_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'DECLARATION_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'DECLARATION_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'REQUEST_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'REQUEST_READ')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'REQUEST_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'ADMINISTRATOR'), (SELECT id FROM  permissions where name = 'REQUEST_DELETE')),




    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'AGENT_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'AGENT_READ')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'AGENT_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'AGENT_DELETE')),


    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PUBLIC_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PUBLIC_READ')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PUBLIC_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PUBLIC_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PROFILE_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PROFILE_READ')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PROFILE_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'PROFILE_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'DECLARATION_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'DECLARATION_READ')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'DECLARATION_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'DECLARATION_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'REQUEST_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'REQUEST_READ')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'REQUEST_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'AGENT'), (SELECT id FROM  permissions where name = 'REQUEST_DELETE')),





    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'PROFILE_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'PROFILE_READ')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'PROFILE_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'PROFILE_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'DECLARATION_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'DECLARATION_READ')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'DECLARATION_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'DECLARATION_DELETE')),

    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'REQUEST_CREATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'REQUEST_READ')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'REQUEST_UPDATE')),
    ((SELECT id FROM  roles WHERE name = 'PUBLIC'), (SELECT id FROM  permissions where name = 'REQUEST_DELETE')),



