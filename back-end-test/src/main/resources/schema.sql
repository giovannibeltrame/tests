create table category (
	id integer not null,
	name varchar(255) not null,
	primary key(id)
);

create table product (
   id integer not null,
   name varchar(255) not null,
   idcategory integer not null,
   pricevalue decimal not null,
   primary key(id),
   constraint fkcategory foreign key (idcategory) references category (id)
);