-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Set-2024 às 02:23
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_estacionamento`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estacione`
--

CREATE TABLE `estacione` (
  `idestacione` int(11) NOT NULL,
  `placa` varchar(7) NOT NULL,
  `entrada` timestamp NOT NULL DEFAULT current_timestamp(),
  `saida` timestamp NULL DEFAULT NULL,
  `valor` double(10,2) NOT NULL,
  `status` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `estacione`
--

INSERT INTO `estacione` (`idestacione`, `placa`, `entrada`, `saida`, `valor`, `status`) VALUES
(2, 'HAQ7178', '2024-09-03 23:30:58', '2024-09-04 00:03:57', 0.00, 1);

--
-- Acionadores `estacione`
--
DELIMITER $$
CREATE TRIGGER `update_saida_before_update` BEFORE UPDATE ON `estacione` FOR EACH ROW BEGIN
  IF OLD.status <> NEW.status THEN
    SET NEW.saida = CURRENT_TIMESTAMP;
  END IF;
END
$$
DELIMITER ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `estacione`
--
ALTER TABLE `estacione`
  ADD PRIMARY KEY (`idestacione`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `estacione`
--
ALTER TABLE `estacione`
  MODIFY `idestacione` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
