create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(1000) not null ,
    fechacreacion varchar(10) not null,
    status tinyint not null,
    nombre varchar(100) not null,
    email varchar(100) not null,
    contrasenia varchar(100) not null,
    perfil varchar(100) not null,
    nombrecurso varchar(100) not null,
    categoria varchar(100) not null,
    respuesta varchar(100) not null,


    primary key(id)

);

