SET GLOBAL time_zone = '-6:00';

DROP SCHEMA IF EXISTS clinicaOdontologica;
DROP USER IF exists 'administrador_local'@'%';

CREATE DATABASE clinicaOdontologica;
create user 'administrador_local'@'%' identified by 'AdminLocal123_';
grant all privileges on clinicaOdontologica.* to 'administrador_local'@'%';
flush privileges;

USE clinicaOdontologica;

CREATE TABLE clinica (
  idClinica int NOT NULL AUTO_INCREMENT,
  nombreClinica VARCHAR(15) NOT NULL,
  direccion VARCHAR(120) NOT NULL,
  telefono1 VARCHAR(8) NOT NULL,
  email varchar(30) NOT NULL,
  CONSTRAINT PK_clinica
  PRIMARY KEY (idClinica)
);

CREATE TABLE empleado (
  cedulaEmpleado varchar(15) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  username varchar(15) NOT NULL,
  pass varchar(25) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 VARCHAR(8) NOT NULL,
  email varchar(30) NOT NULL,
  idClinica int NOT NULL AUTO_INCREMENT,
  CONSTRAINT PK_empleado
  PRIMARY KEY (cedulaEmpleado),
  CONSTRAINT FK_empleado_clinica
  FOREIGN KEY (idClinica)
  REFERENCES clinica(idClinica)
);

CREATE TABLE odontologo (
  cedulaOdontologo numeric(9,0) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  username varchar(15) NOT NULL,
  pass varchar(25) NOT NULL,
  direccion VARCHAR(100) NOT NULL,
  telefono1 VARCHAR(8) NOT NULL,
  email varchar(50) NOT NULL,
  idClinica int NOT NULL AUTO_INCREMENT,
  CONSTRAINT PK_odontologo
  PRIMARY KEY (cedulaOdontologo),
  CONSTRAINT FK_odontologo_clinica
  FOREIGN KEY (idClinica)
  REFERENCES clinica(idClinica)
);

CREATE TABLE especialidad (
  nombreEspecialidad varchar(25) NOT NULL,
  cedulaOdontologo numeric(9,0) NOT NULL,
  CONSTRAINT PK_especialidad
  PRIMARY KEY (nombreEspecialidad),
  CONSTRAINT FK_especialidad_odontologo
  FOREIGN KEY (cedulaOdontologo)
  REFERENCES odontologo(cedulaOdontologo)
);

CREATE TABLE administrador (
  cedulaAdmin VARCHAR(15) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  username varchar(15) NOT NULL,
  pass varchar(25) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 VARCHAR(8) NOT NULL,
  email varchar(30) NOT NULL,
  idClinica int NOT NULL AUTO_INCREMENT,
  CONSTRAINT PK_administrador
  PRIMARY KEY (cedulaAdmin),
  CONSTRAINT FK_administrador_clinica
  FOREIGN KEY (idClinica)
  REFERENCES clinica(idClinica)
);

CREATE TABLE paciente (
  nacional boolean NOT NULL DEFAULT true,
  cedulaPaciente VARCHAR(9) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  username varchar(15) NOT NULL,
  pass varchar(25) NOT NULL,
  fechaNacimiento date NOT NULL,
  edad int NOT NULL,
  sexo char(1) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  email varchar(30) NOT NULL,
  nombreEncargado varchar(25) NOT NULL,
  apellidoEncargado1 varchar(25) NOT NULL,
  apellidoEncargado2 varchar(25) NOT NULL,
  activo boolean NOT NULL default true,
  cedulaOdontologo numeric(9,0) NOT NULL,
  CONSTRAINT PK_paciente
  PRIMARY KEY (cedulaPaciente),
  CONSTRAINT FK_paciente_odontologo
  FOREIGN KEY (cedulaOdontologo)
  REFERENCES odontologo(cedulaOdontologo)
);

CREATE TABLE tratamiento (
  nombreTratamiento varchar(30) NOT NULL,
  costoTratamiento float NOT NULL,
  descripcionTratamiento tinytext NOT NULL,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_tratamiento
  PRIMARY KEY (nombreTratamiento),
  CONSTRAINT FK_tratamiento_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);


