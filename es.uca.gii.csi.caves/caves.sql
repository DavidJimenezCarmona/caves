-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 07-11-2013 a las 20:49:36
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
set foreign_key_checks=0; # Para que MySQL no rechiste a la hora de crear la tabla hija antes de la tabla padre
-- 
-- Base de datos: `caves`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `superpoder`
-- 

CREATE TABLE IF NOT EXISTS `Superpoder` (
  `id` int(9) NOT NULL auto_increment,
  `nombre` varchar(256) NOT NULL,
  `descripcion` varchar(512) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `busquedas` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

INSERT INTO Superpoder (nombre , descripcion) VALUES ('Agua','Control del elemento agua');
INSERT INTO Superpoder (nombre , descripcion) VALUES ('Aire','Control del elemento aire');
INSERT INTO Superpoder (nombre , descripcion) VALUES ('Fuego','Control del elemento fuego');
INSERT INTO Superpoder (nombre , descripcion) VALUES ('Tierra','Control del elemento tierra');


-- 
-- Volcar la base de datos para la tabla `superpoder`
-- 

-- --------------------------------------------------------
-- 
-- Estructura de tabla para la tabla `Superpoder_conflictos`
-- 

CREATE TABLE IF NOT EXISTS `Superpoder_conflictos`(
  `id` int(9) NOT NULL auto_increment,
  `id_Superpoder` int(9) NOT NULL,
  `id_Superpoder_conflicto` int(9) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_Superpoder`) REFERENCES Superpoder(`id`),
  FOREIGN KEY (`id_Superpoder_conflicto`) REFERENCES Superpoder(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `Superpoder_conflictos`
-- 

INSERT INTO Superpoder_conflictos (id_Superpoder, id_Superpoder_conflicto) VALUES (1, 3);

-- --------------------------------------------------------
-- 
-- Estructura de tabla para la tabla `persona`
-- 

CREATE TABLE IF NOT EXISTS `Persona` (
  `id` int(9) NOT NULL auto_increment,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `apellidos` varchar(512) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `direccion` varchar(512) NOT NULL,
  `poblacion` varchar(64) NOT NULL,
  `provincia` varchar(64) NOT NULL,
  `id_Superpoder` int(9) NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (id_Superpoder) REFERENCES Superpoder(id),
  KEY `busquedas` (`nombre`, `apellidos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 
-- Volcar la base de datos para la tabla `persona`
-- 

INSERT INTO `persona` (dni, nombre, apellidos, fechaNacimiento, direccion, poblacion, provincia, id_Superpoder) VALUES ('12345678J', 'Perico', 'de los Palotes', '1994-11-07', 'C/ Leré', 'Leré de la Frontera', 'Jerez', 1);
INSERT INTO `persona` (dni, nombre, apellidos, fechaNacimiento, direccion, poblacion, provincia, id_Superpoder) VALUES ('87654321G', 'Gonzalo', 'de las Pelotas', '1994-11-07', 'C/ Oso', 'Chipiona', 'Cádiz', 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `alumno`
-- 

CREATE TABLE IF NOT EXISTS `Alumno` (
  `id` int(9) NOT NULL auto_increment,
  `id_Persona` int(9) NOT NULL,
  `id_Estudio` int(9) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Persona`) REFERENCES Persona(`id`),
  FOREIGN KEY (`id_Estudio`) REFERENCES Estudio(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `alumno`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `alumno`
-- 

CREATE TABLE IF NOT EXISTS `Alumno_Asignatura_matriculadas` (
  `id` int(9) NOT NULL auto_increment,
  `id_Alumno` int(9) NOT NULL,
  `id_Asignatura` int(9) NOT NULL,
  `anyoAcademico` date NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Alumno`) REFERENCES Alumno(`id`),
  FOREIGN KEY (`id_Asignatura`) REFERENCES Asignatura(`id`),
  KEY `busquedas` (`anyoAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `alumno`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `alumno`
-- 

CREATE TABLE IF NOT EXISTS `Alumno_Asignatura_superadas`(
  `id` int(9) NOT NULL auto_increment,
  `id_Alumno` int(9) NOT NULL,
  `id_Asignatura` int(9) NOT NULL,
  `anyoAcademico` date NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Alumno`) REFERENCES Alumno(`id`),
  FOREIGN KEY (`id_Asignatura`) REFERENCES Asignatura(`id`),
  KEY `busquedas` (`anyoAcademico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `alumno`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `profesor`
-- 

CREATE TABLE IF NOT EXISTS `Profesor` (
  `id` int(9) NOT NULL auto_increment,
  `id_Persona` int(9) NOT NULL,
  `id_Departamento` int(9) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Persona`) REFERENCES Persona(`id`),
  FOREIGN KEY (`id_Departamento`) REFERENCES Departamento(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `profesor`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `estudio`
-- 

CREATE TABLE IF NOT EXISTS `Estudio` (
  `id` int(9) NOT NULL auto_increment,
  `nombre` varchar(256) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `busquedas` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------
-- 
-- Estructura de tabla para la tabla `asignatura`
-- 

CREATE TABLE IF NOT EXISTS `Asignatura` (
  `id` int(9) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `creditos` int(2) NOT NULL,
  `curso` int(2) NOT NULL,
  `id_Estudio` int(9) NOT NULL,
  `id_Departamento` int(9) NOT NULL,
  `id_Profesor_coordinador` int(9) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Estudio`) REFERENCES Estudio(`id`),
  FOREIGN KEY (`id_Departamento`) REFERENCES Departamento(`id`),
  FOREIGN KEY (`id_Profesor_coordinador`) REFERENCES Profesor(`id`),
  KEY `busquedas` (`nombre`, `curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 
-- Volcar la base de datos para la tabla `asignatura`
-- 

-- --------------------------------------------------------
-- 
-- Estructura de tabla para la tabla `Profesor_Asignatura`
-- 

CREATE TABLE IF NOT EXISTS `Profesor_Asignatura` (
  `id` int(9) NOT NULL auto_increment,
  `id_Profesor` int(9) NOT NULL,
  `id_Asignatura` int(9) NOT NULL,
  `horas` int(3) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Profesor`) REFERENCES Profesor(`id`),
  FOREIGN KEY (`id_Asignatura`) REFERENCES Asignatura(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 
-- Volcar la base de datos para la tabla `asignatura`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `departamento`
-- 

CREATE TABLE IF NOT EXISTS `Departamento` (
  `id` int(9) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `id_Profesor_jefe` int(9) NOT NULL,
  PRIMARY KEY  (`id`),
  FOREIGN KEY (`id_Profesor_jefe`) REFERENCES Profesor(`id`),
  KEY `busquedas` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

-- 
-- Volcar la base de datos para la tabla `asignatura`
-- 