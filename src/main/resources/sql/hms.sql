-- 患者表
create table hms_patient(
	id int primary key auto_increment,-- 患者id
	name varchar(20),-- 患者姓名
	sex int,-- 0 女    1男   2其他
	birth date,-- 患者生日
	idcard varchar(20),-- 患者身份证
	address varchar(100),-- 患者住址
	mobile varchar(11)-- 患者手机号
);

-- 科室表
create table hms_department(
	id int primary key auto_increment,-- 科室编号
	name varchar(50),-- 科室名称
	telephone varchar(20),-- 科室办公室电话
	area varchar(20)-- 科室所在区域
);


-- 分诊记录表
create table hms_triage(
	id int primary key auto_increment,-- id
	status int,	  -- 状态  0 等待诊断     1诊断中  2诊断结束
	illness_info varchar(500),-- 症状描述
	advice varchar(1000),-- 诊断建议
	pid varchar(36),-- 外键指向 patient表的主键
	did varchar(36),-- 科室id
	uid varchar(36) -- 医生外键，指向用户表的外键
);


-- 后台管理医生用户信息
create table hms_user(
	id int primary key auto_increment,-- id
	username varchar(20),-- 后台系统登录的用户名
	password varchar(20),-- 密码
	realname varchar(20),-- 真实姓名
	sex int,-- 0女    1男 
	birth date,-- 出生年月日
	mobile varchar(11),-- 联系电话
	email varchar(30),-- 邮箱
	pic varchar(100),-- 头像的路径
	dept_id varchar(36) -- 科室的外键，表明医生属于哪个科室
);

-- 值班表
create table hms_rota(
	id int primary key auto_increment,
	rota_date date,-- 值班日期
	did varchar(36),-- 科室外键
	uid varchar(36)-- 医生用户的id
);


-- 通知表
create table hms_notice(
	id int primary key auto_increment,
	notice_date date,-- 通知时间。
	title varchar(30),-- 标题
	content varchar(30)-- 内容
);

-- 日志表
create table hms_log(
	id int primary key auto_increment,
	type int, -- 1：登录日志    2: 诊断日志
	operator varchar(50),-- 日志操作人的真实姓名
	content varchar(100),-- 操作内容。
	log_date date
);


-- 文件信息表
create table hms_files(
       id int primary key auto_increment,
       file_name varchar(50),
	   file_path varchar(50),-- 保存路径
       save_name varchar(100),
       up_time date,-- 文件上传时间
       file_size int
);

-- 药品信息
create table hms_drug(
	id  int primary key auto_increment,
	name varchar(50),-- 药品名
	spec varchar(50),-- 规格
	unit varchar(10),-- 单位
	product_company varchar(50),-- 生产企业
	product_date date,-- 生产日期
	ok_date date,-- 保质期至
	import_price double,-- 进价
	price double,-- 零售价
	sale_status int,-- 销售状态  （0：正常销售    1：停售）
	is_import int,-- 是否是进口(0:是   1：非进口药)
	description varchar(500)-- 产品说明
);

-- 审核表
create table hms_exam(
	id int primary key auto_increment,
	exam_status int,-- 审核状态   0 ：未审核    1：审核中   2：审核通过   3：审核未通过
	exam_advice varchar(30),-- 审核意见
	exam_start_date date,-- 审核提交时间
	exam_end_date date,-- 审核结束时间
	d_id int,
	foreign key (d_id) references hms_drug(id)
);

-- 操作日志记录表
create table hms_operlog(
   oper_id int primary key auto_increment,  -- 操作id
   oper_class_name varchar(50),             -- 执行的全类名
   oper_method_name varchar(50),            -- 执行的方法名
   oper_user_id varchar(50),                -- 执行人id
   oper_time int,                           -- 操作时间差
   oper_date date,                          -- 操作日期
   oper_module varchar(50),                 -- 操作模块
   oper_type varchar(50),                   -- 操作类型
   oper_description varchar(200)            -- 操作描述
);