-- Joaquin Sanchez - 2026117 - IN4CM
-- Hoja de Trabajo 4 - segunda entrega - DDL

-- drop database if exists streamingdb_in4cm;
create database if not exists streamingdb_in4cm;
use streamingdb_in4cm;

-- --------
-- TABLAS-------
-- --------
-- ESTUDIO DE CINE 
create table estudio_cine (
    id_estudio int not null primary key,
    nombre_estudio varchar(100) not null,
    pais varchar(50) default "Estados Unidos",
    sede_central varchar(100) not null
);
describe estudio_cine;

-- USUARIO
create table usuario (
    id_usuario int not null primary key,
    username varchar(50) not null unique,
    correo varchar(100) not null unique,
    contrasena varchar(50) not null
);
describe usuario;

-- ACTOR
create table actor (
    id_actor int not null primary key,
    nombre_artistico varchar(100) not null,
    fecha_nacimiento date,
    nacionalidad varchar(50) default "Estadounidense"
);
describe actor;

-- PAPEL
create table papel (
    id_papel int not null primary key,
    nombre_personaje varchar(100) not null
);
describe papel;

-- PELICULA
create table pelicula (
    id_pelicula int not null primary key,
    titulo_peli varchar(150) not null,
    anio_salida date,
    clasificacion_edad int default 0,
    id_estudio int,

    constraint fk_pelicula_estudio foreign key (id_estudio)
        references estudio_cine (id_estudio)
        on delete restrict
        on update cascade
);
describe pelicula;

-- PELICULA ACTOR
create table pelicula_actor (
    id_pelicula_actor int not null primary key,
    id_pelicula int,
    id_actor int,
    id_papel int,

    constraint fk_pa_pelicula foreign key (id_pelicula)
        references pelicula (id_pelicula)
        on delete cascade
        on update cascade,

    constraint fk_pa_actor foreign key (id_actor)
        references actor (id_actor)
        on delete cascade
        on update cascade,

    constraint fk_pa_papel foreign key (id_papel)
        references papel (id_papel)
        on delete restrict
        on update cascade
);
describe pelicula_actor;

-- LISTA FAVORITOS
create table lista_favorito (
    id_lista int not null primary key,
    nombre_lista varchar(100) not null,
    id_usuario int,

    constraint fk_lista_usuario foreign key (id_usuario)
        references usuario (id_usuario)
        on delete cascade
        on update cascade
);
describe lista_favorito;

-- LISTA PELICULAS FAVORITAS 
create table lista_fav_peli (
    id_lista_fav_peli int not null primary key,
    id_lista int,
    id_pelicula int,

    constraint fk_lfp_lista foreign key (id_lista)
        references lista_favorito (id_lista)
        on delete cascade
        on update cascade,

    constraint fk_lfp_pelicula foreign key (id_pelicula)
        references pelicula (id_pelicula)
        on delete cascade
        on update cascade
);
describe lista_fav_peli;


-- VISTAS 

-- 1. Vista delos estudios de cine
create view vw_estudios as
select id_estudio, nombre_estudio, pais, sede_central
from estudio_cine;

-- 2. Vista de los usuarios
create view vw_usuarios as
select id_usuario, username, correo
from usuario;

-- 3. Vista de los actores
create view vw_actores as
select id_actor, nombre_artistico, fecha_nacimiento, nacionalidad
from actor;

-- 4. Vista de papeles o personajes
create view vw_papeles as
select id_papel, nombre_personaje
from papel;

-- 5. Vista de peliculas
create view vw_peliculas as
select id_pelicula, titulo_peli, anio_salida, clasificacion_edad, id_estudio
from pelicula;

-- 6. Vista de peliculas y su actor
create view vw_pelicula_actor as
select id_pelicula_actor, id_pelicula, id_actor, id_papel
from pelicula_actor;

-- 7. Vista de listas de favoritos
create view vw_listas_favorito as
select id_lista, nombre_lista, id_usuario
from lista_favorito;

-- 8. Vista de lista de pelicula favorita
create view vw_lista_fav_peli as
select id_lista_fav_peli, id_lista, id_pelicula
from lista_fav_peli;


-- -------
-- VISTAS --
-- -------

-- Vista Peliculas con su estudio de produccion
create view vw_peliculas_con_estudio as
select
    p.id_pelicula as 'ID Pelicula',
    p.titulo_peli as 'Titulo',
    p.anio_salida as 'Estreno',
    p.clasificacion_edad as 'Edad Minima',
    e.nombre_estudio as 'Estudio',
    e.pais as 'Pais del Estudio'
from pelicula p
inner join estudio_cine e on p.id_estudio = e.id_estudio;

-- Vista de area completa (pelicula, actor y personaje)
create view vw_reparto_completo as
select
    p.titulo_peli as 'Pelicula',
    a.nombre_artistico as 'Actor / Actriz',
    pa.nombre_personaje as 'Personaje'
