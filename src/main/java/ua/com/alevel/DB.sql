create schema IF NOT EXISTS `shop_hibernate`;


use shop_hibernate;


create table IF NOT EXISTS `category`(
`category_id` int not null auto_increment,
`category_name` varchar(50) not null,
primary key(`category_id`),
unique index `category_name_UNIQUE` (`category_name` asc) visible);


create table IF NOT EXISTS `products`(
`product_id` int not null auto_increment,
`product_name` varchar(225) not null,
`price` int not null,
`category_id` int not null,
primary key (`product_id`),
constraint `fk_category_product_id`
foreign key (`category_id`)
references `category` (`category_id`)
on delete no action
on update no action);



create table IF NOT EXISTS `users`(
`user_id` int not null auto_increment,
`first_name` varchar(50) not null,
`last_name` varchar(50) not null,
`address` varchar(50) not null,
`email` varchar(50) not null,
primary key (`user_id`))
ENGINE=InnoDB;



create table IF NOT EXISTS `orders`(
`order_id` int not null auto_increment,
`product_id` int not null,
`user_id` int not null,
`order_date` timestamp not null,
`status` varchar(50) not null default 'open',
primary key (`order_id`),
constraint `fk_user_id`
foreign key (`user_id`)
references users(user_id)
on delete no action
on update no action,
constraint `fk_product_id`
foreign key (`product_id`)
references `products`(`product_id`)
on delete no action
on update no action);

INSERT INTO product VALUES (1, "Milk", 10, 1);
INSERT INTO product VALUES (2, "Bread", 8, 2);
INSERT INTO product VALUES (3, "Eggs", 30, 3);
INSERT INTO product VALUES (4, "Potato",15,4);
INSERT INTO product VALUES (5, "Aplle", 25,5);

create schema IF NOT EXISTS `shop_hibernate`;


use shop_hibernate;


create table IF NOT EXISTS `category`(
`category_id` int not null auto_increment,
`category_name` varchar(50) not null,
primary key(`category_id`),
unique index `category_name_UNIQUE` (`category_name` asc) visible);


create table IF NOT EXISTS `products`(
`product_id` int not null auto_increment,
`product_name` varchar(225) not null,
`price` int not null,
`category_id` int not null,
primary key (`product_id`),
constraint `fk_category_product_id`
foreign key (`category_id`)
references `category` (`category_id`)
on delete no action
on update no action);



create table IF NOT EXISTS `users`(
`user_id` int not null auto_increment,
`first_name` varchar(50) not null,
`last_name` varchar(50) not null,
`address` varchar(50) not null,
`email` varchar(50) not null,
primary key (`user_id`))
ENGINE=InnoDB;



create table IF NOT EXISTS `orders`(
`order_id` int not null auto_increment,
`product_id` int not null,
`user_id` int not null,
`order_date` timestamp not null,
`status` varchar(50) not null default 'open',
primary key (`order_id`),
constraint `fk_user_id`
foreign key (`user_id`)
references users(user_id)
on delete no action
on update no action,
constraint `fk_product_id`
foreign key (`product_id`)
references `products`(`product_id`)
on delete no action
on update no action);

INSERT INTO products VALUES (1, "Milk", 8, 2);
INSERT INTO products VALUES (2, "Bread", 8, 2);
INSERT INTO products VALUES (3, "Eggs", 30, 3);
INSERT INTO products VALUES (4, "Potato",15,4);
INSERT INTO products VALUES (5, "Aplle", 25,5);

INSERT INTO users VALUES (1, "Mike", "Mike","mike@mike","Sumy");
INSERT INTO users VALUES (2, "Nick", "Nick","nick@mnick","Kiev");
INSERT INTO users VALUES (3, "Bill", "Bill","bill@mbill","Dnipro");
INSERT INTO users VALUES (4, "Den", "Den","den@den","Odesa");










