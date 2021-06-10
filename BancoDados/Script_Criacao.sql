-- restaurante.cliente definition

CREATE TABLE `cliente` (
  `CPF` char(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `FONE` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ENDERECO` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`CPF`)
);

-- restaurante.produto definition

CREATE TABLE `produto` (
  `CODIGO` int NOT NULL,
  `NOME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PRECO` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
);

-- restaurante.pedido definition

CREATE TABLE `pedido` (
  `NUMERO` int NOT NULL,
  `CPF_CLIENTE` char(11) NOT NULL,
  `CODIGO_PRODUTO` int NOT NULL,
  `QUANTIDADE` int DEFAULT NULL,
  `valortotal` double DEFAULT NULL,
  `ativo` char(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `pedido_FK` (`CPF_CLIENTE`),
  KEY `pedido_produto_FK` (`CODIGO_PRODUTO`),
  CONSTRAINT `pedido_FK` FOREIGN KEY (`CPF_CLIENTE`) REFERENCES `cliente` (`CPF`),
  CONSTRAINT `pedido_produto_FK` FOREIGN KEY (`CODIGO_PRODUTO`) REFERENCES `produto` (`CODIGO`)
);