-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 26 mai 2023 à 21:04
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd_tpe_etudiant_niveau3`
--

-- --------------------------------------------------------

--
-- Structure de la table `commune`
--

CREATE TABLE `commune` (
  `id` int(11) NOT NULL,
  `Reg_id` int(11) DEFAULT NULL,
  `nom` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `deplace`
--

CREATE TABLE `deplace` (
  `id` int(11) NOT NULL,
  `identifiant` int(11) DEFAULT NULL,
  `signedistinctif` varchar(254) DEFAULT NULL,
  `reference` varchar(254) DEFAULT NULL,
  `datecreation` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE `entretien` (
  `id` int(11) NOT NULL,
  `Dep_id` int(11) DEFAULT NULL,
  `Heb_id` int(11) DEFAULT NULL,
  `motif` varchar(254) DEFAULT NULL,
  `conclusion` varchar(254) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `heurededebut` datetime DEFAULT NULL,
  `datecreation` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `hebergement`
--

CREATE TABLE `hebergement` (
  `id` int(11) NOT NULL,
  `Heb_id` int(11) DEFAULT NULL,
  `Dep_id` int(11) DEFAULT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `notation` int(11) DEFAULT NULL,
  `datecreation` datetime DEFAULT NULL,
  `estactif` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `hebergeur`
--

CREATE TABLE `hebergeur` (
  `id` int(11) NOT NULL,
  `numauth` varchar(254) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `datecreation` datetime DEFAULT NULL,
  `estactif` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `nationalites`
--

CREATE TABLE `nationalites` (
  `id` int(11) NOT NULL,
  `nom` int(11) DEFAULT NULL,
  `indicatif` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `matricule` varchar(254) DEFAULT NULL,
  `estactif` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `matricule`, `estactif`) VALUES
(1, 'mat1', 1);

-- --------------------------------------------------------

--
-- Structure de la table `plaintes`
--

CREATE TABLE `plaintes` (
  `id` int(11) NOT NULL,
  `Dep_id` int(11) DEFAULT NULL,
  `Heb_id` int(11) DEFAULT NULL,
  `motif` varchar(254) DEFAULT NULL,
  `faits` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `datecreation` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `nom` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nom` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `rue`
--

CREATE TABLE `rue` (
  `id` int(11) NOT NULL,
  `Heb_id` int(11) DEFAULT NULL,
  `Vil_id` int(11) DEFAULT NULL,
  `nom` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `noms` varchar(254) DEFAULT NULL,
  `datenaissance` datetime DEFAULT NULL,
  `lieunaissance` varchar(254) DEFAULT NULL,
  `genre` varchar(254) DEFAULT NULL,
  `username` varchar(254) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `id` int(11) NOT NULL,
  `Com_id` int(11) DEFAULT NULL,
  `nom` int(11) DEFAULT NULL,
  `code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commune`
--
ALTER TABLE `commune`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Association_5` (`Reg_id`);

--
-- Index pour la table `deplace`
--
ALTER TABLE `deplace`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Association_10` (`Dep_id`),
  ADD KEY `FK_Association_11` (`Heb_id`);

--
-- Index pour la table `hebergement`
--
ALTER TABLE `hebergement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `AK_Identifiant_1` (`id`),
  ADD KEY `FK_Association_1` (`Heb_id`),
  ADD KEY `FK_Association_2` (`Dep_id`);

--
-- Index pour la table `hebergeur`
--
ALTER TABLE `hebergeur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `AK_Identifiant_1` (`id`);

--
-- Index pour la table `nationalites`
--
ALTER TABLE `nationalites`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `plaintes`
--
ALTER TABLE `plaintes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Association_6` (`Dep_id`),
  ADD KEY `FK_Association_7` (`Heb_id`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rue`
--
ALTER TABLE `rue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Association_15` (`Heb_id`),
  ADD KEY `FK_Association_3` (`Vil_id`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Association_4` (`Com_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commune`
--
ALTER TABLE `commune`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `deplace`
--
ALTER TABLE `deplace`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `entretien`
--
ALTER TABLE `entretien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `hebergement`
--
ALTER TABLE `hebergement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `hebergeur`
--
ALTER TABLE `hebergeur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `nationalites`
--
ALTER TABLE `nationalites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `plaintes`
--
ALTER TABLE `plaintes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rue`
--
ALTER TABLE `rue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commune`
--
ALTER TABLE `commune`
  ADD CONSTRAINT `FK_Association_5` FOREIGN KEY (`Reg_id`) REFERENCES `region` (`id`);

--
-- Contraintes pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `FK_Association_10` FOREIGN KEY (`Dep_id`) REFERENCES `deplace` (`id`),
  ADD CONSTRAINT `FK_Association_11` FOREIGN KEY (`Heb_id`) REFERENCES `hebergeur` (`id`);

--
-- Contraintes pour la table `hebergement`
--
ALTER TABLE `hebergement`
  ADD CONSTRAINT `FK_Association_1` FOREIGN KEY (`Heb_id`) REFERENCES `hebergeur` (`id`),
  ADD CONSTRAINT `FK_Association_2` FOREIGN KEY (`Dep_id`) REFERENCES `deplace` (`id`);

--
-- Contraintes pour la table `plaintes`
--
ALTER TABLE `plaintes`
  ADD CONSTRAINT `FK_Association_6` FOREIGN KEY (`Dep_id`) REFERENCES `deplace` (`id`),
  ADD CONSTRAINT `FK_Association_7` FOREIGN KEY (`Heb_id`) REFERENCES `hebergeur` (`id`);

--
-- Contraintes pour la table `rue`
--
ALTER TABLE `rue`
  ADD CONSTRAINT `FK_Association_15` FOREIGN KEY (`Heb_id`) REFERENCES `hebergement` (`id`),
  ADD CONSTRAINT `FK_Association_3` FOREIGN KEY (`Vil_id`) REFERENCES `ville` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_Association_12` FOREIGN KEY (`id`) REFERENCES `roles` (`id`);

--
-- Contraintes pour la table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `FK_Association_4` FOREIGN KEY (`Com_id`) REFERENCES `commune` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
