-- Joaquin Sanchez - 2026117 - IN4CM
-- Hoja de Trabajo 4 - segunda entrega - DML

-- drop database if exists streamingdb_in4cm;
use streamingdb_in4cm;

-- ---------------------
-- INSERTS DE MIS TABLAS-----
-- ---------------------

-- INSERTS - ESTUDIO DE CINE 
insert into estudio_cine (id_estudio, nombre_estudio, pais, sede_central) values
(10,  "Warner Bros. Pictures",   "Estados Unidos", "Burbank, California"       ),
(20,  "New Line Cinema",         "Estados Unidos", "New York City"             ),
(30,  "Paramount Pictures",      "Estados Unidos", "Hollywood, California"     ),
(40,  "Walt Disney Pictures",    "Estados Unidos", "Burbank, California"       ),
(50,  "20th Century Studios",    "Estados Unidos", "Los Angeles, California"   ),
(60,  "Studio Ghibli",           "Japon",          "Koganei, Tokio"            ),
(70,  "Sony Pictures",           "Estados Unidos", "Culver City, California"   ),
(80,  "A24",                     "Estados Unidos", "Nueva York"                ),
(90,  "Universal Pictures",      "Estados Unidos", "Universal City, California"),
(100, "DreamWorks Animation",    "Estados Unidos", "Glendale, California"      ),
(110, "Lionsgate Films",         "Estados Unidos", "Santa Monica, California"  ),
(120, "Columbia Pictures",       "Estados Unidos", "Culver City, California"   ),
(130, "MGM Studios",             "Estados Unidos", "Beverly Hills, California" ),
(140, "Miramax",                 "Estados Unidos", "Los Angeles, California"   ),
(150, "Focus Features",          "Estados Unidos", "New York City"             ),
(160, "Summit Entertainment",    "Estados Unidos", "Santa Monica, California"  ),
(170, "Amblin Entertainment",    "Estados Unidos", "Universal City, California"),
(180, "Blumhouse Productions",   "Estados Unidos", "Los Angeles, California"   ),
(190, "Working Title Films",     "Reino Unido",    "Londres"                   ),
(200, "Toho Co.",                "Japon",          "Chiyoda, Tokio"            );

-- INSERTS DE USUARIO
insert into usuario (id_usuario, username, correo, contrasena) values
(2026067, "diego_esteban",    "diego.raguay@kinal.edu.gt",   "Password2026" ),
(101,     "sparko_mc",        "sparko.rhymes@email.com",     "rapbattle2026"),
(106,     "profe_kinal",      "profe@kinal.edu.gt",          "Admin2026"    ),
(107,     "cine_adicto",      "fan@email.com",               "PelisGratis"  ),
(108,     "estudiante_in4cm", "alumno@kinal.edu.gt",         "KinalPass"    ),
(109,     "maria_flores",     "mflores@gmail.com",           "Flores2026"   ),
(110,     "carlos_ramirez",   "cramirez@yahoo.com",          "Carlos123"    ),
(111,     "ana_lopez",        "alopez@hotmail.com",          "AnaPass1"     ),
(112,     "pedro_juarez",     "pjuarez@gmail.com",           "Pedro2026"    ),
(113,     "lucia_mendez",     "lmendez@email.com",           "LuciaM26"     ),
(114,     "jorge_castillo",   "jcastillo@kinal.edu.gt",      "JorgeCas1"    ),
(115,     "sofia_vasquez",    "svasquez@gmail.com",          "SofiaV26"     ),
(116,     "mario_gomez",      "mgomez@yahoo.com",            "Mario2026"    ),
(117,     "elena_morales",    "emorales@hotmail.com",        "Elena2026"    ),
(118,     "jose_hernandez",   "jhernandez@gmail.com",        "JoseH2026"    ),
(119,     "valeria_ortiz",    "vortiz@email.com",            "Vale2026"     ),
(120,     "javier_flores",    "jflores2@gmail.com",          "Javi2026"     ),
(121,     "daniela_diaz",     "ddiaz@kinal.edu.gt",          "Dani2026"     ),
(122,     "ricardo_alonso",   "ralonso@yahoo.com",           "Rica2026"     ),
(123,     "gabriela_rojas",   "grojas@gmail.com",            "Gaby2026"     );

