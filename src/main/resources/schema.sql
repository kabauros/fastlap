create table laps
(
   id integer auto_increment not null,
   hora varchar(255) not null,
   piloto varchar(255) not null,
   numero_volta integer,
   tempo_volta integer,
   veloc_media_volta DECIMAL(5,2),
   primary key(id)
);
