delete from BoletaEntity;

delete from EnvioEntity;
delete from ComentarioEntity;

insert into EnvioEntity (id, direccion) values (100,'Calle 43 #7-26 - Aprt:101');
insert into EnvioEntity (id, direccion) values (200, 'Cra 68i #26.48 - Casa');
insert into EnvioEntity (id, direccion) values (300,'Cl. 8 Sur #71d:20');
insert into EnvioEntity (id, direccion) values (400, 'Carrera 43 # 70A-50 SUR');

insert into ComentarioEntity (id,comentario,fecha) values (100,'Muy buen espectaculo','10/10/2017');
insert into ComentarioEntity (id,comentario,fecha) values (200,'horror de evento','10/31/2017');
insert into ComentarioEntity (id,comentario,fecha) values (300,'me gusto mucho asistir','11/01/1989');
insert into ComentarioEntity (id,comentario,fecha) values (400,'me senti muy bien en el evento','06/20/2017');
