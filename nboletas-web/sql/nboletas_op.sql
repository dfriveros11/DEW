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

insert into BoletaEntity (id, precio, vendida) values (2, 30.01, 0);
insert into EnvioEntity (id, direccion, boleta_id) values (1,'Calle 43 #7-26 - Aprt:101', 2);

insert into BoletaEntity (id, precio, vendida) values (3, 10.00, 1);
insert into ReembolsoEntity(id, valor, boleta_id) values (1, 100.00, 3);

insert into OrganizadorEntity(id, nombreEmpresa) values (0, 'Tu, NO OTRA VEZ');

insert into OrganizadorEntity(id, nombreEmpresa) values (1, 'CULO DE MONDADA');
insert into OrganizadorEntity(id, nombreEmpresa) values (2, 'ECHEVERRY');
insert into EspectaculoEntity(id, descripcion, nombre) values (0, 'aloja', 'que te importa');
insert into EspectaculoEntity(id, descripcion, nombre) values (1, 'erda', 'erdax2');

insert into ESPECTACULOENTITY_ORGANIZADORENTITY (ESPECTACULOS_ID, ORGANIZADOR_ID) values (0, 1);
insert into ESPECTACULOENTITY_ORGANIZADORENTITY (ESPECTACULOS_ID, ORGANIZADOR_ID) values (1, 2);

