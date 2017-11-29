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
insert into ArtistaEntity (id, nombre, imagen) values (2, 'Shakira', 'http://assets.tiempo.com.mx/uploads/imagen/imagen/134341/Esto_delatari_a_el_fin_de_la_relacio_n_de_Shakira_y_Pique_.jpg');
insert into ArtistaEntity (id, nombre, imagen) values (3, 'Cirque du Soleil', 'https://www.cirquedusoleil.com/-/media/past-shows/assets/img/iris/slider/iris-act-kiriki.jpg');
insert into ArtistaEntity (id, nombre, imagen) values (4, 'Portugal The Man', 'http://cientounorevista.com/wp-content/uploads/2017/07/portugal_the_man_facebook.jpg');

insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos_id) values (1,3);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos_id) values (2,1);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos_id) values (3,2);
insert into EspectaculoEntity_ArtistaEntity (artista_id, espectaculos_id) values (4,4);

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

insert into UsuarioEntity (id, userName, password, nombreUsuario, email, pais, ciudad, imagen) values (1, 'Fercho2715', '1234', 'Fernando', 'fercho2715@domain.onion', 'Colombia', 'Bogota', 'https://tmssl.akamaized.net//images/portrait/originals/3455-1450105043.jpg');
insert into UsuarioEntity (id, userName, password, nombreUsuario, email, pais, ciudad, imagen) values (2, 'Lula11', '1234', 'Luisa', 'lula11@domain.onion', 'Colombia', 'Bogota', 'http://ru.fishki.net/picsw/102012/17/post/zombi/zombi-0003.jpg');
insert into UsuarioEntity (id, userName, password, nombreUsuario, email, pais, ciudad, imagen) values (3, 'AlinoxThe3', '1234', 'Andres', 'alinoxthe3@domain.onion', 'Colombia', 'Bogota', 'https://2.bp.blogspot.com/-QnLlhx6McUU/VFqnbqWe2OI/AAAAAAAAnJ8/l5Vq0cfyYKc/s1600/frente%2Bgrande34.jpg');
insert into UsuarioEntity (id, userName, password, nombreUsuario, email, pais, ciudad, imagen) values (4, 'Cubosx', '1234', 'Cubillos', 'cubosx@domain.onion', 'Colombia', 'Bogota', 'http://www.revistanos.cl/wp-content/uploads/2010/09/cubillos-IMG_0169.jpg');

insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (1, 'Preferencial', 1, 'http://lastarjetasdecredito.com.co/wp-content/uploads/debito-maestro-preferencial-bancolombia1.jpg');
insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (2, 'Preferencial', 2, 'http://lastarjetasdecredito.com.co/wp-content/uploads/debito-maestro-preferencial-bancolombia1.jpg');
insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (3, 'Preferencial', 3, 'http://lastarjetasdecredito.com.co/wp-content/uploads/debito-maestro-preferencial-bancolombia1.jpg');
insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (4, 'Regular', 1, 'http://www.speedperu.com/media/catalog/product/cache/6/image/650x/040ec09b1e35df139433887a97daa66f/g/e/general.jpg');
insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (5, 'Regular', 2, 'http://www.speedperu.com/media/catalog/product/cache/6/image/650x/040ec09b1e35df139433887a97daa66f/g/e/general.jpg');
insert into DivisionDeLugarEntity (id, nombre, lugar_id, imagen) values (6, 'Regular', 3, 'http://www.speedperu.com/media/catalog/product/cache/6/image/650x/040ec09b1e35df139433887a97daa66f/g/e/general.jpg');