-- INSERTS DE ACTOR
insert into actor (id_actor, nombre_artistico, fecha_nacimiento, nacionalidad) values
(1001, "Elijah Wood",        "1981-01-28", "Estadounidense"             ),
(1002, "Christian Bale",     "1974-01-30", "Britanico"                  ),
(1003, "Scarlett Johansson", "1984-11-22", "Estadounidense"             ),
(1004, "Leonardo DiCaprio",  "1974-11-11", "Estadounidense"             ),
(1005, "Meryl Streep",       "1949-06-22", "Estadounidense"             ),
(1006, "Cate Blanchett",     "1969-05-14", "Australiana"                ),
(1007, "Michelle Yeoh",      "1962-08-06", "Malaya"                     ),
(1008, "Shameik Moore",      "1995-05-04", "Estadounidense"             ),
(1009, "Tom Hardy",          "1977-09-15", "Britanico"                  ),
(1010, "Natalie Portman",    "1981-06-09", "Israelí-Estadounidense"     ),
(1011, "Robert Downey Jr.",  "1965-04-04", "Estadounidense"             ),
(1012, "Chadwick Boseman",   "1976-11-29", "Estadounidense"             ),
(1013, "Viola Davis",        "1965-08-11", "Estadounidense"             ),
(1014, "Joaquin Phoenix",    "1974-10-28", "Estadounidense"             ),
(1015, "Timothee Chalamet",  "1995-12-27", "Estadounidense-Frances"     ),
(1016, "Zendaya Coleman",    "1996-09-01", "Estadounidense"             ),
(1017, "Adam Driver",        "1983-11-19", "Estadounidense"             ),
(1018, "Florence Pugh",      "1996-01-03", "Britanica"                  ),
(1019, "Oscar Isaac",        "1979-03-09", "Guatemalteco-Estadounidense"),
(1020, "Ana de Armas",       "1988-04-30", "Cubana-Espanola"            );

-- INSERTS DE PAPEL
insert into papel (id_papel, nombre_personaje) values
(1,  "Frodo Bolson"         ),
(2,  "Bruce Wayne / Batman" ),
(3,  "Natasha Romanoff"     ),
(4,  "Dom Cobb"             ),
(5,  "Miranda Priestly"     ),
(6,  "Evelyn Wang"          ),
(7,  "Miles Morales"        ),
(8,  "Eames"                ),
(9,  "Padme Amidala"        ),
(10, "Tony Stark"           ),
(11, "TChalla"              ),
(12, "Amanda Waller"        ),
(13, "Arthur Fleck / Joker" ),
(14, "Paul Atreides"        ),
(15, "Chani"                ),
(16, "Kylo Ren"             ),
(17, "Yelena Belova"        ),
(18, "Phasma"               ),
(19, "Duke Leto"            ),
(20, "Paloma"               );

-- INSERTS DE PELICULA 
insert into pelicula (id_pelicula, titulo_peli, anio_salida, clasificacion_edad, id_estudio) values
(501, "El Senor de los Anillos: La Comunidad del Anillo", "2001-12-19", 13,  20),
(502, "Batman Begins",                                    "2005-06-15", 13,  10),
(503, "Iron Man",                                         "2008-05-02",  7,  70),
(504, "El Rey Leon",                                      "2019-07-19",  0,  40),
(505, "Avatar",                                           "2009-12-18", 13,  50),
(506, "Titanic",                                          "1997-12-19", 13,  30),
(507, "El Viaje de Chihiro",                              "2001-07-20",  0,  60),
(508, "Spider-Man: Across the Spider-Verse",              "2023-06-02",  7,  70),
(509, "Everything Everywhere All at Once",                "2022-03-25", 15,  80),
(510, "Inception",                                        "2010-07-16", 13,  10),
(511, "Dune",                                             "2021-10-22", 13,  10),
(512, "Joker",                                            "2019-10-04", 17,  10),
(513, "Black Panther",                                    "2018-02-16",  7,  70),
(514, "Her",                                              "2013-12-18", 13,  80),
(515, "Shrek",                                            "2001-05-18",  0, 100),
(516, "El Precio del Manana",                             "2011-10-28", 13,  30),
(517, "Midsommar",                                        "2019-07-03", 17,  80),
(518, "Oppenheimer",                                      "2023-07-21", 13,  10),
(519, "Godzilla Minus One",                               "2023-11-03", 13, 200),
(520, "The Whale",                                        "2022-12-09", 17,  80);

-- INSERTS DE ACTOR PELICULA
insert into pelicula_actor (id_pelicula_actor, id_pelicula, id_actor, id_papel) values
(1,  501, 1001,  1),
(2,  502, 1002,  2),
(3,  503, 1011, 10),
(4,  510, 1004,  4),
(5,  510, 1009,  8),
(6,  509, 1007,  6),
(7,  508, 1008,  7),
(8,  511, 1015, 14),
(9,  511, 1016, 15),
(10, 512, 1014, 13),
(11, 513, 1012, 11),
(12, 513, 1013, 12),
(13, 506, 1004,  4),
(14, 507, 1006,  3),
(15, 518, 1017, 16),
(16, 520, 1018, 17),
(17, 503, 1003,  3),
(18, 519, 1019, 19),
(19, 516, 1020, 20),
(20, 517, 1005,  5);

