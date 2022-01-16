1,创建乐豆库
//创建库
create database if not exists ledou default charset utf8;
//删除库
drop database if exists ledou;

1，手机用户表
//删除手机用户表
drop table t_phoneUser;



create table t_phoneUser(
t_phoneNo varchar(12) primary key,
t_userName varchar(30) ,
t_sex char(2),
t_address varchar(30),
t_phoneMony double ,
t_time date
)engine = Innodb;

//删除手机用户表
drop table t_phoneUser;

//插入数据
insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) 
values('1575583966','hexu','男','njwangbo',100,'2016-08-28');

insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) 
values('157558397','hexu','男','njwangbo',100,'2016-08-28');
//查询手机用户表
select t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time from t_phoneUser 

select t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time from t_phoneUser where t_phoneNo = ? 
select t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time from t_phoneUser where t_phoneNo = '15755843966';

2,乐豆用户表


create table t_leDouUser(
t_phoneNo char(11) primary key,
t_pwd varchar(15) ,
t_phoneMony double ,
t_leDouMony double ,
t_registTime date 
)engine = Innodb;

//按号码查询
select t_phoneNo,t_pwd,t_phoneMony,t_leDouMony,t_registTime from t_leDouUser where t_phoneNo = '15755843966';
//插入数据
insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) values(?,?,?,?,now()
insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) values('admin','admin',0,0,now())
insert into t_leDouUser(t_phoneNo ,t_pwd,t_phoneMony,t_leDouMony,t_registTime) values('11111111111','123456',100,100,now())

//修改用户信息
update t_leDouUser set t_phoneMony = ?,t_leDouMony = ? where t_phoneNo = ?
update t_leDouUser set t_phoneMony = 50,t_leDouMony = 50 where t_phoneNo = '11111111111';

sql	"insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) values(?,?,?,?,?,?)" (id=48)	
insert into t_phoneUser (t_phoneNo,t_userName,t_sex,t_address,t_phoneMony,t_time) values('12345678900','测试','男','',0,now())

JdbcTemplate.excuteUpdate(sql, );

insert into t_leDouUser(t_phoneNo ,t_pwd,t_phone,t_leDouMony,t_registTime) value' at line 1

3,游戏表


create table t_game(
t_id int auto_increment primary key,
t_gameName varchar(30) ,
t_gameInfo varchar(50),
t_type int,
t_phonePrice double ,
t_ledouPrice double ,
t_createTime date
)engine = Innodb;
//删除游戏表
drop table t_phoneUser;
//创建外键
alter table t_game
add constraint fk_type
foregin key(t_type) references t_gameType(t_id)

//查询游戏表
select t_id,t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime from t_game where t_id = 1;
 
//插入游戏
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('愤怒的小鸟','拯救鸟宝宝','休闲类',5,10,now());
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('cf','快来开始吧','射击类',10,30,now());
insert into t_game(t_gameName,t_gameInfo,t_type,t_phonePrice,t_ledouPrice,t_createTime)
values('围棋','黑白的世界','益智类',10,30,now());
//删除游戏根据id
delete from t_game where t_id = 3;
//修改游戏
update t_game set t_gameName =?,t_gameInfo = ?,t_type = ?,t_phonePrice = ?,t_ledouPrice = ?,t_createTime = now()  where t_id = ?
		Game game = new Game();
		game.setGameName("王者荣耀");
		game.setGameInfo("挺有意思");
		game.setGameType("竞技类");
		game.setPhonePrice(50);
		game.setLedouPrice(30);

//查询游戏信息 连接查询查所有
select e1.t_id,e1.t_gameName,e1.t_gameInfo,e2.t_type,e1.t_phonePrice,e1.t_ledouPrice,e1.t_createTime from t_game e1
            inner join t_gameType e2
            on e1.t_type = e2.t_id;
//更句id查询单个
select e1.t_id,e1.t_gameName,e1.t_gameInfo,e2.t_type,e1.t_phonePrice,e1.t_ledouPrice,e1.t_createTime from t_game e1
            inner join t_gameType e2
            on e1.t_type = e2.t_id and e1.t_id = 4;


4,游戏类别表
t_gameType


create table t_gameType(
t_id int auto_increment primary key,
t_type varchar(30) ,
t_createTime date
)engine = Innodb;


select t_id ,t_type ,t_createTime from t_gameType where t_id = 1;


//插入射击类
//插入益智类
//插入竞技类
insert into t_gameType (t_type,t_createTime) values( '射击类',now());

insert into t_gameType (t_type,t_createTime) values( '益智类',now());

insert into t_gameType (t_type,t_createTime) values( '竞技类',now());

//修改
update t_gameType
set t_type = '单机类' , t_createTime = now() where t_id  = 1;

5,记录表

drop table t_trade;
desc t_trade;


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
//查询记录更据号码
select t_phoneNo,t_gameName,t_payType,t_money,t_ledou,t_addLedou,t_downLoadTime from t_trade where t_phoneNo = '11111111111'

insert into t_trade( t_phoneNo,t_gameName,t_payType,t_money,t_ledou,t_addLedou,t_downLoadTime ) 
values('15755843966','四川麻将','乐豆支付',10,0,50,now())



6,兑换规则表

create table t_changeMethod(

t_biLi int primary key 

)engine = Innodb;

select t_bili from t_changeMethod;

update t_changeMethod
set t_bili = 20;

insert into  t_changeMethod ( t_biLi ) values(10);