insert into SillaEntity (id, costo, division_id, imagen) values (1, 48000, 1, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (2, 49000, 1, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (3, 20000, 2, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (4, 35000, 2, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (5, 48000, 3, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (6, 49000, 3, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (7, 20000, 4, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (8, 35000, 4, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (9, 48000, 5, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (10, 49000, 5, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (11, 20000, 6, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');
insert into SillaEntity (id, costo, division_id, imagen) values (12, 35000, 6, 'https://intermueblespacios.com/wp-content/uploads/2017/05/Butaca-Roma-estadios.png');

insert into BoletaEntity (id, precio, vendida, silla_id,usuario_id,funcion_id, imagen) values (1, 98000, 0, 1,1,1, 'https://marketingland.com/wp-content/ml-loads/2016/04/sp-tickets-600x393.png');
insert into BoletaEntity (id, precio, vendida, silla_id,usuario_id,funcion_id, imagen) values (2, 99000, 0, 2,2,3, 'https://marketingland.com/wp-content/ml-loads/2016/04/sp-tickets-600x393.png');
insert into BoletaEntity (id, precio, vendida, silla_id,usuario_id,funcion_id, imagen) values (3, 65000, 0, 3,3,5, 'https://marketingland.com/wp-content/ml-loads/2016/04/sp-tickets-600x393.png');
insert into BoletaEntity (id, precio, vendida, silla_id,usuario_id,funcion_id, imagen) values (4, 75000, 0, 4,4,7, 'https://marketingland.com/wp-content/ml-loads/2016/04/sp-tickets-600x393.png');

insert into OrganizadorEntity(id, imagen, nombreEmpresa) values (1, 'http://www.linuxpreview.org/wp-content/uploads/2016/12/predicciones-linux-300x200.jpg', 'INC');
insert into OrganizadorEntity(id, imagen, nombreEmpresa) values (2, 'http://www.linuxpreview.org/wp-content/uploads/2016/12/linux-kernel-4-9-300x162.jpg', 'BBC');
insert into OrganizadorEntity(id, imagen, nombreEmpresa) values (3, 'https://experienciadigital.es/wp-content/uploads/2017/08/linux-696x422.jpg', 'Network All');
insert into OrganizadorEntity(id, imagen, nombreEmpresa) values (4, 'https://www.giftcardsonsale.com.au/wp-content/uploads/2010/03/thegoodguys.jpg', 'The Good Guys');

insert into EspectaculoEntity_OrganizadorEntity (espectaculos_id, organizador_id) values (1,1);
insert into EspectaculoEntity_OrganizadorEntity (espectaculos_id, organizador_id) values (2,2);
insert into EspectaculoEntity_OrganizadorEntity (espectaculos_id, organizador_id) values (3,3);
insert into EspectaculoEntity_OrganizadorEntity (espectaculos_id, organizador_id) values (4,4);

insert into ReembolsoEntity(id, valor, boleta_id, usuario_id, imagen) values (1, 300.00, 1, 1, 'https://st2.depositphotos.com/5266903/7877/v/950/depositphotos_78778914-stock-illustration-refund-icon-from-business-bicolor.jpg');
insert into ReembolsoEntity(id, valor, boleta_id, usuario_id, imagen) values (2, 10.00, 2, 2, 'https://st2.depositphotos.com/5266903/7877/v/950/depositphotos_78778914-stock-illustration-refund-icon-from-business-bicolor.jpg');
insert into ReembolsoEntity(id, valor, boleta_id, usuario_id, imagen) values (3, 300.00, 3, 3, 'https://st2.depositphotos.com/5266903/7877/v/950/depositphotos_78778914-stock-illustration-refund-icon-from-business-bicolor.jpg');
insert into ReembolsoEntity(id, valor, boleta_id, usuario_id, imagen) values (4, 10.00, 4, 4, 'https://st2.depositphotos.com/5266903/7877/v/950/depositphotos_78778914-stock-illustration-refund-icon-from-business-bicolor.jpg');

insert into ComentarioEntity (id,comentario,fecha, espectaculo_id, boleta_id, imagen) values (1,'Muy buen espectaculo','10/10/2017',1,1, 'https://image.freepik.com/iconos-gratis/comentario-ios-7-simbolo-interfaz_318-33559.jpg');
insert into ComentarioEntity (id,comentario,fecha, espectaculo_id, boleta_id, imagen) values (2,'horror de evento','10/31/2017',2,2, 'https://image.freepik.com/iconos-gratis/comentario-ios-7-simbolo-interfaz_318-33559.jpg');
insert into ComentarioEntity (id,comentario,fecha, espectaculo_id, boleta_id, imagen) values (3,'me gusto mucho asistir','11/01/1989',3,3, 'https://image.freepik.com/iconos-gratis/comentario-ios-7-simbolo-interfaz_318-33559.jpg');
insert into ComentarioEntity (id,comentario,fecha, espectaculo_id, boleta_id, imagen) values (4,'me senti muy bien en el evento','06/20/2017',4,4, 'https://image.freepik.com/iconos-gratis/comentario-ios-7-simbolo-interfaz_318-33559.jpg');

insert into EnvioEntity (id, direccion, boleta_id, imagen) values (1,'Calle 43 #7-26 - Aprt:101',1, 'https://4.bp.blogspot.com/-Lg-PQp7eKpQ/UON9lZXShjI/AAAAAAAAAsA/wptqs7RwPjI/s1600/urna2.jpg');
insert into EnvioEntity (id, direccion, boleta_id, imagen) values (2, 'Cra 68i #26.48 - Casa',2, 'https://4.bp.blogspot.com/-Lg-PQp7eKpQ/UON9lZXShjI/AAAAAAAAAsA/wptqs7RwPjI/s1600/urna2.jpg');
insert into EnvioEntity (id, direccion, boleta_id, imagen) values (3,'Cl. 8 Sur #71d:20',3, 'https://4.bp.blogspot.com/-Lg-PQp7eKpQ/UON9lZXShjI/AAAAAAAAAsA/wptqs7RwPjI/s1600/urna2.jpg');
insert into EnvioEntity (id, direccion, boleta_id, imagen) values (4, 'Carrera 43 # 70A-50 SUR',4, 'https://4.bp.blogspot.com/-Lg-PQp7eKpQ/UON9lZXShjI/AAAAAAAAAsA/wptqs7RwPjI/s1600/urna2.jpg');





