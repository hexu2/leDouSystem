drop database if exists ledou;
create database if not exists ledou default charset utf8;
use ledou;

-----------手机用户表------------------
drop table t_phoneUser;
create table t_phoneUser(
t_phoneNo varchar(12) primary key,
t_userName varchar(30) ,
t_sex char(2),
t_address varchar(30),
t_phoneMony double ,
t_time date
)engine = Innodb;
insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) 
values('1575583966','hexu','男','njwangbo',100,'2016-08-28');
insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) 
values('157558397','hexu','男','njwangbo',100,'2016-08-28');

-----------------------乐豆用户表-----------------------------
drop table t_leDouUser;
create table t_leDouUser(
t_phoneNo char(11) primary key,
t_pwd varchar(15) ,
t_phoneMony double ,
t_leDouMony double ,
t_registTime date 
)engine = Innodb;
insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) 
values('admin','admin',0,0,now());
insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) 
values('123456','123456',100,100,now());

----------------------游戏表-----------------------------------
drop table t_game;
create table t_game(
t_id int auto_increment primary key,
t_gameName varchar(30) ,
t_gameInfo varchar(50),
t_type int,
t_phonePrice double ,
t_ledouPrice double ,
t_createTime date
)engine = Innodb;
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('愤怒的小鸟','拯救鸟宝宝','休闲类',5,10,now());
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('cf','快来开始吧','射击类',10,30,now());
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('围棋','黑白的世界','益智类',10,30,now());


-----------------------游戏类别表-------------------------
drop table t_gameType;
create table t_gameType(
t_id int auto_increment primary key,
t_type varchar(30) ,
t_createTime date
)engine = Innodb;
insert into t_gameType (t_type,t_createTime) values( '射击类',now());
insert into t_gameType (t_type,t_createTime) values( '益智类',now());
insert into t_gameType (t_type,t_createTime) values( '休闲类',now());


---------------------记录表-----------------------------------
drop table t_trade;
create table t_trade(
t_id int auto_increment primary key,
t_phoneNo char(11) not null,
t_gameName varchar(30) ,
t_payType varchar(30),
t_money double ,
t_ledou double,
t_addLedou double,
t_downLoadTime date 
)engine = Innodb;

-----------------兑换规则表----------------------
drop table t_changeMethod;
create table t_changeMethod(
t_biLi int primary key 
)engine = Innodb;
insert into t_changeMethod (t_biLi ) 
values(10);






