delete from ReembolsoEntity;
delete from EnvioEntity;
delete from ComentarioEntity;
delete from BoletaEntity;
delete from OrganizadorEntity;
delete from FuncionEntity;
delete from EspectaculoEntity;
delete from ArtistaEntity;
delete from SillaEntity;
delete from DivisionDeLugarEntity;
delete from LugarEntity;
delete from EspectaculoEntity_OrganizadorEntity;
delete from UsuarioEntity;

/* Mis numero son del 0 al 99 (df.riveros11)**/
insert into FuncionEntity (id, fecha) values (0, '10/10/2017');
insert into SillaEntity (id, costo) values (0, 20.1);
insert into UsuarioEntity (id, userName, password, nombreUsuario, email, pais, ciudad) values (0, 'aa', 'aa', 'Hugo', 'hs.hernandez@domain.onion', 'Argentina', 'newYork');
insert into BoletaEntity (id, precio, vendida, funcion_id, silla_id, usuario_id) values (0, 20.23, 1, 0, 0, 0);

insert into BoletaEntity (id, precio, vendida) values (1, 10.23, 1);

insert into BoletaEntity (id, precio, vendida) values (2, 30.01, 1);
insert into EnvioEntity (id, direccion, boleta_id) values (1,'Calle 43 #7-26 - Aprt:101', 2);

insert into BoletaEntity (id, precio, vendida) values (3, 10.00, 1);
insert into ReembolsoEntity(id, valor, boleta_id) values (1, 100.00, 3);

insert into BoletaEntity(id, precio, vendida) values (4, 55, 1);
insert into ComentarioEntity(id, comentario, fecha, espectaculo_id, boleta_id) values (1, 'ajá tu qué', '2017-12-4', null, 4);


insert into OrganizadorEntity(id, nombreEmpresa) values (0, 'Tu, NO OTRA VEZ');

insert into OrganizadorEntity(id, nombreEmpresa) values (1, 'CULO DE MONDADA');
insert into OrganizadorEntity(id, nombreEmpresa) values (2, 'ECHEVERRY');
insert into EspectaculoEntity(id, descripcion, nombre) values (0, 'aloja', 'que te importa');
insert into EspectaculoEntity(id, descripcion, nombre) values (1, 'erda', 'erdax2');

insert into ESPECTACULOENTITY_ORGANIZADORENTITY (ESPECTACULOS_ID, ORGANIZADOR_ID) values (0, 1);
insert into ESPECTACULOENTITY_ORGANIZADORENTITY (ESPECTACULOS_ID, ORGANIZADOR_ID) values (1, 2);

 /* Jeison (100-199)**/

//Usuarios
insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (100, 'jm.contreras10', '123456789', 'Jeison Contreras', 'jm.contreras10@uniandes.edu.co', 'Colombia', 'Bogotá');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (101, 'sbaldosa', '123456789', 'Santiago Baldosa', 'sbaldosa@unichile.edu.ch', 'Chile', 'Santiago');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (102, 'am.valero10', '123456789', 'Angelo Valero', 'am.valero@uniandes.edu.co', 'Colombia', 'Bogotá');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (103, 'fc.alvarez10', '123456789', 'Fabian Alvarez', 'fc.alvarez@uniandes.edu.co', 'Colombia', 'Bogotá');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (104, 'ja.gomez1', '123456789', 'Jorge Gomez', 'ja.gomez1@uniandes.edu.co', 'Colombia', 'Bogotá');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (105, 'jf.ramos', '123456789', 'Felipe Ramos', 'jf.ramos@uniandes.edu.co', 'Colombia', 'Bogotá');

insert into USUARIOENTITY (id, userName, password, nombreUsuario, email, pais, ciudad) 
values (106, 'df.riveros11', '123456789', 'Diego', 'df.riveros11@uniandes.edu.co', 'Colombia', 'Bogotá');

//Boletas(Compradas)
insert into BoletaEntity (id, precio, vendida, usuario_id) values (100, 300.00, 1, 100);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (101, 200.00, 1, 101);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (102 300.00, 1,102);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (103, 400.00, 1, 102);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (104, 500.00, 1, 103);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (105, 600.00, 1, 105);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (106, 100.00, 1, 104);
//Boletas(Reembolsadas)
insert into BoletaEntity (id, precio, vendida, usuario_id) values (107, 200.00, 1, 104);
insert into BoletaEntity (id, precio, vendida, usuario_id) values (108 300.00, 1,106);

//Reembolsos
insert into ReembolsoEntity(id, valor, boleta_id, usuario_id) values (100, 300.00,107, 104);
insert into ReembolsoEntity(id, valor, boleta_id, usuario_id) values (101, 10.00,108, 106);

 /* Fabian (200-299)**/

insert into DivisionDeLugarEntity (id,nombre) values (200,'Noroccidental alta');
insert into DivisionDeLugarEntity (id,nombre) values (210,'Suroccidental alta');
insert into DivisionDeLugarEntity (id,nombre) values (220,'Noroccidental baja');
insert into DivisionDeLugarEntity (id,nombre) values (230,'Suroccidental baja');
insert into DivisionDeLugarEntity (id,nombre) values (240,'VIP');

insert into SillaEntity (id,costo,division_id) values (200,20.1,200);
insert into SillaEntity (id,costo,division_id) values (210,260.5,210);
insert into SillaEntity (id,costo,division_id) values (220,30.8,220);
insert into SillaEntity (id,costo,division_id) values (230,1000.5,230);

insert into BoletaEntity (id, precio, vendida, silla_id) values (200, 98000, 0, 200);
insert into BoletaEntity (id, precio, vendida, silla_id) values (210, 34000, 1, 210);
insert into BoletaEntity (id, precio, vendida, silla_id) values (220, 645000, 0, 220);
insert into BoletaEntity (id, precio, vendida, silla_id) values (230, 75000, 1, 230);
