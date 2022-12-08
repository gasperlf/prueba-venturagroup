--liquibase formatted sql
--changeset lewis_florez:R0
create table empresas
(
    id     smallint PRIMARY KEY,
    codigo character varying(5)   not null UNIQUE,
    nit    character varying(50)  not null UNIQUE,
    nombre character varying(100) not null UNIQUE,
    estado character varying(20)  not null
);
create table equipos
(
    id                         serial PRIMARY KEY,
    codigo_mantenimiento       character varying(20)  not null,
    nombre                     character varying(100) not null,
    fecha_ingreso              timestamp,
    fecha_regreso_operacion    date,
    ultima_fecha_mantenimiento date,
    id_tipo_equipo             smallint               not null,
    id_estado_equipo           smallint               not null,
    id_empresa                 smallint               not null,
    estado                     character varying(20)  not null,
    capacidad                  character varying(50)  not null,
    marca                      character varying(50)  not null,
    modelo                     character varying(50)  not null,
    serial                     character varying(50)  not null,
    id_pertinencia_equipos     smallint               not null,
    id_centro_costos           smallint               not null,
    id_clasificacion_equipos   smallint               not null
);
