prompt Importing table TB_SYS_MENU...
set feedback off
set define off
insert into TB_SYS_MENU (MENU_CODE, MENU_NAME, MENU_DESC, MENU_URL, UP_MENU_CODE, MENU_LEVEL, STATUS)
values ('1', '系统管理', '系统管理', null, null, '1', '1');

insert into TB_SYS_MENU (MENU_CODE, MENU_NAME, MENU_DESC, MENU_URL, UP_MENU_CODE, MENU_LEVEL, STATUS)
values ('2', '用户管理 ', '用户管理', '/user/manager', '1', '2', '1');

insert into TB_SYS_MENU (MENU_CODE, MENU_NAME, MENU_DESC, MENU_URL, UP_MENU_CODE, MENU_LEVEL, STATUS)
values ('3', '角色管理', '角色管理', '/role/manager', '1', '2', '1');

insert into TB_SYS_MENU (MENU_CODE, MENU_NAME, MENU_DESC, MENU_URL, UP_MENU_CODE, MENU_LEVEL, STATUS)
values ('26', '菜单管理', '菜单管理', '/menu/manager', '1', '2', '1');

insert into TB_SYS_MENU (MENU_CODE, MENU_NAME, MENU_DESC, MENU_URL, UP_MENU_CODE, MENU_LEVEL, STATUS)
values ('29', '权限管理', '权限管理', '/menu/authManager', '1', '2', '1');

prompt Done.



prompt Importing table tb_sys_user...
set feedback off
set define off
insert into tb_sys_user (USERID, LOGINNAME, PASSWORD, REALNAME, MOBILNO, MAIL, REG_DATE, STATUS)
values (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '130000000', '2@qq.com', '20170519', '1');

insert into tb_sys_user (USERID, LOGINNAME, PASSWORD, REALNAME, MOBILNO, MAIL, REG_DATE, STATUS)
values (21, 'madman', 'c078c4a34d3a383671a21ddc0f5c06ce', 'madman', null, null, '20170929', '1');

prompt Done.

prompt Importing table tb_sys_role...
set feedback off
set define off
insert into tb_sys_role (ROLEID, ROLENAME)
values (41, '123123');

insert into tb_sys_role (ROLEID, ROLENAME)
values (21, 'madman');

insert into tb_sys_role (ROLEID, ROLENAME)
values (1, '管理员');

prompt Done.


prompt Importing table tb_sys_role_menu...
set feedback off
set define off
insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (1, '1');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (1, '2');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (1, '26');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (1, '29');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (1, '3');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (21, '1');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (21, '2');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (21, '26');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (21, '29');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (21, '3');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (41, '1');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (41, '2');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (41, '26');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (41, '29');

insert into tb_sys_role_menu (ROLEID, MENU_CODE)
values (41, '3');

prompt Done.



prompt Importing table tb_sys_user_role...
set feedback off
set define off
insert into tb_sys_user_role (ROLEID, USERID)
values (1, 1);

insert into tb_sys_user_role (ROLEID, USERID)
values (1, 21);

insert into tb_sys_user_role (ROLEID, USERID)
values (21, 42);

insert into tb_sys_user_role (ROLEID, USERID)
values (41, 41);

prompt Done.










