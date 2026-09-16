CREATE DATABASE  IF NOT EXISTS `salaodebeleza` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `salaodebeleza`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: salaodebeleza
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `Nascimento` date NOT NULL,
  `Cpf` varchar(14) NOT NULL,
  `RG` varchar(12) NOT NULL,
  `Telefone` varchar(15) NOT NULL,
  `Estado` varchar(25) NOT NULL,
  `Cidade` varchar(25) NOT NULL,
  `Bairro` varchar(25) NOT NULL,
  `Rua` varchar(25) NOT NULL,
  `Complemento` varchar(25) NOT NULL,
  `PontoReferencia` varchar(25) NOT NULL,
  `Cep` varchar(9) NOT NULL,
  `Numero` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Jay','1970-02-22','21039387210','192839821','85993320065','Rio','Eiro','Rio','Jan','Rio','kafkjfs','98532888',66),(3,'Danielle','1980-01-04','21087834512','210878345','98552381100','Rio','Rio','Rio','Rio','Rio','Rio','45673299',18);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_consumo`
--

DROP TABLE IF EXISTS `produto_consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_consumo` (
  `CodigoProduto` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `ValorCompra` float NOT NULL,
  PRIMARY KEY (`CodigoProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_consumo`
--

LOCK TABLES `produto_consumo` WRITE;
/*!40000 ALTER TABLE `produto_consumo` DISABLE KEYS */;
INSERT INTO `produto_consumo` VALUES (1,'Shampo',70),(2,'Sabonete',35);
/*!40000 ALTER TABLE `produto_consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_venda`
--

DROP TABLE IF EXISTS `produto_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_venda` (
  `codigoProduto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `ValorCompra` float NOT NULL,
  `ValorVenda` float NOT NULL,
  PRIMARY KEY (`codigoProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_venda`
--

LOCK TABLES `produto_venda` WRITE;
/*!40000 ALTER TABLE `produto_venda` DISABLE KEYS */;
INSERT INTO `produto_venda` VALUES (2,'Tinta',100,250),(3,'Creme',15,25);
/*!40000 ALTER TABLE `produto_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrarvendaprodutos`
--

DROP TABLE IF EXISTS `registrarvendaprodutos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrarvendaprodutos` (
  `IdVenda` int NOT NULL AUTO_INCREMENT,
  `Cliente` varchar(50) NOT NULL,
  `Produto` varchar(50) NOT NULL,
  `Quantidade` int NOT NULL,
  `DataVenda` date NOT NULL,
  `ValorTotal` float NOT NULL,
  PRIMARY KEY (`IdVenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrarvendaprodutos`
--

LOCK TABLES `registrarvendaprodutos` WRITE;
/*!40000 ALTER TABLE `registrarvendaprodutos` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrarvendaprodutos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `Valor` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Corte',800),(2,'Limpeza',80);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicos_realizados`
--

DROP TABLE IF EXISTS `servicos_realizados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicos_realizados` (
  `IdAtendimento` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idServico` int NOT NULL,
  `ValorServico` float NOT NULL,
  `dataServico` date NOT NULL,
  PRIMARY KEY (`IdAtendimento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicos_realizados`
--

LOCK TABLES `servicos_realizados` WRITE;
/*!40000 ALTER TABLE `servicos_realizados` DISABLE KEYS */;
INSERT INTO `servicos_realizados` VALUES (3,1,2,150,'2026-06-29'),(4,2,1,70,'2008-04-22');
/*!40000 ALTER TABLE `servicos_realizados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendaproduto` (
  `IdVenda` int NOT NULL AUTO_INCREMENT,
  `idCliente` varchar(50) NOT NULL,
  `idProduto` varchar(50) NOT NULL,
  `Quantidade` int NOT NULL,
  `Data` date NOT NULL,
  `ValorTotal` float NOT NULL,
  PRIMARY KEY (`IdVenda`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendaproduto`
--

LOCK TABLES `vendaproduto` WRITE;
/*!40000 ALTER TABLE `vendaproduto` DISABLE KEYS */;
INSERT INTO `vendaproduto` VALUES (1,'2','1',8,'2026-06-29',200),(3,'1','2',5,'2026-06-29',125);
/*!40000 ALTER TABLE `vendaproduto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-29 23:23:16
