# Host: localhost  (Version 5.5.54)
# Date: 2019-07-27 21:16:51
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "cliente"
#

CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_nome` varchar(200) DEFAULT NULL,
  `cliente_sobrenome` varchar(200) DEFAULT NULL,
  `cliente_doc` varchar(50) DEFAULT NULL COMMENT 'cpf, cnpj ou outro',
  `cliente_email` varchar(200) DEFAULT NULL,
  `cliente_telefone` varchar(20) DEFAULT NULL,
  `cliente_celular` varchar(20) DEFAULT NULL,
  `cliente_datacad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "cliente"
#

INSERT INTO `cliente` VALUES (1,'Fulano','de Tal','101.010.10','fulano@microsoft.com.br','555-5555','9555-5555','23/07/2019'),(2,'Jose','da Silva','132.123.12','jose@gmail.com','555-5556','9555-5556','24/07/2019');

#
# Structure for table "endereco"
#

CREATE TABLE `endereco` (
  `endereco_id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco_cliente` int(11) DEFAULT NULL,
  `endereco_rua` varchar(300) DEFAULT NULL,
  `endereco_uf` varchar(2) DEFAULT NULL,
  `endereco_num` varchar(20) DEFAULT NULL,
  `endereco_complemento` varchar(2000) DEFAULT NULL,
  `endereco_cidade` varchar(200) DEFAULT NULL,
  `endereco_bairro` varchar(200) DEFAULT NULL,
  `endereco_tipo` int(11) DEFAULT '1' COMMENT '1 = cobranca',
  `endereco_title` varchar(200) DEFAULT NULL,
  `endereco_cep` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`endereco_id`),
  KEY `fk_end_cliente` (`endereco_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "endereco"
#


#
# Structure for table "ordem_servico"
#

CREATE TABLE `ordem_servico` (
  `os_id` int(11) NOT NULL AUTO_INCREMENT,
  `os_user` int(11) DEFAULT NULL,
  `os_status` varchar(10) DEFAULT NULL,
  `os_id_cli` int(11) DEFAULT NULL,
  `os_dt_emissao` varchar(20) DEFAULT NULL,
  `os_dt_fechamento` varchar(20) DEFAULT NULL,
  `os_tp_equip` varchar(100) DEFAULT NULL,
  `os_marca_equip` varchar(100) DEFAULT NULL,
  `os_problema` varchar(500) DEFAULT NULL,
  `os_exec` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "ordem_servico"
#

INSERT INTO `ordem_servico` VALUES (1,1,'Concluido',1,'2019-7-26 1:36:45',NULL,'Furadeira','Makita','Broca gira em falso, mesmo sendo a original','trocado mandril'),(2,1,'Concluido',1,'2019-7-26 11:34:57',NULL,'Furadeira','Bosh','Broca gira em falso mesmo em velocidades baixas','trocado mandril');

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_login` varchar(20) DEFAULT NULL,
  `us_password` varchar(100) DEFAULT NULL,
  `us_email` varchar(100) DEFAULT NULL,
  `us_nome` varchar(200) DEFAULT NULL,
  `us_cargo` varchar(100) DEFAULT NULL,
  `us_level` int(11) DEFAULT '1',
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'secretaria','123','secretaria@betha.com.br','Recepção','Secretaria',1),(2,'tecnico_01','123','tecnico_01@gmail.com','tec_01','Tecnico',2),(3,'tecnico_02','123','tecnico_02@gmail.com','tec_02','Tecnico',2);