from pelicula_actor pact
inner join pelicula p on pact.id_pelicula = p.id_pelicula
inner join actor a on pact.id_actor = a.id_actor
inner join papel pa on pact.id_papel = pa.id_papel;

-- Vista reporte general (usuario, lista, pelicula y estudio)
create view vw_reporte_general_streaming as
select
    u.username as 'Usuario',
    lf.nombre_lista as 'Lista de Favoritos',
    p.titulo_peli as 'Pelicula',
    p.anio_salida as 'Estreno',
    e.nombre_estudio as 'Estudio Productor'
from lista_fav_peli lfp
inner join lista_favorito lf on lfp.id_lista = lf.id_lista
inner join pelicula p on lfp.id_pelicula = p.id_pelicula
inner join usuario u on lf.id_usuario = u.id_usuario
inner join estudio_cine e on p.id_estudio = e.id_estudio;


 -- --------------------
 -- CRUD DE MIS TABLAS
 -- --------------------   
 
-- ---------------
-- CRUD DE PELICULA----
-- ---------------

-- CREAR 
delimiter //
create procedure sp_crear_pelicula(
    in _id_pelicula int,
    in _titulo_peli varchar(150),
    in _anio_salida date,
    in _clasificacion_edad int,
    in _id_estudio int)
begin
    insert into pelicula(id_pelicula, titulo_peli, anio_salida, clasificacion_edad, id_estudio)
    values (_id_pelicula, _titulo_peli, _anio_salida, _clasificacion_edad, _id_estudio);
end //
delimiter ;

-- LISTAR 
delimiter //
create procedure sp_listar_peliculas()
begin
    select
        p.id_pelicula as 'ID',
        p.titulo_peli as 'TITULO',
        p.anio_salida as 'ESTRENO',
        p.clasificacion_edad as 'CLASIFICACION',
        e.nombre_estudio as 'ESTUDIO'
    from pelicula p
    inner join estudio_cine e on p.id_estudio = e.id_estudio
    order by p.id_pelicula;
end //
delimiter ;

-- BUSCAR 
delimiter //
create procedure sp_buscar_pelicula(in _id_pelicula int)
begin
    select
        p.id_pelicula,
        p.titulo_peli,
        p.anio_salida,
        p.clasificacion_edad,
        e.nombre_estudio
    from pelicula p
    inner join estudio_cine e on p.id_estudio = e.id_estudio
    where p.id_pelicula = _id_pelicula;
end //
delimiter ;

-- ACTUALIZAR 
delimiter //
create procedure sp_actualizar_pelicula(
    in _id_pelicula int,
    in _titulo_peli varchar(150),
    in _anio_salida date,
    in _clasificacion_edad int,
    in _id_estudio int)
begin
    update pelicula
    set titulo_peli = _titulo_peli,
        anio_salida = _anio_salida,
        clasificacion_edad = _clasificacion_edad,
        id_estudio = _id_estudio
    where id_pelicula = _id_pelicula;
end //
delimiter ;

-- ELIMINAR 
delimiter //
create procedure sp_eliminar_pelicula(in _id_pelicula int)
begin
    delete from pelicula
    where id_pelicula = _id_pelicula;
end //
delimiter ;


-- ---------------
-- CRUD DE ACTOR
-- ---------------

-- CREAR 
delimiter //
create procedure sp_crear_actor(
    in _id_actor int,
    in _nombre_artistico varchar(100),
    in _fecha_nacimiento date,
    in _nacionalidad varchar(50))
begin
    insert into actor(id_actor, nombre_artistico, fecha_nacimiento, nacionalidad)
    values (_id_actor, _nombre_artistico, _fecha_nacimiento, _nacionalidad);
end //
delimiter ;

-- LISTAR 
delimiter //
create procedure sp_listar_actores()
begin
    select id_actor as ID, nombre_artistico as 'NOMBRE ARTISTICO',
           fecha_nacimiento as 'NACIMIENTO', nacionalidad as NACIONALIDAD
    from actor;
end //
delimiter ;

-- BUSCAR 
delimiter //
create procedure sp_buscar_actor(in _id_actor int)
begin
    select id_actor, nombre_artistico, fecha_nacimiento, nacionalidad
    from actor
    where id_actor = _id_actor;
end //
delimiter ;

-- ACTUALIZAR 
delimiter //
create procedure sp_actualizar_actor(
    in _id_actor int,
    in _nombre_artistico varchar(100),
    in _fecha_nacimiento date,
    in _nacionalidad varchar(50))
begin
    update actor
    set nombre_artistico = _nombre_artistico,
        fecha_nacimiento = _fecha_nacimiento,
        nacionalidad = _nacionalidad
    where id_actor = _id_actor;
end //
delimiter ;

-- ELIMINAR 
delimiter //
create procedure sp_eliminar_actor(in _id_actor int)
begin
    delete from actor
    where id_actor = _id_actor;
