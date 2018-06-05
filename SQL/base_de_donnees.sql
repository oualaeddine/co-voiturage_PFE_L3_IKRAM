-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 05 Juin 2018 à 16:39
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

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

CREATE TABLE `admins` (
  `id`       int(11)      NOT NULL,
  `nom`      varchar(200) NOT NULL,
  `prenom`   varchar(200) NOT NULL,
  `email`    varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Structure de la table `prix`
--

CREATE TABLE `prix` (
  `id`           int(11) NOT NULL,
  `ville_depart` int(11) NOT NULL,
  `ville_arrive` int(11) NOT NULL,
  `prix`         float   NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trajets`
--

CREATE TABLE `trajets` (
  `id`       int(11)    NOT NULL,
  `etat`     tinyint(4) NOT NULL DEFAULT '1',
  `depart`   int(11)    NOT NULL,
  `desti`    int(11)    NOT NULL,
  `createur` int(11)    NOT NULL,
  `date`     timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id`       int(11)      NOT NULL,
  `nom`      varchar(200) NOT NULL,
  `prenom`   varchar(200) NOT NULL,
  `email`    varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `type`     enum ('voyageur', 'conducteur') DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `prenom`, `email`, `password`, `type`) VALUES
  (1, 'toumiat', 'Abderrahman', 'vlad@vlad.vlad', 'vlad', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `villes`
--

CREATE TABLE `villes` (
  `id`   int(11)      NOT NULL,
  `name` varchar(200) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `prix`
--
ALTER TABLE `prix`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prix_villes_id_fk` (`ville_depart`),
  ADD KEY `prix_villes_id_fk_2` (`ville_arrive`);

--
-- Index pour la table `trajets`
--
ALTER TABLE `trajets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trajets_clients_id_fk` (`createur`),
  ADD KEY `trajets_villes_id_fk` (`depart`),
  ADD KEY `trajets_villes_id_fk_2` (`desti`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `villes`
--
ALTER TABLE `villes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `villes_id_uindex` (`id`),
  ADD UNIQUE KEY `villes_name_uindex` (`name`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `prix`
--
ALTER TABLE `prix`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `trajets`
--
ALTER TABLE `trajets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 5;
--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 2;
--
-- AUTO_INCREMENT pour la table `villes`
--
ALTER TABLE `villes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `prix`
--
ALTER TABLE `prix`
  ADD CONSTRAINT `prix_villes_id_fk` FOREIGN KEY (`ville_depart`) REFERENCES `villes` (`id`),
  ADD CONSTRAINT `prix_villes_id_fk_2` FOREIGN KEY (`ville_arrive`) REFERENCES `villes` (`id`);

--
-- Contraintes pour la table `trajets`
--
ALTER TABLE `trajets`
  ADD CONSTRAINT `trajets_clients_id_fk` FOREIGN KEY (`createur`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `trajets_villes_id_fk` FOREIGN KEY (`depart`) REFERENCES `villes` (`id`),
  ADD CONSTRAINT `trajets_villes_id_fk_2` FOREIGN KEY (`desti`) REFERENCES `villes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
