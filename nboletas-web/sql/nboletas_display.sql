delete from ReembolsoEntity;
delete from EnvioEntity;
delete from ComentarioEntity;
delete from BoletaEntity;
delete from OrganizadorEntity;
delete from FuncionEntity;
delete from EspectaculoEntity_ArtistaEntity;
delete from EspectaculoEntity_OrganizadorEntity;
delete from EspectaculoEntity;
delete from ArtistaEntity;
delete from SillaEntity;
delete from DivisionDeLugarEntity;
delete from LugarEntity;
delete from EspectaculoEntity_OrganizadorEntity;
delete from UsuarioEntity;

insert into EspectaculoEntity (id, nombre, descripcion, imagen) values (1, 'Septimo dia', 'Espectaculo de Cirque Du Soleil junto a Soda Estereo', 'https://puntoticket-a.akamaihd.net/especiales/septimo-dia/img/septimo-dia.jpg');
insert into EspectaculoEntity (id, nombre, descripcion, imagen) values (2, 'P.A.R.C.E', 'Gira de Juanes por Colombia', 'http://images.coveralia.com/audio/j/Juanes-P_A_R_C_E_(Deluxe_Edition)-Frontal.jpg');
insert into EspectaculoEntity (id, nombre, descripcion, imagen) values (3, 'Concierto Shakira', 'Concierto', 'https://www.music-bazaar.com/album-images/vol8/461/461159/2278937-big/Shakira-Live-From-Paris-cover.jpg');
insert into EspectaculoEntity (id, nombre, descripcion, imagen) values (4, 'Gira Portugal The Man', 'Concierto', 'http://revistakuadro.com/wp-content/uploads/2015/03/b9185c948d.jpg');

insert into ArtistaEntity (id, nombre, imagen) values (1, 'Juanes', 'http://d3iln1l77n73l7.cloudfront.net/couch_images/attachments/000/083/784/original/JUANES.jpg?2016');
insert into ArtistaEntity (id, nombre, imagen) values (2, 'Shakira', 'https://www.google.com.co/search?q=shakira&rlz=1C5CHFA_enCO729CO729&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiDpMOopuLXAhXG5CYKHQ6tBzcQ_AUICygC&biw=1164&bih=618#imgrc=kIkRoZ4sqbm3vM:');
insert into ArtistaEntity (id, nombre, imagen) values (3, 'Cirque du Soleil', 'https://www.cirquedusoleil.com/-/media/past-shows/assets/img/iris/slider/iris-act-kiriki.jpg');
insert into ArtistaEntity (id, nombre, imagen) values (4, 'Portugal The Man', 'https://www.google.com.co/search?rlz=1C5CHFA_enCO729CO729&tbm=isch&q=portugal+the+man+concierto&spell=1&sa=X&ved=0ahUKEwiRoJWbpeLXAhUB4iYKHRPbBYcQvwUIISgA&biw=1164&bih=618&dpr=2.2#imgrc=GLE7Djxg9_3pIM:');

insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos) values (1,3);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos) values (2,1);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos) values (3,2);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos) values (4,4);

insert into LugarEntity (id, direccion, ubicacion, tipo, imagen) values (1,'Coliseo El Campin', 'Bogota', 'COLISEO', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Bogota_Coliseo_El_Camp%C3%ADn.JPG/1200px-Bogota_Coliseo_El_Camp%C3%ADn.JPG');
insert into LugarEntity (id, direccion, ubicacion, tipo, imagen) values (2,'Teatro Nacional La Casellana', 'Bogota', 'TEATRO', 'https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto:low,w_1200/v1457113325/entity/image/file/001/000/56d9c8ec820c65dcc6000001.jpg');
insert into LugarEntity (id, direccion, ubicacion, tipo, imagen) values (3,'Plaza de Bolivar', 'Bogota', 'PLAZA', 'https://upload.wikimedia.org/wikipedia/commons/5/56/Panor%C3%A1mica_Plaza_de_Bol%C3%ADvar_Bogot%C3%A1.jpg');

insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (1, '10/10/2017', '10:00 pm', 1, 1, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (2, '02/02/2018', '10:00 pm', 1, 1, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (3, '10/10/2017', '9:00 pm', 2, 3, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (4, '02/02/2018', '9:00 pm', 2, 3, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (5, '10/10/2017', '8:45 pm', 3, 3, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (6, '02/02/2018', '8:45 pm', 3, 3, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (7, '10/10/2017', '8:45 pm', 4, 2, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');
insert into FuncionEntity (id, fecha, hora, espectaculo_id, lugar_id, imagen) values (8, '02/02/2018', '8:45 pm', 4, 2, 'https://www.bogotaesteatro.com/wp-content/uploads/2016/11/TEATRO-NACIONAL-LA-CASTELLANA.jpg');









