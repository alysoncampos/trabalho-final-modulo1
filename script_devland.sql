CREATE TABLE Endereco (
	  id_endereco 		NUMBER 			NOT NULL,
	  logradouro 		VARCHAR2(100) 	NOT NULL,
	  numero 			VARCHAR2(7) 	NOT NULL,
	  complemento 		VARCHAR2(20) 	NOT NULL,
	  cep 				CHAR(9) 		NOT NULL,
	  cidade 			VARCHAR2(100) 	NOT NULL,
	  estado 			VARCHAR2(50) 	NOT NULL,
	  pais 				VARCHAR2(50) 	NOT NULL,
	  PRIMARY KEY (id_endereco)
);

CREATE TABLE Usuario (
	  id_usuario 		NUMBER 			NOT NULL,
	  id_endereco 		NUMBER 			NOT NULL,
	  id_contato 		NUMBER 			NOT NULL,
	  nome 				VARCHAR2(100) 	NOT NULL,
	  email 			VARCHAR2(100) 	NOT NULL,
	  tipo 				VARCHAR2(15),
	  senha 			VARCHAR2(255),
	  PRIMARY KEY (id_usuario),
	  CONSTRAINT fk_usuario_id_endereco
	    FOREIGN KEY (id_endereco)
	      REFERENCES Endereco(id_endereco)
);

CREATE TABLE Postagem (
	  id_postagem 		NUMBER 			NOT NULL,
	  id_usuario 		NUMBER 			NOT NULL,
	  tipo 				VARCHAR2(50) 	NOT NULL,
	  titulo 			VARCHAR2(50) 	NOT NULL,
	  texto 			VARCHAR2(500) 	NOT NULL,	  
	  PRIMARY KEY (id_postagem),
	  CONSTRAINT FK_Postagem_id_usuario
	    FOREIGN KEY (id_usuario)
	      REFERENCES Usuario(id_usuario)
);

CREATE TABLE UsuarioEmpresa (
	  id_empresa 		NUMBER 			NOT NULL,
	  id_usuario 		NUMBER 			NOT NULL,
	  area_atuacao 		VARCHAR2(100) 	NOT NULL,
	  cnpj 				VARCHAR2(50) 	NOT NULL,
	  PRIMARY KEY (id_empresa),
	  CONSTRAINT FK_UsuarioEmpresa_id_usuario
	    FOREIGN KEY (id_usuario)
	      REFERENCES Usuario(id_usuario)
);

CREATE TABLE UsuarioDev (
	  id_dev 			NUMBER 			NOT NULL,
	  id_usuario 		NUMBER 			NOT NULL,
	  stack 			VARCHAR2(100) 	NOT NULL,
	  cpf 				VARCHAR2(50) 	NOT NULL,
	  PRIMARY KEY (id_dev),
	  CONSTRAINT FK_UsuarioDev_id_usuario
	    FOREIGN KEY (id_usuario)
	      REFERENCES Usuario(id_usuario)
);

CREATE TABLE Contato (
	  id_contato 		NUMBER 			NOT NULL,
	  id_usuario 		NUMBER 			NOT NULL,
	  numero 			VARCHAR2(50) 	NOT NULL,
	  tipo 				CHAR(1) 		NOT NULL,
	  PRIMARY KEY (id_contato),
	  CONSTRAINT FK_Contato_id_contato
	    FOREIGN KEY (id_usuario)
	      REFERENCES Usuario(id_usuario)
);*/

CREATE SEQUENCE SEQ_USUARIO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_USUARIO_DEV
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_USUARIO_EMPRESA
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_CONTATO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_POSTAGEM
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;