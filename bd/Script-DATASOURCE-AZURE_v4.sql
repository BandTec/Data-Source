CREATE TABLE [DBO].[TB_USUARIO_USUA]
(
	[ID_USUA_CD_USUARIO] INT NOT NULL IDENTITY (1, 1),
	[USUA_NO_USUARIO] VARCHAR(45)  NULL,
	[USUA_NO_EMAIL] VARCHAR(45) NULL,
	[USUA_CD_SENHA] VARCHAR(45) NULL,
	[USUA_NO_INDICACAO] VARCHAR(45)  NULL,
	[USUA_TP_USUARIO] BIT  NULL
);


/* CREATE PRIMARY KEYS, INDEXES, UNIQUES, CHECKS */

ALTER TABLE [DBO].[TB_USUARIO_USUA] 
 ADD CONSTRAINT [PK_USUA]
	PRIMARY KEY CLUSTERED ([ID_USUA_CD_USUARIO] ASC);


/* CREATE TABLE COMMENTS */

EXEC SP_ADDEXTENDEDPROPERTY 'MS_DESCRIPTION', 'CRIAÇÃO DA TABELA PARA ARMAZENAR OS USUARIOS','SCHEMA', [DBO], 'TABLE', [TB_USUARIO_USUA];

-- DROP TABLE [DBO].[TB_MAQUINA_MAQU];
CREATE TABLE [DBO].[TB_MAQUINA_MAQU]
(
	[ID_MAQU_CD_MAQUINA] INT NOT NULL IDENTITY (1, 1),
	[MAQU_NO_SISTEMA_OPERACIONAL] VARCHAR(45)  NULL,
	[MAQU_NO_PROCESSADOR] VARCHAR(100)  NULL,
	[MAQU_NU_CPU_USO] VARCHAR(45) NULL,
	[MAQU_NU_MEM_RAM_TOTAL] VARCHAR(45) NULL,
	[MAQU_NU_MEM_RAM_USADA] VARCHAR(45) NULL,
	[MAQU_NU_MEM_RAM_DISPONIVEL] VARCHAR(45) NULL,
	[MAQU_NU_DISCO_TOTAL] VARCHAR(45) NULL,
	[MAQU_NU_DISCO_USADO] VARCHAR(45) NULL,
	[MAQU_NU_DISCO_DISPONIVEL] VARCHAR(45) NULL,
	[MAQU_NO_GPU] VARCHAR(45)  NULL,
	[MAQU_DS_TIPO_MAQUINA] VARCHAR(45)  NULL,
	[MAQU_NOME] VARCHAR(45)  NULL,
	[MAQU_MAC_ADDRESS] VARCHAR(45)  NULL,
);
ALTER TABLE [DBO].[TB_MAQUINA_MAQU] 
 ADD CONSTRAINT [PK_MAQU]
	PRIMARY KEY CLUSTERED ([ID_MAQU_CD_MAQUINA] ASC);


EXEC SP_ADDEXTENDEDPROPERTY 'MS_DESCRIPTION', 'CRIAÇÃO DA TABELA PARA ARMAZENAR OS DADOS DA MAQUINA','SCHEMA', [DBO], 'TABLE', [TB_MAQUINA_MAQU];



