create table profile (
seq int primary key,
email varchar(255) not null unique,
password varchar(15) not null,
firstname varchar(50) not null,
lastname varchar(50)
)
insert into profile values (1,'mmal@ggg.com','123','mohit','malhotra')
select * from profile where username = 'akash' and password ='123'
update profile set password = '321'
where username = 'akash'

drop table profile

use  rockfeller

select seq,email,firstname,lastname from profile


i