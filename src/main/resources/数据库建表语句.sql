########################新建表###########################################
-------------------------------------------
-- Export file for user LOANMALL         --
-- Created by 彭正锋 on 2017/9/30, 13:46:17 --
-------------------------------------------

set define off
spool madman.log

prompt
prompt Creating table TB_SYS_MENU
prompt ==========================
prompt
create table LOANMALL.TB_SYS_MENU
(
  menu_code    VARCHAR2(20) not null,
  menu_name    VARCHAR2(40),
  menu_desc    VARCHAR2(200),
  menu_url     VARCHAR2(200),
  up_menu_code VARCHAR2(20),
  menu_level   VARCHAR2(2),
  status       VARCHAR2(2)
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_MENU
  is '菜单';
comment on column LOANMALL.TB_SYS_MENU.menu_code
  is '菜单ID';
comment on column LOANMALL.TB_SYS_MENU.menu_name
  is '菜单名称';
comment on column LOANMALL.TB_SYS_MENU.menu_desc
  is '菜单描述';
comment on column LOANMALL.TB_SYS_MENU.menu_url
  is '菜单URL';
comment on column LOANMALL.TB_SYS_MENU.up_menu_code
  is '上级菜单ID';
comment on column LOANMALL.TB_SYS_MENU.menu_level
  is '菜单级别';
comment on column LOANMALL.TB_SYS_MENU.status
  is '状态  1--有效，0--无效';
alter table LOANMALL.TB_SYS_MENU
  add primary key (MENU_CODE)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_ROLE
prompt ==========================
prompt
create table LOANMALL.TB_SYS_ROLE
(
  roleid   NUMBER(10) not null,
  rolename VARCHAR2(30)
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_ROLE
  is '角色';
comment on column LOANMALL.TB_SYS_ROLE.roleid
  is '角色ID';
comment on column LOANMALL.TB_SYS_ROLE.rolename
  is '角色名称';
alter table LOANMALL.TB_SYS_ROLE
  add primary key (ROLEID)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_ROLE_MENU
prompt ===============================
prompt
create table LOANMALL.TB_SYS_ROLE_MENU
(
  roleid    NUMBER(10) not null,
  menu_code VARCHAR2(20) not null
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_ROLE_MENU
  is '角色和菜单关系';
comment on column LOANMALL.TB_SYS_ROLE_MENU.roleid
  is '角色ID';
comment on column LOANMALL.TB_SYS_ROLE_MENU.menu_code
  is '菜单ID';
alter table LOANMALL.TB_SYS_ROLE_MENU
  add primary key (ROLEID, MENU_CODE)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER
prompt ==========================
prompt
create table LOANMALL.TB_SYS_USER
(
  userid    NUMBER(10) not null,
  loginname VARCHAR2(20),
  password  VARCHAR2(50),
  realname  VARCHAR2(20),
  mobilno   VARCHAR2(11),
  mail      VARCHAR2(50),
  reg_date  VARCHAR2(8),
  status    VARCHAR2(2)
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_USER
  is '用户';
comment on column LOANMALL.TB_SYS_USER.userid
  is '用户ID';
comment on column LOANMALL.TB_SYS_USER.loginname
  is '登录名';
comment on column LOANMALL.TB_SYS_USER.password
  is '登录密码';
comment on column LOANMALL.TB_SYS_USER.realname
  is '真实名称';
comment on column LOANMALL.TB_SYS_USER.mobilno
  is '手机号码';
comment on column LOANMALL.TB_SYS_USER.mail
  is '邮箱';
comment on column LOANMALL.TB_SYS_USER.reg_date
  is '注册日期';
comment on column LOANMALL.TB_SYS_USER.status
  is '状态  1--有效，0--无效';
alter table LOANMALL.TB_SYS_USER
  add primary key (USERID)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER_OPER_LOG
prompt ===================================
prompt
create table LOANMALL.TB_SYS_USER_OPER_LOG
(
  oper_id      NUMBER(12) not null,
  userid       NUMBER(10),
  oper_type    VARCHAR2(30),
  oper_desc    VARCHAR2(200),
  oper_time    VARCHAR2(14),
  module_name  VARCHAR2(50),
  ip_addr      VARCHAR2(30),
  action_time  VARCHAR2(30),
  oper_content VARCHAR2(255)
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_USER_OPER_LOG
  is '用户操作日志';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.oper_id
  is '操作ID';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.userid
  is '用户ID';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.oper_type
  is '操作类型';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.oper_desc
  is '操作描述';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.oper_time
  is '操作时间';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.module_name
  is '模块名';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.ip_addr
  is 'Ip地址';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.action_time
  is '执行时间';
comment on column LOANMALL.TB_SYS_USER_OPER_LOG.oper_content
  is '操作内容';
alter table LOANMALL.TB_SYS_USER_OPER_LOG
  add primary key (OPER_ID)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TB_SYS_USER_ROLE
prompt ===============================
prompt
create table LOANMALL.TB_SYS_USER_ROLE
(
  roleid NUMBER(10) not null,
  userid NUMBER(10) not null
)
tablespace LOANMALL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table LOANMALL.TB_SYS_USER_ROLE
  is '用户和角色关系';
comment on column LOANMALL.TB_SYS_USER_ROLE.roleid
  is '角色ID';
comment on column LOANMALL.TB_SYS_USER_ROLE.userid
  is '用户ID';
alter table LOANMALL.TB_SYS_USER_ROLE
  add primary key (ROLEID, USERID)
  using index 
  tablespace LOANMALL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_OPERLOG_ID
prompt ================================
prompt
create sequence LOANMALL.SEQ_OPERLOG_ID
minvalue 1
maxvalue 99999999999999
start with 3152
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_MENU_ID
prompt =================================
prompt
create sequence LOANMALL.SEQ_SYS_MENU_ID
minvalue 1
maxvalue 999999999999
start with 82
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_ROLE_ID
prompt =================================
prompt
create sequence LOANMALL.SEQ_SYS_ROLE_ID
minvalue 1
maxvalue 99999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SYS_USER_ID
prompt =================================
prompt
create sequence LOANMALL.SEQ_SYS_USER_ID
minvalue 1
maxvalue 99999999999999
start with 61
increment by 1
cache 20;


spool off


########################索引###########################################
-- Create sequence 
create sequence SEQ_SYS_ROLE_ID
minvalue 1
maxvalue 99999999999999
start with 41
increment by 1
cache 20;
-- Create sequence 
create sequence SEQ_SYS_MENU_ID
minvalue 1
maxvalue 999999999999
start with 62
increment by 1
cache 20;
-- Create sequence 
create sequence SEQ_OPERLOG_ID
minvalue 1
maxvalue 99999999999999
start with 3112
increment by 1
cache 20;
-- Create sequence 
create sequence SEQ_SYS_USER_ID
minvalue 1
maxvalue 99999999999999
start with 41
increment by 1
cache 20;
