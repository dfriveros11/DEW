delete from BoletaEntity;
delete from OrganizadorEntity;
delete from EnvioEntity;
delete from ComentarioEntity;
delete from DivisionDeLugarEntity;
delete from SillaEntity;
delete from FuncionEntity;
delete from LugarEntity;

insert into BoletaEntity (id, precio, vendida) values (1, 100.23, false);
insert into BoletaEntity (id, precio, vendida) values (2, 20.23, true);
insert into BoletaEntity (id, precio, vendida) values (3, 0.23, false);
insert into BoletaEntity (id, precio, vendida) values (4, 0.00, true);

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

insert into DivisionDeLugarEntity (id,nombre) values (10,'Noroccidental alta');
insert into DivisionDeLugarEntity (id,nombre) values (20,'Suroccidental alta');
insert into DivisionDeLugarEntity (id,nombre) values (30,'Noroccidental baja');
insert into DivisionDeLugarEntity (id,nombre) values (40,'Suroccidental baja');
insert into DivisionDeLugarEntity (id,nombre) values (50,'VIP');

insert into SillaEntity (id,costo) values (50,20.1);
insert into SillaEntity (id,costo) values (40,260.5);
insert into SillaEntity (id,costo) values (30,30.8);
insert into SillaEntity (id,costo) values (20,1000.5);

insert into LugarEntity (id,tipo) values (1,'CASA');
insert into LugarEntity (id,tipo) values (2,'APTO');
insert into LugarEntity (id,tipo) values (3,'TEATRO');
insert into LugarEntity (id,tipo) values (4,'FINCA');

insert into FuncionEntity (id,fecha,lugar_id) values (1,'10/10/2017',1);
insert into FuncionEntity (id,fecha,lugar_id) values (2,'10/10/2016',1);
insert into FuncionEntity (id,fecha,lugar_id) values (3,'10/10/2015',1);
insert into FuncionEntity (id,fecha,lugar_id) values (4,'10/10/2014',2);
