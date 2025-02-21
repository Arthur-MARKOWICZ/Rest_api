create table funcionario(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20),
    cpf varchar(11) not null unique,
    carga_horaria varchar(3) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf varchar(10) not null,
    ativo tinyint not null,
    cidade varchar(100) not null,

    primary key(id)

);