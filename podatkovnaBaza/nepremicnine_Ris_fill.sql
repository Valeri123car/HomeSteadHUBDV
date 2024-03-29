use homesteaddv;


INSERT INTO Posta(id, kraj)
VALUES(1000, "Ljubljana"),
(2000, "Maribor"),
(3000, "Celje"),
(3240, "Smarje pri Jelsah"),
(3230, "Sentjur"),
(9000, "Murska Sobota"),
(3254, "Podcetrtek"),
(3270, "Lasko"),
(3305, "Vransko"),
(3325, "Sostanj");


INSERT INTO Naslov(ulica, st, posta_id)
VALUES
("Hanover",12,9000),
("Leroy",34754,9000),
("Dennis",29,9000),
("Talisman",6684,3000),
("East",1,3000),
("Roxbury",37684,1000),
("Maryland",43,9000),
("Myrtle",48799,3270),
("Donald",926,3000),
("Merrick",43,3240),
("Barnett",48011,9000),
("Meadow Valley",82349,2000),
("Green Ridge",5928,9000),
("Melrose",4,1000),
("Randy",6,1000),
("Harper",794,3270),
("Duke",2093,2000),
("Harper",59523,3000),
("Carey",51267,9000),
("Dorton",3028,2000),
("Milwaukee",30814,3240),
("Oak Valley",85,3325),
("Moulton",579,3254),
("Brentwood",5454,3000),
("Mifflin",92705,3270),
("Florence",48,3240),
("Sutherland",8,9000),
("Old Gate",52,2000),
("Homewood",59,3240),
("Rieder",47532,3270),
("Ridgeview",118,1000),
("Quincy",7888,3000),
("Fordem",42,3325),
("Mosinee",83248,3270),
("Buhler",1021,2000),
("Novick",60,9000),
("Corscot",62923,3230),
("Moose",86824,2000),
("Eliot",7497,3230),
("Jackson",2,3240),
("Carioca",4750,2000),
("Park Meadow",38868,3270),
("Banding",1452,3270),
("Katie",4107,3325),
("Dovetail",74951,3270),
("Memorial",505,9000),
("Schmedeman",6,3254),
("Westerfield",43921,3230),
("Fulton",62720,3240),
("Dwight",971,2000);

INSERT INTO Tip_uporabnika(tip_Uporabnika)
VALUES
("Admin"),
("Uporabnik");

INSERT INTO Tip_nepremicnine(tip_Nepremicnine)
VALUES
("novogradnja"),
("javna drazba"),
("montazna hisa");

INSERT INTO Uporabnik(ime, priimek, gmail, geslo, telefonska, tip_uporabnika_id_tip_uporabnika)
VALUES 
("Nekdo","Neki", "nekdo@gmail.com", "anekdo123", "000111222", 2),
('John', 'Doe', 'johndoe@gmail.com', 'password123', '123456789', '2'),
('Alice', 'Smith', 'alicesmith@gmail.com', 'securepwd456', '987654321', 2),
('Bob', 'Johnson', 'bobjohnson@gmail.com', 'letmein789', '111222333', 2),
('Eva', 'Williams', 'evawilliams@gmail.com', 'pass1234', '555666777', 2),
('Michael', 'Anderson', 'michaelanderson@gmail.com', 'password567', '888777666', 2),
('Sophia', 'Brown', 'sophiabrown@gmail.com', 'letmein123', '999000111', 2),
('William', 'Davis', 'williamdavis@gmail.com', 'pass4567', '123123123', 2),
('Olivia', 'Jones', 'oliviajones@gmail.com', 'securepwd789', '456789123', 2),
('James', 'Wilson', 'jameswilson@gmail.com', 'password890', '987654321', 2),
('Mia', 'Lee', 'mialee@gmail.com', 'letmein567', '111222333', 2);



