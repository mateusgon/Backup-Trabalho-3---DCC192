/*dcc192-trabalho3-2018-1
usuario
senha*/

/*
drop table participante*/

create table usuario(
    codigoUsuario integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nome varchar(500) not null,
    nomeUsuario varchar (500) not null,
    email varchar(500) not null,
    senha varchar(500) not null
);

create table item (
    codigoItem integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    titulo varchar(500) not null,
    descricao varchar(1000) not null,
    links varchar(500),
    dataInicial timestamp not null,
    dataAtualizacao timestamp,
    fk_codigoCriador integer not null,
    foreign key (fk_codigoCriador) references usuario (codigoUsuario)
);

create table comentario (
    codigoComentario integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    comentario varchar (1000) not null,
    dataInicial timestamp not null,
    dataAtualizacao timestamp,
    fk_codigoCriador integer not null,
    fk_codigoItem integer not null,
    foreign key (fk_codigoCriador) references usuario (codigoUsuario),
    foreign key (fk_codigoItem) references item (codigoItem)
);

create table usuarioitem (
    codigoAvaliarItem integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    positiva smallint,
    negativa smallint,
    fk_codigoUsuario integer not null,
    fk_codigoItem integer not null,
    foreign key (fk_codigoUsuario) references usuario (codigoUsuario),
    foreign key (fk_codigoItem) references item (codigoItem)
);

create table usuariocomentario (
    codigoAvaliarComentario integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    positiva smallint,
    negativa smallint,
    fk_codigoUsuario integer not null,
    fk_codigoComentario integer not null,
    foreign key (fk_codigoUsuario) references usuario (codigoUsuario),
    foreign key (fk_codigoComentario) references comentario (codigoComentario)
);