-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2021 at 04:54 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_flyaway`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `clientid` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`clientid`, `username`, `password`, `role`) VALUES
(1, 'test-1', 'test1234', 1),
(2, 'test-2', 'test1234', 1),
(3, 'test-3', 'test1234', 1),
(4, 'test-4', 'test1234', 1),
(5, 'admin', 'admin', 100),
(6, 'test-105', 'test1234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `flightname` varchar(255) NOT NULL,
  `sourcee` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `priceperseat` varchar(255) NOT NULL,
  `date_time` varchar(255) NOT NULL,
  `totalseats` int(11) NOT NULL DEFAULT '35',
  `availableseats` int(11) NOT NULL DEFAULT '35'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `flightname`, `sourcee`, `designation`, `priceperseat`, `date_time`, `totalseats`, `availableseats`) VALUES
(1, 'flight 101', 'source 101', 'designation 101', '1000', '25-02-2021 - 12:35PM', 35, 12),
(2, 'flight 102', 'source 102', 'designation 102', '1500', '27-02-2021 - 09:15PM', 65, 47),
(3, 'flight 103', 'source 103', 'designation 103', '1250', '28-02-2021 - 11:30PM', 43, 29),
(4, 'flight 104', 'source 104', 'designation 104', '2700', '03-03-2021 - 10:00PM', 20, 17),
(5, 'tf 1', 's 1', 'd 1', '1400', '12-01-2021 14:25', 45, 45),
(6, 'flight 101', 'country 1', 'country 2', '1200', '25-02-2021 10:45', 45, 45);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`clientid`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `clientid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
