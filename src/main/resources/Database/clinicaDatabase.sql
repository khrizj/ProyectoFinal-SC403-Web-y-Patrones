/**
*  Las dos siguientes instrucciones sólo se ejecutan una vez
*/
SET GLOBAL time_zone = '-6:00';

DROP SCHEMA IF EXISTS clinicaOdontologica;
DROP USER IF exists 'administrador_local'@'%';

CREATE DATABASE clinicaOdontologica;
create user 'administrador_local'@'%' identified by 'AdminLocal123_';
grant all privileges on clinicaOdontologica.* to 'administrador_local'@'%';
flush privileges;

USE clinicaOdontologica;

/*
* luego de crear el usuario y asignarlo no debiera de ejecutarse nuevamente
*/
CREATE TABLE clinica (
  idClinica int NOT NULL AUTO_INCREMENT,
  nombreClinica VARCHAR(15) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  email varchar(30) NOT NULL,
  CONSTRAINT PK_clinica
  PRIMARY KEY (idClinica)
);

CREATE TABLE empleado (
  cedulaEmpleado numeric(9,0) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  telefono2 numeric(9,0) NOT NULL,
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
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  telefono2 numeric(9,0) NOT NULL,
  email varchar(30) NOT NULL,
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
  cedulaAdmin numeric(9,0) NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  telefono2 numeric(9,0) NOT NULL,
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
  idPaciente int NOT NULL,
  nombre varchar(25) NOT NULL,
  apellido1 varchar(25) NOT NULL,
  apellido2 varchar(25) NOT NULL,
  fechaNacimiento date NOT NULL,
  edad int NOT NULL,
  sexo boolean NOT NULL DEFAULT false,
  direccion VARCHAR(40) NOT NULL,
  telefono1 numeric(9,0) NOT NULL,
  telefono2 numeric(9,0) NOT NULL,
  email varchar(30) NOT NULL,
  nombreEncargado varchar(25) NOT NULL,
  apellidoEncargado1 varchar(25) NOT NULL,
  apellidoEncargado2 varchar(25) NOT NULL,
  cedulaOdontologo numeric(9,0) NOT NULL,
  CONSTRAINT PK_paciente
  PRIMARY KEY (idPaciente),
  CONSTRAINT FK_paciente_odontologo
  FOREIGN KEY (cedulaOdontologo)
  REFERENCES odontologo(cedulaOdontologo)
);

CREATE TABLE tratamiento (
  nombreTratamiento varchar(30) NOT NULL,
  costoTratamiento float NOT NULL,
  descripcionTratamiento tinytext NOT NULL,
  idPaciente int NOT NULL,
  CONSTRAINT PK_tratamiento
  PRIMARY KEY (nombreTratamiento),
  CONSTRAINT FK_tratamiento_paciente
  FOREIGN KEY (idPaciente)
  REFERENCES paciente(idPaciente)
);


CREATE TABLE datosMedicos (
  idDatosMedicos int unsigned NOT NULL AUTO_INCREMENT,
  antecedentesPatologicosPersonales tinytext NOT NULL,
  antecedentesPatologicosFamiliares tinytext NOT NULL,
  antecedentesQuirurgicos tinytext NOT NULL,
  alergia boolean NOT NULL,
  alergiaDetalle varchar(50) NOT NULL,
  medicamentosConsumidos varchar(200) NOT NULL,
  idPaciente int NOT NULL,
  CONSTRAINT PK_datosMedicos
  PRIMARY KEY (idDatosMedicos),
  CONSTRAINT FK_datosMedicos_paciente
  FOREIGN KEY (idPaciente)
  REFERENCES paciente(idPaciente)
);

CREATE TABLE historiaDental (
  idHistoriaDental int unsigned NOT NULL AUTO_INCREMENT,
  ultimaVisitaDentista varchar(15) NOT NULL,
  numeroCepilladosDia int NOT NULL,
  usoHilo boolean NOT NULL,
  usoEnjuague boolean NOT NULL,
  tipoPastaDental varchar(15) NOT NULL,
  numeroComidasDia int NOT NULL,
  dietaMuyCariogenica boolean NOT NULL,
  dietaPocoCariogenica boolean NOT NULL,
  dietaNadaCariogenica boolean NOT NULL,
  masAgua boolean NOT NULL,
  igualAgua boolean NOT NULL,
  menosAgua boolean NOT NULL,
  idPaciente int NOT NULL,
  CONSTRAINT PK_historiaDental
  PRIMARY KEY (idHistoriaDental),
  CONSTRAINT FK_historiaDental_paciente
  FOREIGN KEY (idPaciente)
  REFERENCES paciente(idPaciente)
);

CREATE TABLE habitosParafuncionales (
  idhabitosParafuncionales int unsigned NOT NULL AUTO_INCREMENT,
  comeUnnas boolean NOT NULL,
  bruxismo boolean NOT NULL,
  ronca boolean NOT NULL,
  dormirBocaAbierta boolean NOT NULL,
  chuparDedo boolean NOT NULL,
  deglusionAtipica boolean NOT NULL,
  morderObjetos boolean NOT NULL,
  idPaciente int NOT NULL,
  CONSTRAINT PK_habitosParafuncionales
  PRIMARY KEY (idhabitosParafuncionales),
  CONSTRAINT FK_habitosParafuncionales_paciente
  FOREIGN KEY (idPaciente)
  REFERENCES paciente(idPaciente)
);

CREATE TABLE evolucion (
  idEvolucion int unsigned NOT NULL AUTO_INCREMENT,
  motivoConsulta varchar(50) NOT NULL,
  presenciaDolor boolean NOT NULL,
  descripcion varchar (150) NOT NULL,
  satisfechoConDentadura boolean NOT NULL,
  idPaciente int NOT NULL,
  CONSTRAINT PK_evolucion
  PRIMARY KEY (idEvolucion),
  CONSTRAINT FK_evolucion_paciente
  FOREIGN KEY (idPaciente)
  REFERENCES paciente(idPaciente)
);