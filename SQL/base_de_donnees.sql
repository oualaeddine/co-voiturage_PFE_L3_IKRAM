-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 25 Mai 2018 à 15:30
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `co_voiturage`
--
CREATE DATABASE IF NOT EXISTS `co_voiturage`
  DEFAULT CHARACTER SET latin1
  COLLATE latin1_swedish_ci;
USE `co_voiturage`;

-- --------------------------------------------------------

--
-- Structure de la table `trajets`
--

CREATE TABLE `trajets` (
  `id`       int(11)                             NOT NULL,
  `etat`     enum ('disponible', 'indisponible') NOT NULL,
  `depart`   varchar(200)                        NOT NULL,
  `desti`    varchar(200)                        NOT NULL,
  `createur` int(11)                             NOT NULL,
  `date`     timestamp                           NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Contenu de la table `trajets`
--

INSERT INTO `trajets` (`id`, `etat`, `depart`, `desti`, `createur`, `date`) VALUES
  (1, 'disponible', 'blida', 'constantine', 1, '2018-05-25 11:39:43'),
  (2, 'disponible', 'blida', 'constantine', 1, '2018-05-25 11:39:58'),
  (3, 'disponible', 'blida', 'constantine', 1, '2018-05-25 11:40:22'),
  (4, 'disponible', 'blida', 'constantine', 1, '2018-05-25 11:40:27');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id`       int(11)      NOT NULL,
  `nom`      varchar(200) NOT NULL,
  `prenom`   varchar(200) NOT NULL,
  `email`    varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `nom`, `prenom`, `email`, `password`) VALUES
  (1, 'toumiat', 'Abderrahman', 'vlad@vlad.vlad', 'vlad');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `trajets`
--
ALTER TABLE `trajets`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `trajets`
--
ALTER TABLE `trajets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 5;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 2;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