-- INSERTS DE LISTA FAVORITO
insert into lista_favorito (id_lista, nombre_lista, id_usuario) values
(9001, "Mis Favoritas de Fantasia",  2026067),
(9002, "Hip Hop Cinema",             101    ),
(9003, "Joyas de Animacion",         108    ),
(9004, "Peliculas de Accion",        109    ),
(9005, "Drama y Arte",               110    ),
(9006, "Sci-Fi Clasicos",            111    ),
(9007, "Terror Moderno",             112    ),
(9008, "Oscar Bait",                 113    ),
(9009, "Superhero Mix",              114    ),
(9010, "Noches de Cine",             115    ),
(9011, "Solo con Subtitulos",        116    ),
(9012, "Animacion para Todos",       117    ),
(9013, "Comedias Favoritas",         118    ),
(9014, "Thrillers Adictivos",        119    ),
(9015, "Documentales Cool",          120    ),
(9016, "Peliculas Japonesas",        121    ),
(9017, "Lista Kinal 2026",           122    ),
(9018, "Maratones de Fin de Semana", 123    ),
(9019, "Top Critica",                106    ),
(9020, "Pendientes",                 107    );

-- INSERTS DE LISTA PELI FAVORITA
insert into lista_fav_peli (id_lista_fav_peli, id_lista, id_pelicula) values
(1,  9001, 501),
(2,  9001, 502),
(3,  9003, 507),
(4,  9002, 508),
(5,  9004, 503),
(6,  9005, 509),
(7,  9006, 510),
(8,  9007, 517),
(9,  9008, 512),
(10, 9009, 513),
(11, 9010, 506),
(12, 9011, 519),
(13, 9012, 515),
(14, 9013, 504),
(15, 9014, 511),
(16, 9015, 518),
(17, 9016, 507),
(18, 9017, 508),
(19, 9018, 505),
(20, 9019, 520);


-- -----------------------
-- INSERTS CON SP (CRUD)------
-- ----------------------- 

-- Peliculas
call sp_crear_pelicula(601, "The Dark Knight",     "2008-07-18", 13, 10);
call sp_crear_pelicula(602, "Interstellar",        "2014-11-07", 13, 10);
call sp_crear_pelicula(603, "El Gran Hotel Budapest", "2014-03-28", 7, 150);
call sp_crear_pelicula(604, "Parasite",            "2019-05-30", 15, 150);
call sp_crear_pelicula(605, "La La Land",          "2016-12-09", 13, 110);

-- Actores
call sp_crear_actor(1021, "Ryan Gosling",   "1980-11-12", "Canadiense");
call sp_crear_actor(1022, "Margot Robbie",  "1990-07-02", "Australiana");
call sp_crear_actor(1023, "Pedro Pascal",   "1975-04-02", "Chileno");
call sp_crear_actor(1024, "Sydney Sweeney", "1997-09-12", "Estadounidense");
call sp_crear_actor(1025, "Paul Mescal",    "1996-02-02", "Irlandes");

-- Usuarios
call sp_crear_usuario(2026117, "joaquin_sanchez", "jsanchez@kinal.edu.gt", "Joaco2026");
call sp_crear_usuario(124, "fernanda_luna",   "fluna@gmail.com",      "Fer2026");
call sp_crear_usuario(125, "kevin_salazar",   "ksalazar@email.com",   "Kevin2026");
call sp_crear_usuario(126, "andrea_reyes",    "areyes@gmail.com",     "Andre2026");
call sp_crear_usuario(127, "pablo_moreno",    "pmoreno@email.com",    "Pablo2026");

-- Listas de favoritos
call sp_crear_lista(9021, "Cine Latinoamericano",  2026117);
call sp_crear_lista(9022, "Peliculas de los 90s",  124);
call sp_crear_lista(9023, "Clasicos de Culto",     125);
call sp_crear_lista(9024, "Solo Nominadas al Oscar", 126);
call sp_crear_lista(9025, "Directores Favoritos",  127);

-- Lista peli fav
call sp_crear_lista_fav_peli(21, 9021, 519);
call sp_crear_lista_fav_peli(22, 9022, 506);
call sp_crear_lista_fav_peli(23, 9023, 510);
call sp_crear_lista_fav_peli(24, 9024, 518);
call sp_crear_lista_fav_peli(25, 9025, 511);


-- Vistas simples
select * from vw_estudios;
select * from vw_usuarios;
select * from vw_actores;
select * from vw_papeles;
select * from vw_peliculas;
select * from vw_pelicula_actor;
select * from vw_listas_favorito;
select * from vw_lista_fav_peli;

-- Vistas completas
select * from vw_peliculas_con_estudio;
select * from vw_reparto_completo;
select * from vw_reporte_general_streaming;
