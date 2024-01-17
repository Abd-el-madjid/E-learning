Create database elearning3 ;
use elearning3;


create table users(
 user_id int primary key not null AUTO_INCREMENT,
user_email varchar(40) not null ,

user_firstname varchar(40) not null,
user_lastname varchar(40) not null,

user_password varchar(40) not null,
user_type varchar(40) not null	,
user_sex varchar(40)  null	,
 UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC)
);


INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('madjidkah@gmail.com', 'abd el madjid', 'kahoul', 'mad_k', 'admin', 'MALE');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('mariembel@gmail.com', 'meriem', 'belgidoum', 'meriembel', 'teacher', 'Female');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('marabetsma@gmail.com', 'smail', 'mrabet', 'mrabetsma', 'teacher', 'MALE');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('hanankabi@gmail.com', 'hanan', 'kabi', 'aziztab', 'etudiant', 'MALE');


INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('fayrouz@gmail.com', 'fayrouz', 'hanachi', 'fay', 'teacher', 'Female');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('soumia@gmail.com', 'soumia', 'amari', 'soum', 'teacher', 'Female');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('bounak@gmail.com', 'maria', 'bounaka', 'maria', 'teacher', 'Female');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('lechhab@gmail.com', 'mohamed', 'lechhab', 'moh', 'teacher', 'MALE');
INSERT INTO `elearning3`.`users` (`user_email`, `user_firstname`, `user_lastname`, `user_password`, `user_type`, `user_sex`) VALUES ('lekhdarazak@gmail.com', 'zak', 'khdara', 'zak', 'teacher', 'MALE');


ALTER TABLE users
ADD CONSTRAINT CHECK_User_Type
CHECK (user_type='etudiant' OR user_type='teacher' OR user_type='admin') ;
ALTER TABLE users
ADD CONSTRAINT CHECK_User_SEX
CHECK (user_sex='Autre' OR user_sex='Female' OR user_sex='MALE' ) ;


ALTER TABLE elearning3.users 
ADD CONSTRAINT CHECK_User_Email
CHECK  (user_email REGEXP '^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9._-]*\\.[a-zA-Z]{2,4}$');


create table specialte(
 id_specialte int  not null AUTO_INCREMENT,
name varchar(10) ,
 primary key (id_specialte,name),
 UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L1 MI');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L2 MI');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L3 GL');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L3 TI');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L3 SCI');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('L3 SI');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M1 GL');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M2 GL');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M1 SITW');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M2 SITW');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M1 STIC');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M2 STIC');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M1 RSD');
INSERT INTO `elearning3`.`specialte` (`name`) VALUES ('M2 RSD');


Create table modules (
 id_module int  not null AUTO_INCREMENT,
name varchar(10)  not null ,
specialte int,
 primary key (id_module,name),
foreign key (specialte) references specialte( id_specialte)  ON DELETE CASCADE,

  INDEX `name_UNIQUE` (`name` ASC)
);

INSERT INTO `elearning3`.`modules` (`name`, `specialte`) VALUES ('TL', 2);

INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAC', 3);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('GL2', 3);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAAW', 3);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('TQL', 3);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('GPL', 3);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('TABD', 3);

INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('BD2', '4');
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAW2', 4);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('TEC', 4);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('TAM', 4);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('ACS', 4);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAM', 4);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('RS', 4);

INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('SI', '5');
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('RI', 5);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('RO', 5);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('SE2', 5);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('BD2', 5);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('COM', 5);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('GL2', 5);

INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('GPI', '6');
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('BD2', 6);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAC', 6);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('DAW2', 6);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('POA', 6);
INSERT INTO `elearning3`.modules (`name`, `specialte`) VALUES ('OMC', 6);



create table teacher_modules(
	user_id int ,
    modules int ,
   
    primary key (user_id,modules),
    foreign key (user_id) references users(user_id)  ON DELETE CASCADE ,
    foreign key (modules) references modules(id_module)  ON DELETE CASCADE
   
);


Create table teaching_semain (
	id_semain int not null AUTO_INCREMENT ,
    modules int,
    semain_debut date,
    semain_fin date,
     primary key (id_semain,modules),
    foreign key (modules) references modules(id_module)  ON DELETE CASCADE
);
ALTER TABLE teaching_semain
ADD CONSTRAINT CHK_DATE
  CHECK ((Date(semain_debut)<Date(semain_fin)));
delimiter $$
create trigger verifie_semain before insert 
on teaching_semain
for each row 
BEGIN 

if((select count(id_semain) from teaching_semain where  modules = new.modules and
    semain_debut = new.semain_debut and 
    semain_fin =new.semain_fin)>0)then signal sqlstate '45000'
set message_text ='insertion  impossible  deplucate semain pour  module ';
end if;
end $$




create table module_Cour (
id_cour int primary key AUTO_INCREMENT,
	cour_lien varchar(300) ,
    cour_name varchar(100),
    cour_pdf   longblob,
    modules int,
    teaching_semain int ,
    foreign key (teaching_semain) references teaching_semain(id_semain)  ON DELETE CASCADE,
        foreign key (modules) references modules(id_module)  ON DELETE CASCADE
);

create table module_TD (
id_td int primary key AUTO_INCREMENT,
	td_lien varchar(300),
   td_name varchar(100), 
  td_pdf   longblob,
  td_type varchar(50),
    modules int,
    teaching_semain int ,
    foreign key (teaching_semain) references teaching_semain(id_semain)  ON DELETE CASCADE,
        foreign key (modules) references modules(id_module)  ON DELETE CASCADE
);

create table module_TP (
id_tp int primary key AUTO_INCREMENT,
	tp_lien varchar(300),
    tp_name varchar(100),
    tp_pdf   longblob ,
   tp_type varchar(50),
    modules int,
    teaching_semain int ,
    foreign key (teaching_semain) references teaching_semain(id_semain)  ON DELETE CASCADE,
        foreign key (modules) references modules(id_module) ON DELETE CASCADE
);

create table etudiant_specialtes(
	user_id int ,
   specialte int,
  
    primary key (user_id,specialte),
    foreign key (user_id) references users(user_id)  ON DELETE CASCADE ,
   foreign key (specialte) references specialte(id_specialte)  ON DELETE CASCADE

);


create table module_info (
	teaching_semain int ,
    modules int,
    descriptionInfo varchar(300),
     primary key (teaching_semain,modules),
    foreign key (teaching_semain) references teaching_semain(id_semain)  ON DELETE CASCADE,
    foreign key (modules) references modules(id_module)  ON DELETE CASCADE
);
