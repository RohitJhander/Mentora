create table personal_profile(
id int not null auto_increment,
name varchar(255),
email varchar(255),
phone varchar(255),
gender varchar(255),
city varchar(255),
country varchar(255),
fb text,
pic text,
primary key (id),
index (email),
index (phone)
)engine=InnoDB;

create table education_profile(
education_id int not null auto_increment,
id int not null,
school varchar(255),
coaching varchar(255),
college varchar(255),
branch varchar(255),
profession varchar(255),
board varchar(255),
mains varchar(255),
advance varchar(255),
pmt varchar(255),
percentage float(4,2),
other text,
primary key (education_id),
constraint foreign key (id) references personal_profile (id)
)engine=InnoDB;