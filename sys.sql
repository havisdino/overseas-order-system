-- sys.db

-- **************************************************************
create table account (
    username varchar(50) primary key,
    password varchar(50),
    role varchar(20)
);

insert into account (username, password, role) values ('sales', 'a', 'salesdept');
insert into account (username, password, role) values ('oop', 'a', 'oopdept');
insert into account (username, password, role) values ('site1', 'a', 'site');
insert into account (username, password, role) values ('site2', 'a', 'site');
insert into account (username, password, role) values ('site3', 'a', 'site');
insert into account (username, password, role) values ('site4', 'a', 'site');
insert into account (username, password, role) values ('site5', 'a', 'site');
insert into account (username, password, role) values ('warehouse1', 'a', 'warehouse');
insert into account (username, password, role) values ('warehouse2', 'a', 'warehouse');
insert into account (username, password, role) values ('warehouse3', 'a', 'warehouse');
insert into account (username, password, role) values ('warehouse4', 'a', 'warehouse');
insert into account (username, password, role) values ('warehouse5', 'a', 'warehouse');
-- **************************************************************


-- **************************************************************
create table salesdept (
    id varchar(50) primary key,
    foreign key (id) references account(username)
);

insert into salesdept (id) values ('sales');
-- **************************************************************


-- **************************************************************
create table order_ (
    id varchar(50) primary key,
    salesdeptid varchar(50),
    oopdeptid varchar(50),
    datecreated varchar(50),
    description text,
    foreign key (salesdeptid) references salesdept(id),
    foreign key (oopdeptid) references oopdept(id)
);
-- **************************************************************


-- **************************************************************
create table rawmerchandise (
    code varchar(50) primary key,
    name text,
    unit text
);

insert into rawmerchandise (code, name, unit) values ('KEO502', 'Super glue', 'Tube');
insert into rawmerchandise (code, name, unit) values ('BANHBAOD9', 'Baozi', 'Baozi');
insert into rawmerchandise (code, name, unit) values ('AODAUMU', 'MU shirt', 'Shirt');
insert into rawmerchandise (code, name, unit) values ('MAMTOM', 'Shrimp sauce', 'Bottle');
insert into rawmerchandise (code, name, unit) values ('MAMTEP', 'Tiny shrimp sauce', 'Bottle');
insert into rawmerchandise (code, name, unit) values ('BUTCHIHANQUOC', 'South Korean pencil', 'Pencil');
insert into rawmerchandise (code, name, unit) values ('BUTCHITRIEUTIEN', 'North Korean pencil', 'Pencil');
insert into rawmerchandise (code, name, unit) values ('MIBOTAIWAN', 'Taiwanese beef noodle', 'Bowl');
-- **************************************************************


-- **************************************************************
create table merchandise (
    code varchar(50) primary key,
    name text,
    unit text,
    quantity int,
    deliverydate varchar(50),
    foreign key (code) references rawmerchandise(code)
);
-- **************************************************************


-- **************************************************************
create table site (
    code varchar(50) primary key,
    name varchar(50),
    daysByShip int,
    daysByAir int,
    otherInfo text,
    foreign key (code) references account(username)
);

insert into site (code, name, daysByShip, daysByAir, otherInfo) values ('site1', "Ha's site", 18, 10, 'We are selling guns');
insert into site (code, name, daysByShip, daysByAir, otherInfo) values ('site2', "Duc's site", 10, 8, 'We are selling nothing');
insert into site (code, name, daysByShip, daysByAir, otherInfo) values ('site3', "Gia Anh's site", 20, 10, 'We are selling our hearts');
insert into site (code, name, daysByShip, daysByAir, otherInfo) values ('site4', "Hoang's site", 18, 5, 'We are selling what you buy');
insert into site (code, name, daysByShip, daysByAir, otherInfo) values ('site5', "Hiew's site", 18, 10, 'We are forced to a site');
-- **************************************************************


-- **************************************************************
create table site_merchandise (
    sitecode varchar(50),
    mercode varchar(50),
    quantity int,
    primary key (sitecode, mercode),
    foreign key (sitecode) references site(code),
    foreign key (mercode) references rawmerchandise(code)
);
-- **************************************************************


-- **************************************************************
create table order_merchandise (
    orderid varchar(50),
    mercode varchar(50),
    primary key (orderid, mercode)
);
-- **************************************************************


-- **************************************************************
create table warehouse (
    id varchar(50) primary key,
    salesdeptid varchar(50),
    foreign key (salesdeptid) references salesdept(id)
);
-- **************************************************************


-- **************************************************************
create table ordercheck (
    id varchar(50) primary key,
    result varchar(20),
    datecreated varchar(20),
    foreign key (id) references order_(id)
);
-- **************************************************************


-- **************************************************************
create table ordercheck_merchandise (
    ordercheckid varchar(50),
    mercode varchar(50),
    primary key (ordercheckid, mercode),
    foreign key (ordercheckid) references ordercheck(id),
    foreign key (mercode) references merchandise(code)
);
-- **************************************************************


-- **************************************************************
create table oopdept (
    id varchar(50) primary key,
    foreign key (id) references account(username)
);
-- **************************************************************


-- **************************************************************
create table oopdept_order (
    oopdeptid varchar(50),
    orderid varchar(50),
    primary key (oopdeptid, orderid),
    foreign key (oopdeptid) references oopdept(id),
    foreign key (orderid) references order_(id)
);
-- **************************************************************


-- **************************************************************
create table tempcancelledorder (
    orderid varchar(50) primary key,
    foreign key (orderid) references order_(id)
);

create table cancelledorder (
    orderid varchar(50) primary key,
    foreign key (orderid) references order_(id)
);
-- **************************************************************