INSERT INTO Nepremicnine(naziv, opis, slika, cena, uporabnik_id_uporabnik, naslov_id_naslov, tip_nepremicnine_id_tip_nepremicnine)
VALUES
('Building A', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus.', 'ABCDEF1234', '150000', 2, 1, 1),
('Cozy Apartment', 'Sed aliquam hendrerit metus, eu malesuada neque dictum in. Suspendisse nec facilisis justo.', 'GHIJKL6789', '200000', 3, 2, 2),
('Luxury Villa', 'In bibendum sapien vel metus tempor cursus. Maecenas vulputate odio quis nibh viverra.', 'MNOPQR1234', '350000', 4, 3, 3),
('Downtown Loft', 'Quisque at volutpat mi. Nulla facilisi. Cras ac hendrerit lorem.', 'STUVWX6789', '180000', 5, 4, 1),
('Riverside Cabin', 'Pellentesque sit amet tincidunt odio. In hac habitasse platea dictumst.', 'YZABCD1234', '280000', 6, 5, 2),
('Oceanfront Condo', 'Fusce eget dui libero. Maecenas in magna lacinia, dignissim mi et, sagittis velit.', 'EFGHIJ6789', '240000', 7, 6, 3),
('Mountain Chalet', 'Cras nec augue eget arcu tristique facilisis ac at tellus. Ut at felis ligula.', 'KLMNOP1234', '310000', 8, 7, 1),
('Historic Mansion', 'Vestibulum ac hendrerit arcu. Praesent dictum sit amet purus ut convallis.', 'QRSTUVWXYZ89', '170000', 9, 8, 2),
('Lakeview Cottage', 'Proin sit amet elementum velit. Curabitur ullamcorper in quam in tristique.', '1234ABCD01', '270000', 10, 9, 3),
('Skyline Penthouse', 'Suspendisse euismod velit et elit pharetra, eget cursus tortor posuere.', '2345EFGH23', '190000', 11, 10, 1),
('Sunny Bungalow', 'Nunc nec nunc vel lorem tincidunt auctor eu nec odio. Sed posuere euismod nunc.', '5678IJKL56', '340000', 2, 11, 2),
('Rural Retreat', 'Fusce venenatis quam ut quam pellentesque, sit amet lacinia nunc congue.', '9012MNOP89', '220000', 3, 12, 3),
('Urban Oasis', 'Cras dapibus neque sit amet ante tincidunt, sit amet malesuada justo convallis.', '3456QRST12', '280000', 4, 13, 1),
('Lakeside Cabin', 'Sed laoreet purus a velit tincidunt, vel facilisis risus sodales.', '7890UVWX34', '360000', 5, 14, 2),
('Modern Apartment', 'Morbi convallis fringilla odio at auctor. Curabitur luctus vehicula tellus.', '1234YZAB56', '210000', 6, 15, 3),
('Country House', 'Etiam id odio eget velit venenatis volutpat. Phasellus ac risus justo.', '7890CDEF78', '380000', 7, 16, 1),
('Downtown Condo', 'Nullam fringilla quam in urna commodo, eu tristique ipsum malesuada.', '2345GHIJ91', '260000', 8, 17, 2),
('Mountain Cabin', 'In volutpat dolor nec tincidunt. Duis scelerisque dolor non ligula consectetur.', '5678KLMN12', '320000', 9, 18, 3),
('Beachfront Villa', 'Praesent eu urna nec odio feugiat ultrices. In vel ligula in tortor.', '9012OPQR34', '270000', 10, 19, 1),
('City Loft', 'Fusce sit amet augue in libero faucibus vehicula. Integer vel cursus arcu.', '3456STUV56', '230000', 11, 20, 2),
('Countryside Retreat', 'Aenean volutpat nisl nec augue volutpat, in tincidunt justo tristique.', '7890WXYZ78', '390000', 2, 21, 3),
('Waterfront Mansion', 'Curabitur convallis felis a purus egestas, at tincidunt elit vehicula.', '1234ABCD91', '250000', 3, 22, 1),
('Forest Cabin', 'Phasellus dictum metus sit amet ante vulputate, in bibendum odio tincidunt.', '2345EFGH12', '290000', 4, 23, 2),
('Downtown Penthouse', 'Proin nec risus nec nulla euismod ultrices. Sed bibendum tellus sed lorem.', '5678IJKL34', '350000', 5, 24, 3),
('Seaside Cottage', 'Cras vel sapien eu dolor interdum rhoncus. Nulla a odio in lectus.', '9012MNOP56', '260000', 6, 25, 1),
('Hillside Chalet', 'Vivamus et ipsum id nulla sollicitudin dapibus. Phasellus id leo dignissim.', '1234YZAB78', '220000', 7, 26, 2),
('Historic House', 'Ut a quam vel urna sollicitudin tincidunt nec eu purus. Sed vehicula.', '7890CDEF91', '300000', 8, 27, 3),
('City Apartment', 'Sed vestibulum purus id odio auctor, eget ultrices purus dictum.', '3456GHIJ12', '280000', 9, 28, 1),
('Rural Cottage', 'Cras sed est non dui vestibulum facilisis. Integer eu nisl tincidunt.', '5678KLMN34', '240000', 10, 29, 2),
('Mountain Retreat', 'Vivamus tincidunt odio in arcu bibendum, sed eleifend nisl malesuada.', '9012OPQR56', '370000', 11, 30, 3),
('Beach House', 'Suspendisse eu quam at augue sodales bibendum. Nunc id ex et justo.', '1234ABCD78', '270000', 2, 31, 1),
('Urban Condo', 'Donec congue elit nec urna dignissim, non egestas orci condimentum.', '2345EFGH91', '230000', 3, 32, 2),
('Cabin Getaway', 'Fusce ut neque sed lectus auctor volutpat. Suspendisse vel purus venenatis.', '5678IJKL12', '340000', 4, 33, 3),
('Lakefront Lodge', 'Vestibulum sit amet metus eu purus iaculis varius. Nulla at aliquam.', '9012MNOP34', '190000', 5, 34, 1),
('Skyline Apartment', 'Morbi nec felis a nunc euismod dictum. Nullam id est a massa.', '3456QRST56', '320000', 6, 35, 2),
('Riverfront Cabin', 'Proin vestibulum nunc at arcu vehicula, eget dignissim est consectetur.', '7890UVWX78', '310000', 7, 36, 3),
('Mountain Lodge', 'Duis in velit vel purus dictum tristique. Vestibulum ac venenatis tellus.', '1234YZAB91', '360000', 8, 37, 1),
('City Penthouse', 'Praesent in nisl a mi malesuada facilisis. Nulla facilisi. Suspendisse dapibus.', '2345CDEF12', '250000', 9, 38, 2),
('Beachside Villa', 'Fusce quis neque vel leo congue tristique in nec erat. Sed venenatis.', '5678GHIJ34', '370000', 10, 39, 3),
('Rural Retreat', 'Nulla ac sem at odio iaculis consectetur eu eu turpis. Proin eget.', '9012KLMN56', '290000', 11, 40, 1),
('Luxury Mansion', 'Duis volutpat libero a arcu ultrices, eget dictum est laoreet.', '3456OPQR78', '270000', 2, 41, 2),
('Countryside Cottage', 'Morbi vehicula dolor a odio dapibus, sed fringilla elit vehicula.', '7890STUV91', '260000', 3, 42, 3),
('Downtown Apartment', 'Praesent sit amet velit nec urna tincidunt convallis. Nunc eu euismod.', '1234WXYZ12', '210000', 4, 43, 1),
('Mountain Cabin', 'Sed non neque nec risus bibendum tristique. Nulla et eros dictum.', '5678EFGH34', '350000', 5, 44, 2),
('Lakeside Villa', 'Cras ac augue nec leo vehicula bibendum. Proin in arcu in.', '9012IJKL56', '230000', 6, 45, 3),
('Urban Loft', 'Sed id quam vel augue fringilla dictum. Nulla facilisi. Sed volutpat.', '3456MNOP78', '310000', 7, 46, 1),
('Forest Retreat', 'Donec vehicula mauris id nunc fringilla, eget bibendum odio dictum.', '7890QRST91', '240000', 8, 47, 2),
('Seaside Cabin', 'Morbi sit amet justo nec purus auctor vulputate. Integer vel leo.', '1234UVWX12',  "360000", 9, 48, 3),
('City Condo', 'Suspendisse sit amet odio in nunc tincidunt venenatis. Curabitur eget mauris.', '5678YZAB34', "280000", 10, 49, 1),
('Beachfront Chalet', 'Proin volutpat risus non ipsum convallis, eget dignissim risus condimentum.', '9012CDEF56', "380000", 11, 5, 2);


INSERT INTO Ocena (id_ocena, ocena, nepremicnine_id_Nepremicnine, uporabnik_id_Uporabnik) VALUES
    (1, 8, 15, 3),
    (2, 4, 7, 9),
    (3, 2, 23, 7),
    (4, 9, 45, 4),
    (5, 6, 10, 8),
    (6, 3, 37, 1),
    (7, 5, 2, 5),
    (8, 7, 49, 6),
    (9, 1, 18, 2),
    (10, 10, 31, 10),
    (11, 8, 5, 3),
    (12, 4, 42, 8),
    (13, 2, 17, 5),
    (14, 9, 29, 10),
    (15, 6, 12, 2),
    (16, 3, 48, 7),
    (17, 5, 3, 9),
    (18, 7, 21, 1),
    (19, 1, 39, 6),
    (20, 10, 9, 4),
    (21, 8, 36, 8),
    (22, 4, 14, 5),
    (23, 2, 27, 7),
    (24, 9, 46, 10),
    (25, 6, 20, 2),
    (26, 3, 40, 9),
    (27, 5, 6, 1),
    (28, 7, 32, 6),
    (29, 1, 16, 3),
    (30, 10, 24, 4),
    (31, 8, 1, 8),
    (32, 4, 44, 5),
    (33, 2, 19, 7),
    (34, 9, 38, 10),
    (35, 6, 11, 2),
    (36, 3, 50, 9),
    (37, 5, 28, 1),
    (38, 7, 4, 6),
    (39, 1, 35, 3),
    (40, 10, 13, 4),
    (41, 8, 26, 8),
    (42, 4, 22, 5),
    (43, 2, 47, 7),
    (44, 9, 30, 10),
    (45, 6, 41, 2),
    (46, 3, 33, 9),
    (47, 5, 7, 1),
    (48, 7, 25, 6),
    (49, 1, 43, 3),
    (50, 10, 34, 4);
    
    INSERT INTO Priljubljena (id_priljubljena, uporabnik_id_Uporabnik, nepremicnine_id_Nepremicnine) VALUES
    (1, 3, 15),
    (2, 9, 7),
    (3, 7, 23),
    (4, 4, 45),
    (5, 8, 10),
    (6, 1, 37),
    (7, 5, 2),
    (8, 6, 49),
    (9, 2, 18),
    (10, 10, 31),
    (11, 3, 5),
    (12, 8, 42),
    (13, 5, 17),
    (14, 10, 29),
    (15, 2, 12),
    (16, 7, 48),
    (17, 9, 3),
    (18, 1, 21),
    (19, 6, 39),
    (20, 4, 9),
    (21, 8, 36),
    (22, 5, 14),
    (23, 7, 27),
    (24, 10, 46),
    (25, 2, 20),
    (26, 9, 40),
    (27, 1, 6),
    (28, 6, 32),
    (29, 3, 16),
    (30, 4, 24),
    (31, 8, 1),
    (32, 5, 44),
    (33, 7, 19),
    (34, 10, 38),
    (35, 2, 11),
    (36, 9, 50),
    (37, 1, 28),
    (38, 6, 4),
    (39, 3, 35),
    (40, 4, 13),
    (41, 8, 26),
    (42, 5, 22),
    (43, 7, 47),
    (44, 10, 30),
    (45, 2, 41),
    (46, 9, 33),
    (47, 1, 7),
    (48, 6, 25),
    (49, 3, 43),
    (50, 4, 34);
    
    
    INSERT INTO Termin_rezervacija (id_termin_rezervacija, uporabnik_id_Uporabnik, nepremicnine_id_Nepremicnine, datum, cas) VALUES
    (1, 5, 28, '2024-01-10', '08:30:00'),
    (2, 9, 7, '2024-02-15', '10:45:00'),
    (3, 2, 41, '2024-03-20', '14:15:00'),
    (4, 7, 23, '2024-04-25', '16:30:00'),
    (5, 1, 36, '2024-05-05', '09:00:00'),
    (6, 4, 14, '2024-06-10', '11:45:00'),
    (7, 8, 49, '2024-07-15', '13:30:00'),
    (8, 3, 19, '2024-08-20', '15:45:00'),
    (9, 6, 32, '2024-09-25', '08:00:00'),
    (10, 10, 45, '2024-10-05', '10:15:00'),
    (11, 5, 2, '2024-11-10', '12:30:00'),
    (12, 1, 43, '2024-12-15', '14:45:00'),
    (13, 7, 29, '2024-01-20', '16:00:00'),
    (14, 2, 12, '2024-02-25', '08:30:00'),
    (15, 9, 37, '2024-03-05', '10:45:00'),
    (16, 4, 8, '2024-04-10', '14:15:00'),
    (17, 8, 21, '2024-05-15', '16:30:00'),
    (18, 3, 50, '2024-06-20', '09:00:00'),
    (19, 6, 4, '2024-07-25', '11:45:00'),
    (20, 10, 18, '2024-08-05', '13:30:00'),
    (21, 5, 47, '2024-09-10', '15:45:00'),
    (22, 1, 33, '2024-10-15', '08:00:00'),
    (23, 7, 26, '2024-11-20', '10:15:00'),
    (24, 2, 5, '2024-12-25', '12:30:00'),
    (25, 9, 39, '2024-01-30', '14:45:00'),
    (26, 4, 15, '2024-02-05', '16:00:00'),
    (27, 8, 24, '2024-03-10', '08:30:00'),
    (28, 3, 46, '2024-04-15', '10:45:00'),
    (29, 6, 9, '2024-05-20', '14:15:00'),
    (30, 10, 31, '2024-06-25', '16:30:00'),
    (31, 5, 13, '2024-07-05', '09:00:00'),
    (32, 1, 35, '2024-08-10', '11:45:00'),
    (33, 7, 22, '2024-09-15', '13:30:00'),
    (34, 2, 48, '2024-10-20', '15:45:00'),
    (35, 9, 11, '2024-11-25', '08:00:00'),
    (36, 4, 38, '2024-12-05', '10:15:00'),
    (37, 8, 3, '2024-01-10', '12:30:00'),
    (38, 3, 42, '2024-02-15', '14:45:00'),
    (39, 6, 27, '2024-03-20', '16:00:00'),
    (40, 10, 16, '2024-04-25', '08:30:00'),
    (41, 5, 1, '2024-05-05', '10:45:00'),
    (42, 1, 44, '2024-06-10', '14:15:00'),
    (43, 7, 30, '2024-07-15', '16:30:00'),
    (44, 2, 40, '2024-08-20', '09:00:00'),
    (45, 9, 7, '2024-09-25', '11:45:00'),
    (46, 4, 23, '2024-10-05', '13:30:00'),
    (47, 8, 37, '2024-11-10', '15:45:00'),
    (48, 3, 14, '2024-12-15', '08:00:00'),
    (49, 6, 49, '2024-01-20', '10:15:00'),
    (50, 10, 20, '2024-02-25', '12:30:00');