end //
delimiter ;

-- ---------------
-- CRUD DE USUARIO
-- ---------------

-- CREAR 
delimiter //
create procedure sp_crear_usuario(
    in _id_usuario int,
    in _username varchar(50),
    in _correo varchar(100),
    in _contrasena varchar(50))
begin
    insert into usuario(id_usuario, username, correo, contrasena)
    values (_id_usuario, _username, _correo, _contrasena);
end //
delimiter ;

-- LISTAR 
delimiter //
create procedure sp_listar_usuarios()
begin
    select id_usuario as ID, username as 'USUARIO', correo as 'CORREO'
    from usuario;
end //
delimiter ;

-- BUSCAR 
delimiter //
create procedure sp_buscar_usuario(in _id_usuario int)
begin
    select id_usuario, username, correo
    from usuario
    where id_usuario = _id_usuario;
end //
delimiter ;

-- ACTUALIZAR 
delimiter //
create procedure sp_actualizar_usuario(
    in _id_usuario int,
    in _username varchar(50),
    in _correo varchar(100),
    in _contrasena varchar(50))
begin
    update usuario
    set username = _username,
        correo = _correo,
        contrasena = _contrasena
    where id_usuario = _id_usuario;
end //
delimiter ;

-- ELIMINAR 
delimiter //
create procedure sp_eliminar_usuario(in _id_usuario int)
begin
    delete from usuario
    where id_usuario = _id_usuario;
end //
delimiter ;

-- --------------------------
-- CRUD DE LISTA DE FAVORITOS
-- --------------------------

-- CREAR 
delimiter //
create procedure sp_crear_lista(
    in _id_lista int,
    in _nombre_lista varchar(100),
    in _id_usuario int)
begin
    insert into lista_favorito(id_lista, nombre_lista, id_usuario)
    values (_id_lista, _nombre_lista, _id_usuario);
end //
delimiter ;

-- LISTAR 
delimiter //
create procedure sp_listar_listas()
begin
    select id_lista as ID, nombre_lista as 'NOMBRE LISTA', id_usuario as 'ID USUARIO'
    from lista_favorito;
end //
delimiter ;

-- BUSCAR 
delimiter //
create procedure sp_buscar_lista(in _id_lista int)
begin
    select id_lista, nombre_lista, id_usuario
    from lista_favorito
    where id_lista = _id_lista;
end //
delimiter ;

-- ACTUALIZAR 
delimiter //
create procedure sp_actualizar_lista(
    in _id_lista int,
    in _nombre_lista varchar(100),
    in _id_usuario int)
begin
    update lista_favorito
    set nombre_lista = _nombre_lista,
        id_usuario = _id_usuario
    where id_lista = _id_lista;
end //
delimiter ;

-- ELIMINAR 
delimiter //
create procedure sp_eliminar_lista(in _id_lista int)
begin
    delete from lista_favorito
    where id_lista = _id_lista;
end //
delimiter ;

-- -------------------------------
-- CRUD DE LISTA PELICULA FAVORITA
-- -------------------------------

-- CREAR
delimiter //
create procedure sp_crear_lista_fav_peli(
    in _id_lista_fav_peli int,
    in _id_lista int,
    in _id_pelicula int)
begin
    insert into lista_fav_peli(id_lista_fav_peli, id_lista, id_pelicula)
    values (_id_lista_fav_peli, _id_lista, _id_pelicula);
end //
delimiter ;

-- LISTAR 
delimiter //
create procedure sp_listar_lista_fav_peli()
begin
    select id_lista_fav_peli as ID, id_lista as 'ID LISTA', id_pelicula as 'ID PELICULA'
    from lista_fav_peli;
end //
delimiter ;

-- BUSCAR 
delimiter //
create procedure sp_buscar_lista_fav_peli(in _id_lista_fav_peli int)
begin
    select id_lista_fav_peli, id_lista, id_pelicula
    from lista_fav_peli
    where id_lista_fav_peli = _id_lista_fav_peli;
end //
delimiter ;

-- ACTUALIZAR 
delimiter //
create procedure sp_actualizar_lista_fav_peli(
    in _id_lista_fav_peli int,
    in _id_lista int,
    in _id_pelicula int)
begin
    update lista_fav_peli
    set id_lista = _id_lista,
        id_pelicula = _id_pelicula
    where id_lista_fav_peli = _id_lista_fav_peli;
end //
delimiter ;

-- ELIMINAR 
delimiter //
create procedure sp_eliminar_lista_fav_peli(in _id_lista_fav_peli int)
begin
    delete from lista_fav_peli
    where id_lista_fav_peli = _id_lista_fav_peli;
end //
delimiter ;

call sp_listar_peliculas();
call sp_listar_actores();
call sp_listar_usuarios();
call sp_listar_listas();
call sp_listar_lista_fav_peli();