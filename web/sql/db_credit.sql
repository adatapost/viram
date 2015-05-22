-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2015 at 08:13 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_credit`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `middle_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `address` varchar(500) NOT NULL,
  `city_id` int(11) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `reference_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `cust_img` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `city_id` (`city_id`),
  KEY `reference_id` (`reference_id`),
  KEY `type_id` (`type_id`),
  KEY `created_by` (`created_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `first_name`, `middle_name`, `last_name`, `gender`, `address`, `city_id`, `phone`, `birth_date`, `reference_id`, `type_id`, `is_deleted`, `created`, `updated`, `created_by`, `cust_img`) VALUES
(1, 'SELF', 'SELF', 'SELF', '', 'SELF', 1, '9955443322', '2015-04-01', 1, 1, 0, '2015-04-01 00:00:00', NULL, 1, NULL),
(27, 'Tarak', 'S', 'Maheta', 'male', '12 - Social Society', 1, '39939292992', '1972-01-01', 1, 2, 0, '2015-04-13 11:39:21', NULL, 1, '27'),
(28, 'Tamar', 'Manira', 'Solanki', 'female', '34 - E.S.O Park\r\nNew Road - West', 2, '39939292992', '1972-01-01', 1, 1, 0, '2015-04-13 11:41:28', NULL, 1, '28'),
(29, 'Patel', 'Sohanlal', 'Shantilal', 'male', '12 - S.O Society\r\nNear Ram Bagh\r\n', 2, '39939393', '1992-01-01', 28, 2, 0, '2015-04-24 12:03:47', NULL, 10, '29'),
(30, 'Patel', 'Mamta', 'S', 'female', '12 - E. S . Society\r\nNr. Rambagh\r\nBaroda Express Highway', 2, '9988776655', '1992-05-18', 28, 2, 0, '2015-05-18 09:21:22', NULL, 1, '30');

-- --------------------------------------------------------

--
-- Table structure for table `account_type`
--

