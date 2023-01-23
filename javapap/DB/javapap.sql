-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Dez-2021 às 10:48
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `javapap`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `local`
--

CREATE TABLE `local` (
  `Regiao` enum('Norte','Centro','Sul') NOT NULL,
  `Cidades_Reg` varchar(199) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `Local` varchar(974) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `local`
--

INSERT INTO `local` (`Regiao`, `Cidades_Reg`, `ID_User`, `ID`, `Local`) VALUES
('Sul', 'Alentejo', 1, 1, 'Lagoa'),
('Sul', 'Faro', 1, 2, 'Hospital de Faro'),
('Centro', 'Cidades', 2, 3, 'Local'),
('Centro', 'centro', 2, 4, 'Igreja'),
('Norte', 'Porto', 2, 5, 'Igreja');

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `email` varchar(49) NOT NULL,
  `Pass` varchar(49) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`email`, `Pass`) VALUES
('antoniomendes@sapo.pt', 'RTU3NmM3MWIyMzZmJGF6eA=='),
('fabioalexpinhomartis@gmail.com', 'RTU3NmM3MWIyMzZmJGFh'),
('fernandolages6@gmail.com', 'RTU3NmM3MWIyMzZmJGFh'),
('filipeaguilar01@gmail.com', 'RTU3NmM3MWIyMzZmJGF4Y3Zi'),
('teste@gmail.com', 'RTU3NmM3MWIyMzZmJGFh');

-- --------------------------------------------------------

--
-- Estrutura da tabela `percursos`
--

CREATE TABLE `percursos` (
  `ID_Percurso` int(11) NOT NULL,
  `Nome_perc` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Km` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `percursos`
--

INSERT INTO `percursos` (`ID_Percurso`, `Nome_perc`, `ID`, `Cidade`, `Km`) VALUES
(1, 1, 1, 'SJM', 123);

-- --------------------------------------------------------

--
-- Estrutura da tabela `percurso_realizado`
--

CREATE TABLE `percurso_realizado` (
  `ID_user` int(11) NOT NULL,
  `cidade` varchar(199) NOT NULL,
  `locomocao` enum('Pe','bicicleta') NOT NULL,
  `km` int(11) NOT NULL,
  `ID_perc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `percurso_realizado`
--

INSERT INTO `percurso_realizado` (`ID_user`, `cidade`, `locomocao`, `km`, `ID_perc`) VALUES
(1, 'SMF', 'Pe', 12, 1),
(1, 'SJM', 'bicicleta', 24, 2),
(3, 'SJM', 'Pe', 23, 2),
(4, 'SJM', 'Pe', 123, 1),
(1, 'SJM', 'Pe', 123, 1),
(5, 'SJM', 'Pe', 123, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `ID_user` int(11) NOT NULL,
  `Nome_user` varchar(250) NOT NULL,
  `Idade` int(11) NOT NULL,
  `email` varchar(49) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`ID_user`, `Nome_user`, `Idade`, `email`) VALUES
(1, 'Fernando', 17, 'fernandolages6@gmail.com'),
(2, 'Filipe', 17, 'filipeaguilar01@gmail.com'),
(3, 'Fabio', 21, 'fabioalexpinhomartis@gmail.com'),
(4, 'teste', 33, 'teste@gmail.com'),
(5, 'Antonio', 53, 'antoniomendes@sapo.pt');

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `ID_user` int(11) NOT NULL,
  `locomoção` enum('Pé','bicicleta') NOT NULL,
  `Eletrico` enum('Sim','Nao') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`ID_user`, `locomoção`, `Eletrico`) VALUES
(1, 'bicicleta', 'Sim');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Local_user` (`ID_User`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`email`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Índices para tabela `percursos`
--
ALTER TABLE `percursos`
  ADD PRIMARY KEY (`ID_Percurso`),
  ADD KEY `perc_ID` (`ID`);

--
-- Índices para tabela `percurso_realizado`
--
ALTER TABLE `percurso_realizado`
  ADD KEY `PercRel_id` (`ID_user`);

--
-- Índices para tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_user`),
  ADD KEY `email` (`email`);

--
-- Índices para tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`locomoção`),
  ADD KEY `veiculo user` (`ID_user`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `local`
--
ALTER TABLE `local`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `percursos`
--
ALTER TABLE `percursos`
  MODIFY `ID_Percurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `ID_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `local`
--
ALTER TABLE `local`
  ADD CONSTRAINT `Local_user` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID_user`);

--
-- Limitadores para a tabela `percursos`
--
ALTER TABLE `percursos`
  ADD CONSTRAINT `perc_ID` FOREIGN KEY (`ID`) REFERENCES `user` (`ID_user`);

--
-- Limitadores para a tabela `percurso_realizado`
--
ALTER TABLE `percurso_realizado`
  ADD CONSTRAINT `PercRel_id` FOREIGN KEY (`ID_user`) REFERENCES `user` (`ID_user`);

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `login` (`email`);

--
-- Limitadores para a tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `veiculo user` FOREIGN KEY (`ID_user`) REFERENCES `user` (`ID_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
