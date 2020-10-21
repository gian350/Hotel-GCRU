
CREATE TABLE Habitaciones(
  idHabitacion INT AUTO_INCREMENT  PRIMARY KEY,
  idCategoria INT NOT NULL,
  estadoActual VARCHAR(250) NOT NULL
);

CREATE TABLE Categorias(
  idCategoria INT AUTO_INCREMENT  PRIMARY KEY,
  Nombre VARCHAR(250) NOT NULL,
  CantidadLimite INT NOT NULL
);

CREATE TABLE Usuario(
  idUsuario INT AUTO_INCREMENT  PRIMARY KEY,
  Nombre VARCHAR(250) NOT NULL,
  DNI CHAR(8) NOT NULL,
  Rol VARCHAR(250) NOT NULL
);

CREATE TABLE HabitacionUsuarioReserva(
  idUsuario INT NOT NULL,
  idHabitacion INT NOT NULL,
  fechaReserva DATE,
  fechaInicio DATE,
  fechaFin DATE
);


Alter table HabitacionUsuarioReserva 
add constraint PK_HabiUserReserva primary key(idUsuario,idHabitacion);

Alter table Habitaciones
add constraint FK_Habi_Cate foreign key (idCategoria)
references Categorias(idCategoria);

Alter table HabitacionUsuarioReserva
add constraint FK_User_Reser foreign key (idUsuario)
references Usuario(idUsuario);

Alter table HabitacionUsuarioReserva
add constraint FK_Habi_Reser foreign key (idHabitacion)
references Habitaciones(idHabitacion);