CREATE TABLE IF NOT EXISTS `account_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(40) NOT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `account_type`
--

INSERT INTO `account_type` (`type_id`, `type_name`) VALUES
(2, 'Current'),
(1, 'Savings');

-- --------------------------------------------------------

--
-- Table structure for table `acc_master`
--

CREATE TABLE IF NOT EXISTS `acc_master` (
  `master_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `firm` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  PRIMARY KEY (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(40) NOT NULL,
  `state_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_id` (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `city_name`, `state_id`) VALUES
(1, 'Ahmedabad', 1),
(2, 'Baroda', 1),
(3, 'Surat', 1),
(4, 'Mehsana', 1),
(5, 'Patan', 1),
(6, 'Jaipur', 2),
(7, 'Udaipur', 2),
(8, 'Rajkot', 1),
(9, 'Mumbai', 3),
(10, 'Pune', 3);

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE IF NOT EXISTS `deposit` (
  `ledger_id` int(11) NOT NULL DEFAULT '0',
  `start_date` datetime DEFAULT NULL,
  `maturity_date` datetime DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `interest_rate` decimal(18,2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `term` int(11) NOT NULL,
  PRIMARY KEY (`ledger_id`),
  KEY `ledger_id` (`ledger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deposit`
--

INSERT INTO `deposit` (`ledger_id`, `start_date`, `maturity_date`, `amount`, `interest_rate`, `created`, `term`) VALUES
(19, '2015-04-13 00:00:00', '2015-12-13 00:00:00', '50000.00', '9.00', '2015-04-13 14:36:46', 90),
(23, '2015-04-13 14:55:20', '2015-04-13 14:55:20', '0.00', '0.00', '2015-04-13 14:55:20', 0),
(33, '2015-05-18 00:00:00', '2015-05-18 00:00:00', '10000.00', '9.00', '2015-05-18 09:25:13', 5);

-- --------------------------------------------------------

--
-- Table structure for table `journal`
--

CREATE TABLE IF NOT EXISTS `journal` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_date` datetime DEFAULT NULL,
  `cr_ledger_id` int(11) DEFAULT NULL,
  `dr_ledger_id` int(11) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `particular` varchar(200) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`doc_id`),
  KEY `cr_ledger_id` (`cr_ledger_id`),
  KEY `dr_ledger_id` (`dr_ledger_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `journal`
--

INSERT INTO `journal` (`doc_id`, `doc_date`, `cr_ledger_id`, `dr_ledger_id`, `amount`, `particular`, `is_deleted`) VALUES
(1, '2015-04-13 13:17:48', 17, 24, '40000.00', 'Cash deposit', 0),
(2, '2015-04-15 13:50:29', 24, 17, '5000.00', 'Self withdrawn', 0),
(3, '2015-04-15 13:54:35', 17, 27, '10.00', 'Interest added', 0),
(6, '2015-04-24 00:00:00', 22, 24, '2000.00', 'Two loan installments', 0),
(7, '2015-04-24 00:00:00', 29, 24, '5000.00', 'Cash deposit', 0),
(8, '2015-04-25 00:00:00', 29, 25, '15000.00', 'Bank of India Chq : 32029922 Dated - 25-4-2015', 0),
(9, '2015-04-26 00:00:00', 24, 29, '6000.00', 'Cash withdrawn', 0),
(10, '2015-04-24 00:00:00', 30, 24, '100.00', 'Cash', 0),
(11, '2015-05-24 00:00:00', 30, 24, '100.00', 'Cash', 0),
(12, '2015-04-13 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(13, '2015-04-14 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(16, '2015-04-24 00:00:00', 24, 17, '5000.00', 'Cash withdrawn', 0),
(17, '2015-04-15 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(18, '2015-04-16 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(19, '2015-04-16 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(20, '2015-04-17 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(21, '2015-04-18 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(22, '2015-04-19 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(23, '2015-04-20 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(24, '2015-04-21 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(25, '2015-04-22 00:00:00', 21, 24, '1000.00', 'Cash ', 0),
(26, '2015-04-23 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(27, '2015-04-24 00:00:00', 21, 24, '1000.00', 'Cash', 0),
(28, '2015-04-13 00:00:00', 19, 24, '50000.00', 'Cash deposit', 0),
(29, '2015-05-18 00:00:00', 24, 32, '20000.00', 'Loan issue amount - cash', 0),
(30, '2015-05-18 00:00:00', 31, 24, '10000.00', 'Deposit', 0),
(31, '2015-06-18 00:00:00', 24, 31, '500.00', 'Withdwan', 0),
(32, '2015-05-18 00:00:00', 22, 24, '1000.00', 'Installment for month 07', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ledger`
--

CREATE TABLE IF NOT EXISTS `ledger` (
  `ledger_id` int(11) NOT NULL AUTO_INCREMENT,
  `ledger_type_id` int(11) DEFAULT NULL,
  `ledger_name` varchar(100) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `is_closed` tinyint(1) DEFAULT '0',
  `is_deleted` tinyint(1) DEFAULT '0',
  `current_ac_year` int(11) DEFAULT NULL,
  PRIMARY KEY (`ledger_id`),
  KEY `ledger_type_id` (`ledger_type_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `ledger`
--

INSERT INTO `ledger` (`ledger_id`, `ledger_type_id`, `ledger_name`, `account_id`, `created`, `updated`, `is_closed`, `is_deleted`, `current_ac_year`) VALUES
(17, 2, 'Tarak S Maheta Current A/C', 27, '2015-04-13 11:39:25', NULL, 0, 0, 2015),
(18, 2, 'Tamar Manira Solanki Savings A/C', 28, '2015-04-13 11:41:32', NULL, 0, 0, 2015),
(19, 6, 'Tarak S Maheta Fixed Deposit A/C', 27, '2015-04-13 14:36:45', '2015-05-09 11:01:18', 0, 0, 2015),
(21, 5, 'Tarak S Maheta Recurring Deposit A/C', 27, '2015-04-13 14:37:52', '2015-04-24 12:42:01', 0, 0, 2015),
(22, 7, 'Tarak S Maheta Loan A/C', 27, '2015-04-13 14:40:03', '2015-04-24 10:47:02', 0, 0, 2015),
(23, 6, 'Tamar Manira Solanki Fixed Deposit A/C', 28, '2015-04-13 14:55:19', '2015-04-13 14:55:19', 0, 0, 2015),
(24, 1, 'Cash In Hand A/C', 1, '2015-04-15 08:44:48', '2015-04-15 08:44:48', 0, 0, 2015),
(25, 1, 'Bank A/C', 1, '2015-04-15 08:45:13', '2015-04-15 08:45:13', 0, 0, 2015),
(26, 3, 'Interest Income A/C', 1, '2015-04-15 08:45:37', '2015-04-15 08:45:37', 0, 0, 2015),
(27, 4, 'Interest Expense A/C', 1, '2015-04-15 08:45:48', '2015-04-15 08:45:48', 0, 0, 2015),
(28, 7, 'Tamar Manira Solanki Loan A/C', 28, '2015-04-24 09:35:29', '2015-04-24 10:44:52', 0, 0, 2015),
(29, 2, 'Patel Sohanlal Shantilal Current A/C', 29, '2015-04-24 12:03:51', NULL, 0, 0, 2015),
(30, 5, 'Patel Sohanlal Shantilal Recurring Deposit A/C', 29, '2015-04-24 12:08:58', '2015-04-24 12:20:20', 0, 0, 2015),
(31, 2, 'Patel Mamta S Current A/C', 30, '2015-05-18 09:21:22', NULL, 0, 0, 2015),
(32, 7, 'Patel Mamta S Loan A/C', 30, '2015-05-18 09:21:55', '2015-05-18 09:24:42', 0, 0, 2015),
(33, 6, 'Patel Mamta S Fixed Deposit A/C', 30, '2015-05-18 09:25:13', '2015-05-18 09:25:47', 0, 0, 2015);

-- --------------------------------------------------------

--
-- Table structure for table `ledger_type`
--

CREATE TABLE IF NOT EXISTS `ledger_type` (
  `ledger_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `ledger_type_name` varchar(100) NOT NULL,
  PRIMARY KEY (`ledger_type_id`),
  UNIQUE KEY `ledger_type_name` (`ledger_type_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ledger_type`
--

INSERT INTO `ledger_type` (`ledger_type_id`, `ledger_type_name`) VALUES
(1, 'Assets'),
(4, 'Expense'),
(6, 'Fixed Deposit'),
(3, 'Income'),
(8, 'Liabilities'),
(7, 'Loan'),
(5, 'Recurring Deposit'),
(2, 'Saving / Current Deposit');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE IF NOT EXISTS `loan` (
  `ledger_id` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `interest_rate` decimal(18,2) DEFAULT NULL,
  `installment` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`ledger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`ledger_id`, `start_date`, `end_date`, `amount`, `interest_rate`, `installment`, `created`) VALUES
(22, '2015-04-13 00:00:00', '2016-04-13 00:00:00', '12000.00', '10.00', 1000, '2015-04-13 14:40:03'),
(28, '2015-04-24 00:00:00', '2016-02-24 00:00:00', '50000.00', '10.00', 5000, '2015-04-24 09:35:29'),
(32, '2015-05-18 00:00:00', '2016-03-18 00:00:00', '20000.00', '10.00', 2000, '2015-05-18 09:21:55');

-- --------------------------------------------------------

--
-- Table structure for table `loan_installment`
--

CREATE TABLE IF NOT EXISTS `loan_installment` (
  `inst_id` int(11) NOT NULL AUTO_INCREMENT,
  `ledger_id` int(11) NOT NULL,
  `inst_amount` decimal(10,0) NOT NULL,
  `inst_date` date NOT NULL,
  `paid_date` date DEFAULT NULL,
  PRIMARY KEY (`inst_id`),
  KEY `ledger_id` (`ledger_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `loan_installment`
--

INSERT INTO `loan_installment` (`inst_id`, `ledger_id`, `inst_amount`, `inst_date`, `paid_date`) VALUES
(13, 28, '5000', '2015-05-24', NULL),
(14, 28, '5000', '2015-06-24', NULL),
(15, 28, '5000', '2015-07-24', NULL),
(16, 28, '5000', '2015-08-24', NULL),
(17, 28, '5000', '2015-09-24', NULL),
(18, 28, '5000', '2015-10-24', NULL),
(19, 28, '5000', '2015-11-24', NULL),
(20, 28, '5000', '2015-12-24', NULL),
(21, 28, '5000', '2016-01-24', NULL),
(22, 28, '5000', '2016-02-24', NULL),
(23, 22, '1000', '2015-05-13', '2015-04-24'),
(24, 22, '1000', '2015-06-13', '2015-04-24'),
(25, 22, '1000', '2015-07-13', '2015-05-18'),
(26, 22, '1000', '2015-08-13', NULL),
(27, 22, '1000', '2015-09-13', NULL),
(28, 22, '1000', '2015-10-13', NULL),
(29, 22, '1000', '2015-11-13', NULL),
(30, 22, '1000', '2015-12-13', NULL),
(31, 22, '1000', '2016-01-13', NULL),
(32, 22, '1000', '2016-02-13', NULL),
(33, 22, '1000', '2016-03-13', NULL),
(34, 22, '1000', '2016-04-13', NULL),
(35, 32, '2000', '2015-06-18', '2015-05-18'),
(36, 32, '2000', '2015-07-18', '2015-05-18'),
(37, 32, '2000', '2015-08-18', '2015-05-18'),
(38, 32, '2000', '2015-09-18', '2015-05-18'),
(39, 32, '2000', '2015-10-18', '2015-05-18'),
(40, 32, '2000', '2015-11-18', '2015-05-18'),
(41, 32, '2000', '2015-12-18', '2015-05-18'),
(42, 32, '2000', '2016-01-18', '2015-05-18'),
(43, 32, '2000', '2016-02-18', '2015-05-18'),
(44, 32, '2000', '2016-03-18', '2015-05-18');

-- --------------------------------------------------------

--
-- Table structure for table `nominee`
--

CREATE TABLE IF NOT EXISTS `nominee` (
  `nominee_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) NOT NULL,
  `middle_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`nominee_id`),
  KEY `account_id` (`account_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `nominee`
--

INSERT INTO `nominee` (`nominee_id`, `first_name`, `middle_name`, `last_name`, `gender`, `birth_date`, `account_id`) VALUES
(8, 'SELF', 'SELF', 'SELF', 'Male', '2015-04-01', 1),
(11, 'Manisha', 'Tarak', 'Mehta', 'female', '1992-01-01', 27),
(12, 'Dish', 'Tamara', 'Solanki', 'female', '1992-01-01', 28),
(13, 'Patel', 'Neena', 'Shantilal', 'female', '1996-01-01', 29),
(14, 'Patel', 'Shdradha', 'S', 'female', '2002-05-28', 30);

-- --------------------------------------------------------

--
-- Table structure for table `recurring`
--

CREATE TABLE IF NOT EXISTS `recurring` (
  `ledger_id` int(11) NOT NULL DEFAULT '0',
  `start_date` datetime DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `interest_rate` decimal(18,2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`ledger_id`),
  KEY `ledger_id` (`ledger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurring`
--

INSERT INTO `recurring` (`ledger_id`, `start_date`, `frequency`, `term`, `end_date`, `amount`, `interest_rate`, `created`) VALUES
(21, '2015-04-01 00:00:00', 0, 30, '2015-05-01 00:00:00', '1000.00', '5.00', '2015-04-13 14:37:52'),
(30, '2015-04-01 00:00:00', 2, 50, '2019-05-10 00:00:00', '100.00', '9.00', '2015-04-24 12:08:58');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'Admin'),
(3, 'Customer'),
(2, 'Employee');

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE IF NOT EXISTS `state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(40) NOT NULL,
  PRIMARY KEY (`state_id`),
  UNIQUE KEY `state_name` (`state_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`state_id`, `state_name`) VALUES
(1, 'Gujarat'),
(6, 'Madhyapradesh'),
(3, 'Maharashtra'),
(2, 'Rajasthan'),
(5, 'Uttarpradesh');

-- --------------------------------------------------------

--
-- Table structure for table `user_account`
--

CREATE TABLE IF NOT EXISTS `user_account` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(100) NOT NULL,
  `user_pass` varchar(40) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `is_activate` tinyint(1) DEFAULT '0',
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `user_account`
--

INSERT INTO `user_account` (`user_id`, `user_email`, `user_pass`, `role_id`, `created`, `updated`, `is_deleted`, `is_activate`, `last_login`) VALUES
(1, 'admin@gmail.com', '0DPiKuNIrrVmD8IUCuw1hQxNqZc=', 1, '2015-02-23 00:00:00', NULL, 0, 1, '2015-05-18 10:21:33'),
(10, 'ramesh@ccs.com', 'o+RQMz2XL2P/i8ezLW8850IUqI4=', 2, '2015-04-10 14:13:02', NULL, 0, 0, '2015-05-18 09:33:54'),
(27, 'tarak@custmer.com', 'WPM9oM95ClAC7xJuuU4xe/qcZsY=', 3, '2015-04-13 11:39:21', NULL, 0, 1, NULL),
(28, 'tamar@custmer.com', 'TpmwcvuSTVXCNc2dtoOEZSPpP3Y=', 3, '2015-04-13 11:41:28', NULL, 0, 1, NULL),
(29, 'sohanlal@bank.com', 'J8Cd4JByWf/27pZQc/nZ1TXoDok=', 3, '2015-04-24 12:03:47', NULL, 0, 1, NULL),
(30, 'mamta@ccs.com', 'Ge9q797PznFZ88e46ojcB8aon/A=', 3, '2015-05-18 09:21:22', NULL, 0, 1, '2015-05-18 09:37:23');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_account`
--
CREATE TABLE IF NOT EXISTS `view_account` (
`account_id` int(11)
,`first_name` varchar(40)
,`middle_name` varchar(40)
,`last_name` varchar(40)
,`gender` varchar(7)
,`address` varchar(500)
,`city_id` int(11)
,`phone` varchar(40)
,`birth_date` date
,`reference_id` int(11)
,`type_id` int(11)
,`is_deleted` tinyint(1)
,`created` datetime
,`updated` datetime
,`created_by` int(11)
,`cust_img` varchar(40)
,`full_name` varchar(122)
,`city_name` varchar(40)
,`state_name` varchar(40)
,`type_name` varchar(40)
,`ref_full_name` varchar(122)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `view_city`
--
CREATE TABLE IF NOT EXISTS `view_city` (
`city_id` int(11)
,`city_name` varchar(40)
,`state_id` int(11)
,`state_name` varchar(40)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `view_journal`
--
CREATE TABLE IF NOT EXISTS `view_journal` (
`doc_id` int(11)
,`doc_date` datetime
,`cr_ledger_id` int(11)
,`dr_ledger_id` int(11)
,`amount` decimal(18,2)
,`particular` varchar(200)
,`is_deleted` tinyint(1)
,`cr_ledger_name` varchar(100)
,`dr_ledger_name` varchar(100)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `view_journal_test`
--
CREATE TABLE IF NOT EXISTS `view_journal_test` (
`doc_id` int(11)
,`doc_date` datetime
,`cr_ledger` varchar(100)
,`dr_ledger` varchar(100)
,`amount` decimal(18,2)
,`particular` varchar(200)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `view_ledger`
--
CREATE TABLE IF NOT EXISTS `view_ledger` (
`ledger_id` int(11)
,`ledger_type_id` int(11)
,`ledger_name` varchar(100)
,`account_id` int(11)
,`created` datetime
,`updated` datetime
,`is_closed` tinyint(1)
,`is_deleted` tinyint(1)
,`current_ac_year` int(11)
,`ledger_type_name` varchar(100)
,`full_name` varchar(122)
,`address` varchar(500)
,`city_name` varchar(40)
,`state_name` varchar(40)
);
-- --------------------------------------------------------

--
-- Structure for view `view_account`
--
DROP TABLE IF EXISTS `view_account`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_account` AS select `a`.`account_id` AS `account_id`,`a`.`first_name` AS `first_name`,`a`.`middle_name` AS `middle_name`,`a`.`last_name` AS `last_name`,`a`.`gender` AS `gender`,`a`.`address` AS `address`,`a`.`city_id` AS `city_id`,`a`.`phone` AS `phone`,`a`.`birth_date` AS `birth_date`,`a`.`reference_id` AS `reference_id`,`a`.`type_id` AS `type_id`,`a`.`is_deleted` AS `is_deleted`,`a`.`created` AS `created`,`a`.`updated` AS `updated`,`a`.`created_by` AS `created_by`,`a`.`cust_img` AS `cust_img`,concat(`a`.`first_name`,' ',`a`.`middle_name`,' ',`a`.`last_name`) AS `full_name`,`view_city`.`city_name` AS `city_name`,`view_city`.`state_name` AS `state_name`,`account_type`.`type_name` AS `type_name`,concat(`b`.`first_name`,' ',`b`.`middle_name`,' ',`b`.`last_name`) AS `ref_full_name` from (((`account` `a` join `view_city` on((`view_city`.`city_id` = `a`.`city_id`))) join `account_type` on((`account_type`.`type_id` = `a`.`type_id`))) join `account` `b` on((`b`.`account_id` = `a`.`reference_id`)));

-- --------------------------------------------------------

--
-- Structure for view `view_city`
--
DROP TABLE IF EXISTS `view_city`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_city` AS select `city`.`city_id` AS `city_id`,`city`.`city_name` AS `city_name`,`city`.`state_id` AS `state_id`,`state`.`state_name` AS `state_name` from (`city` join `state` on((`state`.`state_id` = `city`.`state_id`)));

-- --------------------------------------------------------

--
-- Structure for view `view_journal`
--
DROP TABLE IF EXISTS `view_journal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_journal` AS select `journal`.`doc_id` AS `doc_id`,`journal`.`doc_date` AS `doc_date`,`journal`.`cr_ledger_id` AS `cr_ledger_id`,`journal`.`dr_ledger_id` AS `dr_ledger_id`,`journal`.`amount` AS `amount`,`journal`.`particular` AS `particular`,`journal`.`is_deleted` AS `is_deleted`,`a`.`ledger_name` AS `cr_ledger_name`,`b`.`ledger_name` AS `dr_ledger_name` from ((`journal` join `ledger` `a` on((`a`.`ledger_id` = `journal`.`cr_ledger_id`))) join `ledger` `b` on((`b`.`ledger_id` = `journal`.`dr_ledger_id`)));

-- --------------------------------------------------------

--
-- Structure for view `view_journal_test`
--
DROP TABLE IF EXISTS `view_journal_test`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_journal_test` AS select `journal`.`doc_id` AS `doc_id`,`journal`.`doc_date` AS `doc_date`,`a`.`ledger_name` AS `cr_ledger`,`b`.`ledger_name` AS `dr_ledger`,`journal`.`amount` AS `amount`,`journal`.`particular` AS `particular` from ((`journal` join `ledger` `a` on((`a`.`ledger_id` = `journal`.`cr_ledger_id`))) join `ledger` `b` on((`b`.`ledger_id` = `journal`.`dr_ledger_id`)));

-- --------------------------------------------------------

--
-- Structure for view `view_ledger`
--
DROP TABLE IF EXISTS `view_ledger`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_ledger` AS select `ledger`.`ledger_id` AS `ledger_id`,`ledger`.`ledger_type_id` AS `ledger_type_id`,`ledger`.`ledger_name` AS `ledger_name`,`ledger`.`account_id` AS `account_id`,`ledger`.`created` AS `created`,`ledger`.`updated` AS `updated`,`ledger`.`is_closed` AS `is_closed`,`ledger`.`is_deleted` AS `is_deleted`,`ledger`.`current_ac_year` AS `current_ac_year`,`ledger_type`.`ledger_type_name` AS `ledger_type_name`,`view_account`.`full_name` AS `full_name`,`view_account`.`address` AS `address`,`view_account`.`city_name` AS `city_name`,`view_account`.`state_name` AS `state_name` from ((`ledger` join `ledger_type` on((`ledger_type`.`ledger_type_id` = `ledger`.`ledger_type_id`))) join `view_account` on((`view_account`.`account_id` = `ledger`.`account_id`)));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`user_id`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  ADD CONSTRAINT `account_ibfk_3` FOREIGN KEY (`reference_id`) REFERENCES `user_account` (`user_id`),
  ADD CONSTRAINT `account_ibfk_4` FOREIGN KEY (`type_id`) REFERENCES `account_type` (`type_id`),
  ADD CONSTRAINT `account_ibfk_5` FOREIGN KEY (`created_by`) REFERENCES `user_account` (`user_id`);

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `city_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`);

--
-- Constraints for table `deposit`
--
ALTER TABLE `deposit`
  ADD CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`ledger_id`) REFERENCES `ledger` (`ledger_id`);

--
-- Constraints for table `journal`
--
ALTER TABLE `journal`
  ADD CONSTRAINT `journal_ibfk_1` FOREIGN KEY (`cr_ledger_id`) REFERENCES `ledger` (`ledger_id`),
  ADD CONSTRAINT `journal_ibfk_2` FOREIGN KEY (`dr_ledger_id`) REFERENCES `ledger` (`ledger_id`);

--
-- Constraints for table `ledger`
--
ALTER TABLE `ledger`
  ADD CONSTRAINT `ledger_ibfk_1` FOREIGN KEY (`ledger_type_id`) REFERENCES `ledger_type` (`ledger_type_id`),
  ADD CONSTRAINT `ledger_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`ledger_id`) REFERENCES `ledger` (`ledger_id`);

--
-- Constraints for table `loan_installment`
--
ALTER TABLE `loan_installment`
  ADD CONSTRAINT `loan_installment_ibfk_1` FOREIGN KEY (`ledger_id`) REFERENCES `ledger` (`ledger_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nominee`
--
ALTER TABLE `nominee`
  ADD CONSTRAINT `nominee_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `recurring`
--
ALTER TABLE `recurring`
  ADD CONSTRAINT `recurring_ibfk_1` FOREIGN KEY (`ledger_id`) REFERENCES `ledger` (`ledger_id`);

--
-- Constraints for table `user_account`
--
ALTER TABLE `user_account`
  ADD CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