CREATE TABLE [DBO].[TB_MAQUINA_USUARIO_MAUS]
(
	[ID_USUA_CD_USUARIO] INT NOT NULL,
	[ID_MAQU_CD_MAQUINA] INT NOT NULL,
	CONSTRAINT [PK_USUA_MAQU] PRIMARY KEY CLUSTERED
(
	[ID_USUA_CD_USUARIO] ASC,
	[ID_MAQU_CD_MAQUINA] ASC
)
	
	WITH (
			PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
		) ON [PRIMARY];




/* CREATE PRIMARY KEYS, INDEXES, UNIQUES, CHECKS */

ALTER TABLE [DBO].[TB_MAQUINA_USUARIO_MAUS]  WITH CHECK ADD  CONSTRAINT [ID_USUA_CD_USUARIO] FOREIGN KEY([ID_USUA_CD_USUARIO])
REFERENCES [DBO].[TB_USUARIO_USUA] ([ID_USUA_CD_USUARIO])
ON DELETE CASCADE;


ALTER TABLE [DBO].[TB_MAQUINA_USUARIO_MAUS]  WITH CHECK ADD CONSTRAINT [ID_MAQU_CD_MAQUINA] FOREIGN KEY([ID_MAQU_CD_MAQUINA])
REFERENCES [DBO].[TB_MAQUINA_MAQU] ([ID_MAQU_CD_MAQUINA])
ON DELETE CASCADE;


ALTER TABLE [DBO].[TB_MAQUINA_USUARIO_MAUS] CHECK CONSTRAINT [ID_USUA_CD_USUARIO];

ALTER TABLE [DBO].[TB_MAQUINA_USUARIO_MAUS] CHECK CONSTRAINT [ID_MAQU_CD_MAQUINA];


/* CREATE TABLE COMMENTS */

EXEC SP_ADDEXTENDEDPROPERTY 'MS_DESCRIPTION', ' CRIAÇÃO DA TABELA PARA VINCULAR A TABELA MAQUINA COM OS USUARIOS CONECTADOS NOS SERVIDORES','SCHEMA', [DBO], 'TABLE', [TB_MAQUINA_USUARIO_MAUS]



CREATE TABLE [DBO].[TB_COLETA_DADOS_CODA]
(
	[ID_CODA_CD_COLETA] INT NOT NULL IDENTITY (1, 1),
	[CODA_USO_CPU] VARCHAR(45)  NULL,
	[CODA_USO_MEM_RAM] VARCHAR(45) NULL,
	[CODA_USO_DISCO] VARCHAR(45) NULL,
	[CODA_DH_COLETA] VARCHAR (45) NULL,
	[FK_MAQU_CODA] INT NOT NULL
);


/* CREATE PRIMARY KEYS, INDEXES, UNIQUES, CHECKS */

ALTER TABLE [DBO].[TB_COLETA_DADOS_CODA] 
 ADD CONSTRAINT [PK_CODA]
	PRIMARY KEY CLUSTERED ([ID_CODA_CD_COLETA] ASC);


ALTER TABLE [DBO].[TB_COLETA_DADOS_CODA]  WITH CHECK ADD CONSTRAINT [FK_MAQU_CODA] FOREIGN KEY([FK_MAQU_CODA])
REFERENCES [DBO].[TB_MAQUINA_MAQU] ([ID_MAQU_CD_MAQUINA])
ON DELETE CASCADE;


/* CREATE TABLE COMMENTS */

EXEC SP_ADDEXTENDEDPROPERTY 'MS_DESCRIPTION', 'CRIAÇÃO DA TABELA PARA COLETAR OS DADOS DA MAQUINA','SCHEMA', [DBO], 'TABLE', [TB_COLETA_DADOS_CODA];

/* CREATE TABLES */

CREATE TABLE [DBO].[TB_PROCESSOS_MAQUINA_PRMA]
(
	[ID_PRMA_CD_PROCESSO] INT NOT NULL IDENTITY (1, 1),
	[PRMA_CD_PID] INT NULL,
	[PRMA_NO_PROCESSO] VARCHAR(45) NULL,
	[PRMA_USO_CPU_PROC] VARCHAR(45) NULL,
	[PRMA_USO_RAM_PROC] VARCHAR(45) NULL,
	[PRMA_DH_PROCESSO] VARCHAR (45) NULL,
	[FK_MAQU_PROCESS] INT NOT NULL
);

/* CREATE PRIMARY KEYS, INDEXES, UNIQUES, CHECKS */

ALTER TABLE [DBO].[TB_PROCESSOS_MAQUINA_PRMA] 
 ADD CONSTRAINT [PK_MAQU_PROCESS]
	PRIMARY KEY CLUSTERED ([ID_PRMA_CD_PROCESSO] ASC);

ALTER TABLE [DBO].[TB_PROCESSOS_MAQUINA_PRMA]  WITH CHECK ADD CONSTRAINT [FK_MAQU_PROCESS] FOREIGN KEY([FK_MAQU_PROCESS])
REFERENCES [DBO].[TB_MAQUINA_MAQU] ([ID_MAQU_CD_MAQUINA])
ON DELETE CASCADE;

/* CREATE TABLE COMMENTS */

EXEC SP_ADDEXTENDEDPROPERTY 'MS_DESCRIPTION', 'CRIAÇÃO DA TABELA PARA COLETAR OS PROCESSOS DA MAQUINA','SCHEMA', [DBO], 'TABLE', [TB_PROCESSOS_MAQUINA_PRMA];

insert into [DBO].[TB_USUARIO_USUA] VALUES ('admin','admin@admin.com','123','',0);

--INSERT INTO TB_MAQUINA_MAQU (MAQU_NO_SISTEMA_OPERACIONAL, MAQU_NO_PROCESSADOR, MAQU_NU_CPU_USO,
--MAQU_NU_MEM_RAM_TOTAL, MAQU_NU_MEM_RAM_USADA, MAQU_NU_MEM_RAM_DISPONIVEL, MAQU_NU_DISCO_TOTAL,
--MAQU_NU_DISCO_USADO, MAQU_NU_DISCO_DISPONIVEL, MAQU_NO_GPU, MAQU_DS_TIPO_MAQUINA, MAQU_NOME,
--MAQU_MAC_ADDRESS) VALUES('', '', '', '', '', '', '', '', '', '', '', '', '');




SELECT * FROM  [DBO].[TB_MAQUINA_MAQU] ; 

SELECT * FROM [DBO].[TB_USUARIO_USUA];

SELECT * FROM [DBO].[TB_COLETA_DADOS_CODA];

SELECT * FROM [DBO].[TB_PROCESSOS_MAQUINA_PRMA];

SELECT * FROM [DBO].[TB_MAQUINA_USUARIO_MAUS];

--insert into TB_PROCESSOS_MAQUINA_PRMA values(123,'nomeproceso','usoCPU','USORAM',CURRENT_TIMESTAMP,1);


/*
DROP TABLE  [DBO].[TB_MAQUINA_USUARIO_MAUS];
DROP TABLE  [DBO].[TB_USUARIO_USUA];
DROP TABLE  [DBO].[TB_PROCESSOS_MAQUINA_PRMA];
DROP TABLE  [DBO].[TB_COLETA_DADOS_CODA];
DROP TABLE  [DBO].[TB_MAQUINA_MAQU] ;
*/




--
--
--CREATE TABLE [dbo].[Table_x](
--        [idtabelax] [int] IDENTITY(1,1) NOT NULL,
--        [descricao] [nchar](10) NULL,
--     CONSTRAINT [PK_Table_x] PRIMARY KEY CLUSTERED 
--    (
--        [idtabelax] ASC
--    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--    ) ON [PRIMARY]
--
--    GO
--
--
--
--    CREATE TABLE [dbo].[Table_Y](
--        [idtabelaY] [int] IDENTITY(1,1) NOT NULL,
--        [descricao] [nchar](10) NULL,
--     CONSTRAINT [PK_Table_Y] PRIMARY KEY CLUSTERED 
--    (
--        [idtabelaY] ASC
--    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--    ) ON [PRIMARY]
--
--    GO
--
--
--CREATE TABLE [dbo].[Table_intermediaria](
--    [idtabelaX] [int] NOT NULL,
--    [idtabelaY] [int] NOT NULL,
--    [descricao] [nchar](10) NULL,
-- CONSTRAINT [PK_Table_intermediaria] PRIMARY KEY CLUSTERED 
--(
--    [idtabelaX] ASC,
--    [idtabelaY] ASC
--)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--) ON [PRIMARY]
--
--GO
--
--ALTER TABLE [dbo].[Table_intermediaria]  WITH CHECK ADD  CONSTRAINT [FK_Table_intermediaria_Table_x] FOREIGN KEY([idtabelaX])
--REFERENCES [dbo].[Table_x] ([idtabelax])
--GO
--
--ALTER TABLE [dbo].[Table_intermediaria] CHECK CONSTRAINT [FK_Table_intermediaria_Table_x]
--GO
--
--ALTER TABLE [dbo].[Table_intermediaria]  WITH CHECK ADD  CONSTRAINT [FK_Table_intermediaria_Table_Y] FOREIGN KEY([idtabelaY])
--REFERENCES [dbo].[Table_Y] ([idtabelaY])
--GO
--
--ALTER TABLE [dbo].[Table_intermediaria] CHECK CONSTRAINT [FK_Table_intermediaria_Table_Y]
--GO
--




--1	WINDOWS	AMD Ryzen 7 1800X Eight-Core Processor         	02	15,9 GiB	6,8 GiB	9,1 GiB	587,4 GiB	225,7 GiB	361,7 GiB	NVIDIA GeForce GTX 1060 6GB	Notebook	Guide-PC	4c:ed:fb:ca:b7:96
--
--2	LINUX	Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz	11	15,6 GiB	4,0 GiB	11,5 GiB	478,7 GiB	307,9 GiB	170,8 GiB	Nao tem placa de video	Servidor	C040	10:f0:05:16:1f:2a
--
--4	LINUX	Intel(R) Core(TM) i5-3337U CPU @ 1.80GHz	09	7,6 GiB	6,0 GiB	1,6 GiB	120,7 GiB	99,2 GiB	21,4 GiB	Nao tem placa de video	Servidor	mtznotfs012381	08:9e:01:e4:3a:30
--
--8	LINUX	Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz	06	15,6 GiB	5,8 GiB	9,7 GiB	478,7 GiB	420,3 GiB	58,4 GiB	Nao tem placa de video	Servidor	C042	1c:4d:70:7b:94:a4
--
--9	WINDOWS	Intel(R) Core(TM) i5 CPU       M 560  @ 2.67GHz	03	3,8 GiB	1,8 GiB	2,0 GiB	214,0 GiB	92,7 GiB	121,2 GiB	Nao tem placa de video	Notebook	HSL166	00:00:00:00:00:00:00:e0
--
--10	WINDOWS	Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz	30	3,9 GiB	3,5 GiB	416,8 MiB	464,5 GiB	183,6 GiB	280,9 GiB	Nao tem placa de video	Notebook	LAPTOP-1QCVB462	0a:00:27:00:00:16
--
--11	WINDOWS	Intel(R) Core(TM) i5 CPU       M 520  @ 2.40GHz	03	3,8 GiB	2,0 GiB	1,8 GiB	215,4 GiB	99,2 GiB	116,3 GiB	Nao tem placa de video	Notebook	HSL104	00:23:14:c8:6e:b4


--INSERT INTO TB_MAQUINA_MAQU VALUES('LINUX', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '02', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Servidor', 'C040', '10:f0:05:16:1f:2a');

--INSERT INTO TB_MAQUINA_MAQU VALUES('LINUX', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '06', '15,6 GiB', '5,8 GiB', '9,7 GiB', '478,7 GiB', '58,4 GiB', '361,7 GiB', 'Nao tem placa de video', 'Servidor', 'C042', '1c:4d:70:7b:94:a4');

--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 560  @ 2.67GHz ', '20', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-01', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '30', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-02', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '12', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-03', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '55', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-04', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '54', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-05', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '66', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1080 8GB', 'Desktop', 'PC-06', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '32', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-07', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '47', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1060 6GB', 'Desktop', 'PC-08', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '02', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-09', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '43', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1050 4GB', 'Desktop', 'PC-10', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 520  @ 2.40GHz', '17', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-11', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '23', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1060 6GB', 'Desktop', 'PC-12', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 520  @ 2.40GHz', '20', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-13', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '30', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1070 8GB', 'Desktop', 'PC-14', 'mac-address');

--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 560  @ 2.67GHz ', '20', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-15', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '30', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-16', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '12', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-17', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '55', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-18', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '54', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-19', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '66', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1080 8GB', 'Desktop', 'PC-20', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '32', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-21', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '47', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1060 6GB', 'Desktop', 'PC-22', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i3-6006U CPU @ 2.00GHz', '02', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-23', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '43', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1050 4GB', 'Desktop', 'PC-24', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 520  @ 2.40GHz', '17', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-25', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '23', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1060 6GB', 'Desktop', 'PC-26', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i5 CPU       M 520  @ 2.40GHz', '20', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'Nao tem placa de video', 'Notebook', 'PC-27', 'mac-address');
--
--INSERT INTO TB_MAQUINA_MAQU VALUES('WINDOWS', 'Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz', '30', '15,9 GiB', '6,8 GiB', '9,1 GiB', '587,4 GiB', '225,7 GiB', '361,7 GiB', 'NVIDIA GeForce GTX 1070 8GB', 'Desktop', 'PC-28', 'mac-address');


















