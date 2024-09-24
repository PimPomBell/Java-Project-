-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2023 at 04:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mscore`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` varchar(20) NOT NULL,
  `namaMahasiswa` varchar(50) NOT NULL,
  `asalUniversitas` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `namaMahasiswa`, `asalUniversitas`) VALUES
('260219202201', 'Randy Abdul', 'Universitas Bina Nusantara'),
('260219202202', 'Fudgy Selly', 'Universitas Bina Nusantara'),
('260219202203', 'Jessica Sukiman', 'Universitas Bina Nusantara'),
('260219202204', 'Najla Coands', 'Universitas Bina Nusantara'),
('260219202205', 'Anselle Sinthing', 'Universitas Bina Nusantara'),
('260219202206', 'Bellion', 'Universitas Bina Nusantara'),
('2602195792', 'Pimpom', 'Universitas Bina Nusantara');

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `idMataKuliah` varchar(20) NOT NULL,
  `namaMataKuliah` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`idMataKuliah`, `namaMataKuliah`) VALUES
('MK0001', 'Introduction to Database'),
('MK0002', 'Financial Accounting'),
('MK0003', 'Business Process Fundamental'),
('MK0004', 'User Experience & User Interface'),
('MK0005', 'Introduction to Java System');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `idNilai` int(11) NOT NULL,
  `NIM` varchar(20) NOT NULL,
  `idMataKuliah` varchar(20) NOT NULL,
  `idPengguna` varchar(5) NOT NULL,
  `jumlahNilai` int(11) DEFAULT NULL,
  `grade` varchar(2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`idNilai`, `NIM`, `idMataKuliah`, `idPengguna`, `jumlahNilai`, `grade`, `status`) VALUES
(1, '260219202201', 'MK0001', 'PA002', 78, 'B', 'PASS'),
(2, '260219202204', 'MK0002', 'PA002', 85, 'A-', 'PASS'),
(3, '260219202202', 'MK0003', 'PA002', 80, 'B+', 'PASS'),
(4, '260219202203', 'MK0003', 'PA002', 65, 'C', 'FAIL'),
(5, '260219202203', 'MK0004', 'PA002', 78, 'B', 'PASS'),
(6, '260219202203', 'MK0005', 'PA002', 22, 'E', 'FAIL'),
(7, '2602195792', 'MK0004', 'PA002', 100, 'A', 'PASS');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `idPengguna` varchar(5) NOT NULL,
  `namaPengguna` varchar(50) NOT NULL,
  `tempatKerjaPengguna` varchar(50) NOT NULL,
  `emailPengguna` varchar(50) NOT NULL,
  `nomorTelpPengguna` varchar(12) NOT NULL,
  `passwordPengguna` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`idPengguna`, `namaPengguna`, `tempatKerjaPengguna`, `emailPengguna`, `nomorTelpPengguna`, `passwordPengguna`) VALUES
('PA001', 'Suwandi Saptikaka', 'Universitas Bina Nusantara', 'kakawandi123@gmail.com', '081234567890', 'wandi123'),
('PA002', 'Wendy Agung', 'Universitas Bina Nusantara', 'wengung222@gmail.com', '083456789012', 'agung123'),
('PA003', 'Rijal Evanthe', 'Universitas Bina Nusantara', 'jalajala345@gmail.com', '082378567098', 'rijal123'),
('PA004', 'Vano Tianta', 'Universitas Bina Nusantara', 'vanti23@gmail.com', '081307881940', 'vanovano123'),
('PA005', 'Agus Witjaksono', 'Universitas Bina Nusantara', 'gusnono987@gmail.com', '089876543210', 'gusgus123'),
('PA006', 'Bellion', 'Binus', 'ashjkdk@gmail.com', '081389680088', 'pimpom'),
('PA007', 'Bell', 'Universitas Bina Nusantara', 'pimpom@gmail.com', '081389680088', 'pimpom');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`idMataKuliah`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`idNilai`),
  ADD KEY `FK_NIM` (`NIM`),
  ADD KEY `FK_idMataKuliah` (`idMataKuliah`),
  ADD KEY `FK_idPengguna` (`idPengguna`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`idPengguna`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `idNilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `FK_NIM` FOREIGN KEY (`NIM`) REFERENCES `mahasiswa` (`NIM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_idMataKuliah` FOREIGN KEY (`idMataKuliah`) REFERENCES `matakuliah` (`idMataKuliah`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_idPengguna` FOREIGN KEY (`idPengguna`) REFERENCES `pengguna` (`idPengguna`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
