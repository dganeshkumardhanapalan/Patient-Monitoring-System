-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 21, 2013 at 06:48 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `healthmonitoring`
--
CREATE DATABASE IF NOT EXISTS `healthmonitoring` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `healthmonitoring`;

-- --------------------------------------------------------

--
-- Table structure for table `descmaster`
--

CREATE TABLE IF NOT EXISTS `descmaster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `descmaster`
--

INSERT INTO `descmaster` (`id`, `patient_id`, `doctor_id`, `description`, `datetime`) VALUES
(4, 2, 1, 'hello', '2013-09-20 13:48:41'),
(5, 2, 123, 'Description', '2013-09-20 14:00:51'),
(6, 2, 1, 'hello', '2013-09-20 14:11:03'),
(7, 2, 1, 'hello', '2013-09-20 14:12:12'),
(8, 2, 1, 'hellokarthick', '2013-09-20 14:12:20'),
(9, 2, 1, 'hellofianl', '2013-09-20 14:13:26'),
(10, 2, 123, 'Description', '2013-09-20 14:13:40'),
(11, 2, 1, 'hellofianl1', '2013-09-20 14:21:31'),
(12, 2, 9898, 'Description', '2013-09-20 14:23:15'),
(13, 2, 64587, 'Description', '2013-09-20 14:24:33'),
(14, 2, 5, 'Descriptionsdfsdfsdfdsfdsfsdfdsfdasf', '2013-09-20 14:27:38'),
(15, 2, 987653, 'Descriptionsdfsdf', '2013-09-20 14:36:14'),
(16, 2, 98865, 'Description', '2013-09-20 14:52:37'),
(17, 2, 23432, 'Description', '2013-09-21 04:24:20'),
(18, 2, 23432, 'Descriptionsdfsadfsadfsd', '2013-09-21 04:25:59'),
(19, 2, 1, 'hellofianl1 sdfsd', '2013-09-21 04:26:36'),
(20, 2, 23432, 'Descriptionsdfsadfsadfsd_jhkdshfjkdshfhs', '2013-09-21 04:27:55'),
(21, 2, 1, 'hellofianl1 20sdfsd', '2013-09-21 04:32:45'),
(22, 2, 1, 'hellofianl1%karthick', '2013-09-21 04:32:58'),
(23, 2, 2, 'Description asdfsdafsd sdfsdfs dsfsadf sdf sdfs', '2013-09-21 04:37:52'),
(24, 2, 645645, 'Description', '2013-09-21 04:43:42'),
(25, 2, 345345, 'Description', '2013-09-21 04:44:00'),
(26, 2, 34532, 'Description', '2013-09-21 04:44:23');

-- --------------------------------------------------------

--
-- Table structure for table `heartratemaster`
--

CREATE TABLE IF NOT EXISTS `heartratemaster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(5) NOT NULL,
  `v` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `heartratemaster`
--

INSERT INTO `heartratemaster` (`id`, `patient_id`, `v`, `datetime`) VALUES
(1, '00002', 1, '2013-09-20 00:00:00'),
(10, '00002', 0, '2013-09-20 00:00:08'),
(11, '00002', 2, '2013-09-20 00:00:00'),
(12, '00002', 2, '2013-09-20 00:00:01'),
(13, '00002', 3, '2013-09-20 00:00:02'),
(14, '00002', 4, '2013-09-20 00:00:03'),
(15, '00002', 5, '2013-09-20 00:00:04'),
(16, '00002', 4, '2013-09-20 00:00:05'),
(17, '00002', 3, '2013-09-20 00:00:06'),
(18, '00002', 2, '2013-09-20 00:00:07'),
(19, '00002', 1, '2013-09-20 00:00:08'),
(20, '00002', 0, '2013-09-20 00:00:09'),
(21, '00002', 1, '2013-09-20 00:01:00'),
(22, '00002', 2, '2013-09-20 00:02:00'),
(23, '00002', 3, '2013-09-20 00:03:00'),
(24, '00002', 4, '2013-09-20 00:04:00'),
(25, '00002', 5, '2013-09-20 00:05:00'),
(26, '00002', 4, '2013-09-20 00:06:00'),
(27, '00002', 3, '2013-09-20 00:07:00'),
(28, '00002', 2, '2013-09-20 00:08:00'),
(29, '00002', 1, '2013-09-20 00:09:00'),
(30, '00002', 2, '2013-09-20 00:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `stressmaster`
--

CREATE TABLE IF NOT EXISTS `stressmaster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(5) NOT NULL,
  `v` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `stressmaster`
--

INSERT INTO `stressmaster` (`id`, `patient_id`, `v`, `datetime`) VALUES
(1, '1', 1, '2013-09-21 00:00:00'),
(2, '00002', 2, '2013-09-21 00:00:00'),
(3, '00002', 3, '2013-09-21 00:00:01'),
(4, '00002', 4, '2013-09-21 00:00:02'),
(5, '00002', 5, '2013-09-21 00:00:03'),
(6, '00002', 4, '2013-09-21 00:00:04'),
(7, '00002', 3, '2013-09-21 00:00:05'),
(8, '00002', 5, '2013-09-21 00:00:06');

-- --------------------------------------------------------

--
-- Table structure for table `tempmaster`
--

CREATE TABLE IF NOT EXISTS `tempmaster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(5) NOT NULL,
  `v` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tempmaster`
--

INSERT INTO `tempmaster` (`id`, `patient_id`, `v`, `datetime`) VALUES
(1, '00002', 35, '2013-09-20 00:00:00'),
(2, '00002', 40, '2013-09-21 00:00:00'),
(3, '00002', 41, '2013-09-21 00:00:01'),
(4, '00002', 42, '2013-09-21 00:00:02'),
(5, '00002', 38, '2013-09-21 00:00:03'),
(6, '00002', 35, '2013-09-21 00:00:04'),
(7, '00002', 20, '2013-09-21 00:00:05'),
(8, '00002', 10, '2013-09-21 00:00:06');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
