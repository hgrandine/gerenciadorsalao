-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 07-Nov-2016 às 23:02
-- Versão do servidor: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `salao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `id` bigint(11) NOT NULL,
  `responsavel` bigint(11) NOT NULL,
  `cliente` bigint(11) NOT NULL,
  `servicos` bigint(11) NOT NULL,
  `data` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fim` time NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`id`, `responsavel`, `cliente`, `servicos`, `data`, `hora_inicio`, `hora_fim`, `status`) VALUES
(1, 1, 1, 2, '2016-11-27', '01:00:00', '02:00:00', 'AGENDADO'),
(2, 1, 1, 2, '2016-11-28', '01:00:00', '02:00:00', 'AGENDADO'),
(3, 1, 1, 2, '2016-11-29', '01:00:00', '02:00:00', 'AGENDADO'),
(4, 3, 4, 2, '2016-11-21', '15:00:00', '15:30:00', 'CANCELADO'),
(5, 3, 4, 3, '2016-11-22', '16:00:00', '16:30:00', 'CANCELADO'),
(6, 3, 4, 2, '2016-11-21', '15:00:00', '15:30:00', 'CANCELADO'),
(7, 3, 4, 2, '2016-11-23', '16:00:00', '16:30:00', 'CANCELADO'),
(8, 3, 4, 2, '2016-11-24', '17:00:00', '17:30:00', 'CANCELADO'),
(9, 3, 4, 2, '2016-11-25', '18:00:00', '18:30:00', 'AGENDADO'),
(10, 3, 4, 2, '2016-11-26', '19:00:00', '19:30:00', 'AGENDADO'),
(11, 1, 4, 9, '2016-12-01', '03:00:00', '03:30:00', 'AGENDADO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE IF NOT EXISTS `servicos` (
  `id` bigint(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `tempo` time NOT NULL,
  `valor` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servicos`
--

INSERT INTO `servicos` (`id`, `nome`, `tipo`, `tempo`, `valor`, `status`) VALUES
(1, 'Corte cabelo feminino', '', '01:00:00', '50', 'INATIVO'),
(2, 'Corte cabelo', 'MASCULINO', '00:30:00', '15', 'ATIVO'),
(3, 'Manicure', 'FEMININO', '01:00:00', '15', 'ATIVO'),
(4, 'Pédicure', 'MASCULINO', '01:00:00', '15', 'ATIVO'),
(5, 'Pintar cabelo', 'FEMININO', '00:30:00', '50', 'ATIVO'),
(6, 'Pintar cabelo', 'MASCULINO', '00:30:00', '15', 'ATIVO'),
(7, 'Luzes', 'FEMININO', '00:30:00', '50', 'ATIVO'),
(8, 'Luzes', 'MASCULINO', '00:30:00', '10', 'ATIVO'),
(9, 'Corte', 'MASCULINO', '00:30:00', '30', 'ATIVO'),
(10, 'Corte', 'FEMININO', '01:00:00', '50', 'ATIVO'),
(11, 'Luzes', 'MASCULINO', '00:30:00', '10', 'ATIVO'),
(12, 'Sobrancelhas', 'FEMININO', '00:00:03', '15', 'ATIVO'),
(13, 'Sobrancelhas', 'FEMININO', '00:30:00', '15', 'ATIVO'),
(14, 'Sobrancelhas', 'FEMININO', '00:30:00', '15', 'ATIVO'),
(15, 'Penteados Diversos', 'MASCULINO', '00:30:00', '40', 'ATIVO'),
(16, 'Peteados Diversos', 'FEMININO', '00:30:00', '80', 'ATIVO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `permissao` varchar(50) NOT NULL,
  `telefone` varchar(25) NOT NULL,
  `celular` varchar(25) DEFAULT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `email`, `senha`, `permissao`, `telefone`, `celular`, `status`) VALUES
(1, 'Carlos Fernandes Neto', 'cfneto@outlook.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'ADMINISTRADOR', '(19) 3202-1945', '(19) 98114-4156', 'ATIVO'),
(2, 'Gerente', 'gerente@gerente.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'GERENTE', '(99) 99999-9998', '(99) 99999-9999', 'ATIVO'),
(3, 'Funcionario', 'funcionario@funcionario.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'FUNCIONARIO', '(99) 99999-9988', '(99) 99999-9998', 'ATIVO'),
(4, 'Clientes', 'cliente@cliente.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'CLIENTE', '(99) 99999-9983', '(99) 99999-9998', 'ATIVO'),
(5, 'Cliente', 'cliente@cliente.com.br', 'af15d5fdacd5fdfea300e88a8e253e82', 'CLIENTE', '(99) 99999-9999', '(99) 99999-9999', 'ATIVO'),
(6, 'Gerente', 'gerente@gerente.com.br', 'af15d5fdacd5fdfea300e88a8e253e82', 'GERENTE', '(99) 99999-9999', '(99) 99999-9999', 'ATIVO'),
(7, 'gerente2', 'gerente2@gerente.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'GERENTE', '(44) 44444-4444', '(44) 44444-4444', 'ATIVO'),
(8, 'cliente2', 'cliente2@cliente.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'CLIENTE', '(33) 33333-3333', '(33) 33333-3333', 'ATIVO'),
(9, 'Diogenes Casaril', 'di_casaril@hotmail.com', 'af15d5fdacd5fdfea300e88a8e253e82', 'ADMINISTRADOR', '(55) 55555-5555', '(55) 55555-5555', 'ATIVO'),
(10, 'Antonia Josefa', 'antonia@terra.com.br', 'af15d5fdacd5fdfea300e88a8e253e82', 'FUNCIONARIO', '(44) 44444-4444', '(55) 55555-5555', 'ATIVO'),
(11, 'Rafaela Bessa', 'rafa_ela@ig.com.br', 'af15d5fdacd5fdfea300e88a8e253e82', 'FUNCIONARIO', '(22) 22222-2222', '(11) 11111-1111', 'ATIVO'),
(12, 'Claudinete Soares', 'clau_dinete@uou.com.br', 'af15d5fdacd5fdfea300e88a8e253e82', 'FUNCIONARIO', '(11) 11111-1111', '(11) 11111-1111', 'ATIVO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id`,`responsavel`,`cliente`,`servicos`), ADD KEY `fk01` (`cliente`), ADD KEY `fk02` (`responsavel`), ADD KEY `fk03` (`servicos`);

--
-- Indexes for table `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agenda`
--
ALTER TABLE `agenda`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `servicos`
--
ALTER TABLE `servicos`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agenda`
ALTER TABLE `agenda`
ADD CONSTRAINT `fk01` FOREIGN KEY (`cliente`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk02` FOREIGN KEY (`responsavel`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk03` FOREIGN KEY (`servicos`) REFERENCES `servicos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
