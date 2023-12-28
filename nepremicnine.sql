drop table if exists Nepremicnine;
drop table if exists Uporabnik;
drop table if exists Termin_rezervacija;
drop table if exists Ocena;
drop table if exists Priljubljene;
drop table if exists Tip_uporabnika;
drop table if exists Tip_nepremicnine;
drop table if exists Naslov;
drop table if exists Posta;

create table Nepremicnine(
	idNepremicnine INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	naziv varchar(45) not null,
    opis varchar(45) not null,
    slika varchar(45) not null,
    cena varchar(45) not null,
    TK_Uporabnik int not null,
    TK_Naslov int not null,
    TK_Tip_nepremicnine int not null
);

create table Uporabnik(
	idUporabnik INT primary key auto_increment not null,
    ime varchar(45) not null,
    priimek varchar(45) not null,
    gmail varchar(45) not null,
    geslo varchar(45) not null,
    telefonska varchar(45) not null,
    TK_Tip_uporabnika INT not null
);

create table Termin_rezervacija(
	idTermin_rezervacija int primary key not null auto_increment,
    datum DATE not null,
    cas TIME not null,
    TK_Uporabnik int not null,
    TK_Nepremicnine int not null
);

create table Ocena(
	idOcena int primary key auto_increment not null,
	ocena int not null,
    TK_Nepremicnine int not null,
    TK_Uporabnik INT not null
);

create table Priljubljene(
	idPriljubljene int primary key not null auto_increment,
    TK_Nepremicnine int not null,
    TK_Uporabnik int not null
);

create table Tip_uporabnika(
	idTip_uporabnika int primary key not null auto_increment,
    tipUporabnika varchar(45) not null
);

create table Tip_nepremicnine(
	idTip_nepremicnine int primary key not null auto_increment,
    tipNepremicnine varchar(45) not null
);

create table Naslov(
	idNaslov int primary key not null auto_increment,
    ulica Varchar(45) not null,
    st varchar(45),
    TK_Posta INT not null
);

create table Posta(
	stPoste int primary key not null auto_increment,
    kraj varchar(45) not null
);

alter table Nepremicnine add constraint TK_uporabnik_nepremicnina foreign key (TK_Uporabnik) references Uporabnika(idUporabnik) on delete cascade;
alter table Nepremicnine add constraint TK_naslov_nepremicnina foreign key (TK_Naslov) references Naslov(idNaslov) on delete cascade;
alter table Nepremicnine add constraint TK_tip_nepremicnine_nepremicnina foreign key (TK_Tip_nepremicnine) references Tip_nepremicnine(idTip_nepremicnine) on delete cascade;
alter table Uporabnik add constraint TK_Tip_uporabnika_uporabnik foreign key (TK_Tip_uporabnika) references Tip_uporabnika(idTip_uporabnika) on delete cascade;
alter table Termin_rezervacija add constraint TK_Uporabnika foreign key (TK_Uporabnik) references Uporabnik(idUporabnik) on delete cascade;
alter table Termin_rezervacija add constraint TK_Nepremicnina foreign key (TK_Nepremicnina) references Nepremicnine(idNepremicnine) on delete cascade;
alter table Ocena add constraint TK_Nepremicnina_ocena foreign key (TK_Nepremicnina) references Nepremicnine(idNepremicnine) on delete cascade;
alter table Ocena add constraint TK_Uporabnik_ocena foreign key (TK_Uporabnik) references Uporabnik(idUporabnik) on delete cascade;
alter table Priljubljene add constraint TK_Nepremicnine_priljubljene foreign key (TK_Nepremicnina) references Nepremicnine(idNepremicnine) on delete cascade;
alter table Priljubljene add constraint TK_Uporabnik_priljubljene foreign key (TK_Uporabnik) references Uporabnik(idUporabnik) on delete cascade;
alter table Naslov add constraint TK_Posta_naslov foreign key (TK_Posta) references Posta(idPosta) on delete cascade;