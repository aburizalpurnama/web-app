create table perusahaan(
    id varchar (36) AUTO_INCREMENT,
    nama varchar (255) not null,
    primary key (id),
    unique (nama)
) Engine = InnoDB ;