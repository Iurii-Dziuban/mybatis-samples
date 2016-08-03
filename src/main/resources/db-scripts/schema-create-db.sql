-- auto_increment is needed in order to test id auto generation by mybatis
create table transactions (
    ID int not null auto_increment,
    NAME varchar(100) not null,
);