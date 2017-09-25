delete from BoletaEntity;
delete from OrganizadorEntity;
delete from EnvioEntity;
delete from ComentarioEntity;
delete from EspectaculoEntity;
delete from ArtistaEntity;

insert into BoletaEntity (id, precio, vendida) values (1, 100.23, 0);
insert into BoletaEntity (id, precio, vendida) values (2, 20.23, 1);
insert into BoletaEntity (id, precio, vendida) values (3, 0.23, 0);
insert into BoletaEntity (id, precio, vendida) values (4, 0.00, 1);

insert into OrganizadorEntity (id, nombreEmpresa) values (1, 'Yo');
insert into OrganizadorEntity (id, nombreEmpresa) values (2, 'YoYQue');
insert into OrganizadorEntity (id, nombreEmpresa) values (3, 'DondeEstoy');
insert into OrganizadorEntity (id, nombreEmpresa) values (4, 'TuOtraVez');


insert into EnvioEntity (id, direccion) values (100,'Calle 43 #7-26 - Aprt:101');
insert into EnvioEntity (id, direccion) values (200, 'Cra 68i #26.48 - Casa');
insert into EnvioEntity (id, direccion) values (300,'Cl. 8 Sur #71d:20');
insert into EnvioEntity (id, direccion) values (400, 'Carrera 43 # 70A-50 SUR');

insert into ComentarioEntity (id,comentario,fecha) values (100,'Muy buen espectaculo','10/10/2017');
insert into ComentarioEntity (id,comentario,fecha) values (200,'horror de evento','10/31/2017');
insert into ComentarioEntity (id,comentario,fecha) values (300,'me gusto mucho asistir','11/01/1989');
insert into ComentarioEntity (id,comentario,fecha) values (400,'me senti muy bien en el evento','06/20/2017');

insert into ArtistaEntity (id, nombreArtista) values (1, 'Juanes');
insert into ArtistaEntity (id, nombreArtista) values (2, 'Shakira');
insert into ArtistaEntity (id, nombreArtista) values (3, 'Cirque du Soleil');
insert into ArtistaEntity (id, nombreArtista) values (4, 'Portugal The Man');


insert into EspectaculoEntity (id, nombre, descripcion) values (1, 'Septimo dia', 'Espectaculo de Cirque Du Soleil junto a Soda Estereo');
insert into EspectaculoEntity (id, nombre, descripcion) values (2, 'P.A.R.C.E', 'Gira de Juanes pro Colombia');
insert into EspectaculoEntity (id, nombre, descripcion) values (3, 'Concierto Shakira', 'Concierto');
insert into EspectaculoEntity (id, nombre, descripcion) values (4, 'Gira Portugal The Man', 'Concierto');