CREATE TABLE datosMedicos (
  idDatosMedicos int unsigned NOT NULL AUTO_INCREMENT,
  antecedentesPatologicosPersonales tinytext NOT NULL,
  antecedentesPatologicosFamiliares tinytext NOT NULL,
  antecedentesQuirurgicos tinytext NOT NULL,
  alergia boolean NOT NULL DEFAULT FALSE,
  alergiaDetalle varchar(50) NOT NULL,
  medicamentosConsumidos varchar(200) NOT NULL,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_datosMedicos
  PRIMARY KEY (idDatosMedicos),
  CONSTRAINT FK_datosMedicos_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE historiaDental (
  idHistoriaDental int unsigned NOT NULL AUTO_INCREMENT,
  ultimaVisitaDentista varchar(15) NOT NULL,
  numeroCepilladosDia int NOT NULL,
  usoHilo boolean NOT NULL DEFAULT FALSE,
  usoEnjuague boolean NOT NULL DEFAULT FALSE,
  tipoPastaDental varchar(15) NOT NULL,
  numeroComidasDia int NOT NULL,
  dietaMuyCariogenica boolean NULL DEFAULT FALSE,
  dietaPocoCariogenica boolean NULL DEFAULT FALSE,
  dietaNadaCariogenica boolean NULL DEFAULT FALSE,
  masAgua boolean NULL DEFAULT FALSE,
  igualAgua boolean NULL DEFAULT FALSE,
  menosAgua boolean NULL DEFAULT FALSE,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_historiaDental
  PRIMARY KEY (idHistoriaDental),
  CONSTRAINT FK_historiaDental_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE habitosParafuncionales (
  idhabitosParafuncionales int unsigned NOT NULL AUTO_INCREMENT,
  comeUnnas boolean NOT NULL DEFAULT FALSE,
  bruxismo boolean NOT NULL DEFAULT FALSE,
  ronca boolean NOT NULL DEFAULT FALSE,
  dormirBocaAbierta boolean NOT NULL DEFAULT FALSE,
  chuparDedo boolean NOT NULL DEFAULT FALSE,
  deglusionAtipica boolean NOT NULL DEFAULT FALSE,
  morderObjetos boolean NOT NULL DEFAULT FALSE,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_habitosParafuncionales
  PRIMARY KEY (idhabitosParafuncionales),
  CONSTRAINT FK_habitosParafuncionales_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE evolucion (
  idEvolucion int unsigned NOT NULL AUTO_INCREMENT,
  motivoConsulta TINYTEXT NOT NULL,
  presenciaDolor boolean NOT NULL DEFAULT FALSE,
  descripcion TINYTEXT NOT NULL,
  satisfechoConDentadura boolean NOT NULL DEFAULT FALSE,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_evolucion
  PRIMARY KEY (idEvolucion),
  CONSTRAINT FK_evolucion_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);

CREATE TABLE cita (
  idCita int unsigned NOT NULL AUTO_INCREMENT,
  motivoCita varchar(50) NOT NULL,
  fechaCita date NOT NULL,
  cedulaPaciente VARCHAR(8) NOT NULL,
  CONSTRAINT PK_citas
  PRIMARY KEY (idCita),
  CONSTRAINT FK_cita_paciente
  FOREIGN KEY (cedulaPaciente)
  REFERENCES paciente(cedulaPaciente)
);

insert into clinica (nombreClinica,direccion,telefono1,email) values ('Dental Pro','Edificio san pedro Business center, 100 mts este de la rotonda de la fuente de la hispanidad San Pedro, San José','84163513','dentalprocr@gmail.com');

insert into odontologo (cedulaOdontologo,nombre,apellido1,apellido2,username,pass,direccion,telefono1,email,idClinica) values ('701620535','Carolina','Vargas','Loría','carovar','caro123','San Jose Tibas','84723238','periodoncia.cvl@gmail.com',1),
('112440390','Andres','Gonzalez','Madriz','andresgon','andres123','San Jose Tibas','89962425','drandresgonzalezmadriz@gmail.com',1),
('112380352','Andres','Brenes','Carmona','andresbre','brenes123','San Jose San Francisco de Dos Rios','70941618','drbrenescarmona_prostodoncia@gmail.com',1),
('112580307','Melissa','Rojas','Zuñiga','meliroj','melisa123','San Jose Sabanilla Montes de Oca','83411162','odontopediatriacr@gmail.com',1),
('112500520','Tony','Sanchez','Achio','tonysan','tony123','San Jose San Pedro Montes de Oca','22368090','dr_tsanchez@hotmail.com',1),
('112050234','Silvia','Aragon','Matamoros','silvara','silvia123','San Jose Guayabos Curridabat','60208504','aragonsilvia8403@gmail.com',1);