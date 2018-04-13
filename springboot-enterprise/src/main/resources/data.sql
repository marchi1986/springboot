insert into sys_user (id,username,password)values(1,'marchi','marchi');
insert into sys_user (id,username,password)values(2,'cyber','cyber');

insert into sys_role (id,name)values(1,'ROLE_ADMIN');
insert into sys_role (id,name)values(2,'ROLE_USER');

insert into sys_user_roles (sys_user_id,roles_id)values(1,1);
insert into sys_user_roles (sys_user_id,roles_id)values(2,2);
insert into sys_user_roles (sys_user_id,roles_id)values(1,2);

insert into sys_resource (id,name)values(1,'/security');

insert into sys_role_resources (roles_id,resources_id)values(1,1);


