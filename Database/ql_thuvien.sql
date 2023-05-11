-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 11, 2023 lúc 06:12 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_thuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `MaPhieuMuon` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaPhieuMuon`, `MaSach`, `SoLuong`) VALUES
(1, 1, 2),
(1, 3, 2),
(2, 2, 3),
(2, 4, 3),
(2, 8, 2),
(3, 2, 5),
(3, 7, 1),
(4, 8, 10),
(5, 2, 3),
(5, 3, 3),
(5, 4, 3),
(6, 1, 1),
(6, 2, 57),
(6, 4, 57),
(6, 9, 1),
(7, 1, 3),
(7, 2, 2),
(7, 3, 3),
(7, 4, 2),
(7, 5, 3),
(8, 2, 1),
(8, 3, 3),
(9, 2, 8),
(9, 3, 8),
(10, 2, 1),
(10, 3, 1),
(11, 1, 2),
(11, 2, 2),
(11, 3, 2),
(12, 4, 1),
(13, 1, 3),
(14, 3, 2),
(14, 5, 1),
(15, 1, 1),
(15, 3, 3),
(16, 1, 1),
(16, 2, 2),
(16, 3, 1),
(16, 4, 7),
(17, 1, 7),
(17, 3, 5),
(18, 1, 1),
(18, 2, 43),
(20, 1, 4),
(25, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPhieuNhap` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaSach`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(1, 1, 2000, 10000, 20000000),
(1, 3, 2000, 150000, 300000000),
(2, 4, 100, 150000, 15000000),
(2, 5, 100, 150000, 15000000),
(3, 11, 100, 10000, 1000000),
(3, 15, 100, 12000, 1200000),
(7, 3, 4, 10000, 0),
(8, 3, 3, 150000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`Ma`, `Ten`, `Ho`, `NgaySinh`, `GioiTinh`, `SoDienThoai`) VALUES
(1, 'Tỏm', 'Tỏm', '2022-11-07', 'nam', ' 024382208'),
(2, 'Tèo', 'Trần', '2004-04-24', 'nu', '0333220808'),
(3, 'Tún', 'Nguyễn', '2003-04-04', 'nu', '0985555999');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`Ma`, `Ten`, `DiaChi`, `SoDienThoai`) VALUES
(1, 'nha cung cap 1', 'Bình Hưng Hòa , Bình Tân', '0789412346'),
(2, 'nha cung cap 2', 'Bình Dương', '0789412556'),
(3, 'nha cung cap 3', 'Bình nuyên vô tận', '0789412336');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Luong` int(11) NOT NULL,
  `DiaChi` text NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL,
  `MatKhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`Ma`, `Ten`, `Ho`, `Luong`, `DiaChi`, `NgaySinh`, `GioiTinh`, `SoDienThoai`, `MatKhau`) VALUES
(1, 'Đức', 'Huỳnh', 5000000, '273 An Dương Vương', '2023-04-01', 'nam', '0243820333', '12345'),
(2, 'Tùng', 'Huỳnh', 5000000, '274 An Dương Vương', '2003-05-01', 'nam', '0143822333', '12345'),
(3, 'Minh', 'Huỳnh', 10000000, '273 An Dương Vương', '2000-04-01', 'nu', '0113820333', '12345');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDienThoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`Ma`, `Ten`, `DiaChi`, `SoDienThoai`) VALUES
(1, 'Nha xuat ban 1', 'Dia Chi 1', 985546985),
(2, 'Nha xuat ban 2', 'Dia chi 2', 333222333),
(3, 'Nha xuat ban 3', 'Dia chi 3', 455444666);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `noiquyphat`
--

CREATE TABLE `noiquyphat` (
  `Ma` int(11) NOT NULL,
  `NoiDung` varchar(255) NOT NULL,
  `CongThuc` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `noiquyphat`
--

INSERT INTO `noiquyphat` (`Ma`, `NoiDung`, `CongThuc`) VALUES
(1, 'mat', '3'),
(2, 'hong nang', '2'),
(3, 'hong nhe', '1'),
(4, 'tre nhe', '0.2'),
(5, 'tre nang', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `Ma` int(11) NOT NULL,
  `MaNhanVien` int(11) NOT NULL,
  `MaDocGia` int(11) NOT NULL,
  `NgayMuon` date NOT NULL,
  `NgayTra` date NOT NULL,
  `NgayTraThuc` date DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieumuon`
--

INSERT INTO `phieumuon` (`Ma`, `MaNhanVien`, `MaDocGia`, `NgayMuon`, `NgayTra`, `NgayTraThuc`, `TrangThai`) VALUES
(0, 1, 1, '2023-05-03', '2023-05-03', '2023-05-03', 1),
(1, 1, 1, '2023-04-02', '2023-04-02', '2023-04-02', 1),
(2, 2, 3, '2023-04-02', '2023-04-02', '2023-04-02', 1),
(3, 3, 2, '2023-04-02', '2023-04-02', '2023-04-02', 1),
(4, 1, 2, '2023-05-03', '2023-05-03', '2023-05-03', 1),
(5, 1, 1, '2023-05-03', '2023-05-03', '2023-05-03', 1),
(6, 2, 2, '2023-05-04', '2023-05-04', '2023-05-04', 1),
(7, 2, 2, '2023-01-20', '2023-01-20', '2023-01-20', 1),
(8, 1, 1, '2023-01-17', '2023-01-17', '2023-01-17', 1),
(9, 1, 1, '2023-05-04', '2023-05-04', '2023-05-04', 1),
(10, 1, 1, '2023-01-04', '2023-01-04', '2023-01-04', 1),
(11, 1, 1, '2023-05-04', '2023-05-04', '2023-05-04', 1),
(12, 1, 1, '2023-05-03', '2023-05-03', '2023-05-03', 1),
(13, 1, 1, '2023-01-06', '2023-01-06', '2023-01-06', 1),
(14, 2, 2, '2023-01-03', '2023-01-03', '2023-01-03', 1),
(15, 1, 1, '2023-01-04', '2023-01-04', '2023-01-04', 1),
(16, 1, 1, '2023-01-04', '2023-01-04', '2023-01-04', 1),
(17, 3, 2, '2023-05-09', '2023-05-09', '2023-05-09', 1),
(18, 1, 1, '2023-05-03', '2023-05-03', '2023-05-03', 1),
(19, 1, 1, '2023-01-05', '2023-01-05', '2023-01-05', 1),
(20, 1, 1, '2023-05-04', '2023-05-04', '2023-05-04', 1),
(21, 1, 1, '2023-01-04', '2023-01-04', '2023-01-04', 1),
(22, 1, 1, '2023-01-04', '2023-01-04', '2023-01-04', 1),
(23, 1, 1, '2023-05-10', '2023-05-20', '2023-05-10', 1),
(24, 1, 1, '2023-05-10', '2023-05-20', '2023-05-10', 1),
(25, 1, 1, '2023-05-03', '2023-05-03', '2023-05-11', 1),
(26, 1, 1, '2023-05-03', '2023-05-03', '2023-05-11', 1),
(27, 1, 1, '2023-05-03', '2023-05-03', '2023-05-11', 1),
(28, 1, 1, '2023-05-03', '2023-05-03', NULL, 0),
(29, 1, 1, '2023-05-03', '2023-05-03', NULL, 0),
(30, 1, 1, '2023-05-03', '2023-05-03', NULL, 0),
(31, 1, 1, '2023-05-03', '2023-05-03', NULL, 0),
(32, 1, 1, '2023-05-03', '2023-05-03', NULL, 0),
(33, 1, 1, '2023-05-10', '2023-05-20', NULL, 0),
(34, 2, 1, '2022-05-04', '2023-05-21', NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `Ma` int(11) NOT NULL,
  `MaNhaCungCap` int(11) NOT NULL,
  `NgayNhap` date NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `MaNhanVien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`Ma`, `MaNhaCungCap`, `NgayNhap`, `TongTien`, `MaNhanVien`) VALUES
(0, 3, '2023-05-04', 0, 2),
(1, 1, '2023-04-02', NULL, 1),
(2, 2, '2023-04-11', 0, 3),
(3, 3, '2023-04-06', NULL, 2),
(4, 3, '2023-05-04', 0, 1),
(5, 1, '2023-05-10', 0, 1),
(6, 1, '2023-05-11', 0, 1),
(7, 1, '2023-05-11', 0, 1),
(8, 1, '2023-05-11', 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuphat`
--

CREATE TABLE `phieuphat` (
  `Ma` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `MaViPham` int(11) NOT NULL,
  `NgayViPham` date NOT NULL,
  `SoTienPhat` int(11) DEFAULT NULL,
  `MaPhieuMuon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuphat`
--

INSERT INTO `phieuphat` (`Ma`, `MaSach`, `MaViPham`, `NgayViPham`, `SoTienPhat`, `MaPhieuMuon`) VALUES
(0, 3, 1, '2023-05-05', 27000, 16),
(1, 2, 2, '2023-05-07', 12000, 15),
(2, 3, 1, '2023-05-04', 27000, 1),
(3, 3, 4, '2023-05-04', 1800, 1),
(4, 4, 1, '2023-05-05', 36000, 2),
(5, 4, 3, '2023-05-05', 12000, 2),
(6, 4, 4, '2023-05-04', 2400, 2),
(7, 8, 1, '2023-05-04', 72000, 2),
(8, 8, 3, '2023-05-04', 24000, 2),
(9, 8, 4, '2023-05-04', 4800, 2),
(10, 7, 1, '2023-05-04', 63000, 3),
(11, 7, 4, '2023-04-22', NULL, 3),
(12, 8, 1, '2023-05-04', 72000, 4),
(13, 8, 5, '2023-04-22', NULL, 4),
(14, 2, 1, '2023-05-05', 18000, 6),
(15, 4, 1, '2023-05-05', 36000, 6),
(16, 1, 1, '2023-05-05', 9000, 11),
(17, 2, 1, '2023-05-05', 18000, 11),
(18, 2, 3, '2023-05-05', 6000, 11),
(19, 3, 1, '2023-05-05', 27000, 11),
(20, 1, 2, '2023-05-05', 6000, 16),
(21, 3, 2, '2023-05-05', 18000, 16),
(22, 1, 1, '2023-05-10', 9000, 18),
(23, 3, 3, '2023-05-10', 9000, 17),
(24, 2, 2, '2023-05-07', 12000, 15),
(25, 1, 5, '2023-05-10', 3000, 17),
(26, 9, 1, '2023-05-10', 81000, 6),
(27, 8, 1, '2023-05-10', 72000, 4),
(28, 2, 1, '2023-05-10', 18000, 6),
(29, 9, 1, '2023-05-10', 81000, 6),
(30, 2, 1, '2023-05-10', 18000, 7),
(31, 3, 2, '2023-05-11', 160000, 25),
(100, 1, 4, '2023-05-04', 600, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `MaTacGia` int(11) NOT NULL,
  `MaTheLoai` int(11) NOT NULL,
  `MaNhaSanXuat` int(11) NOT NULL,
  `NamSanXuat` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Anh` varchar(255) NOT NULL,
  `Gia` int(11) NOT NULL,
  `TrangThai` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`Ma`, `Ten`, `MaTacGia`, `MaTheLoai`, `MaNhaSanXuat`, `NamSanXuat`, `SoLuong`, `Anh`, `Gia`, `TrangThai`) VALUES
(1, 'Doreamon 1', 1, 2, 2, 20230404, 200, 'doraemon 1.png', 120000, 1),
(2, 'Doreamon', 1, 2, 3, 20230320, 100, 'doraemon 2.jpg', 199000, 1),
(3, 'Conan 2', 4, 2, 3, 20230402, 120, 'conan.jpg', 160000, 1),
(4, 'Giải tích và đại số 11', 4, 1, 2, 20230305, 200, 'GiaiTich_DaiSo.png', 170000, 1),
(5, 'Tiếng việt 2', 4, 1, 1, 20221009, 19, 'sgk-tieng-viet.jpg', 180000, 1),
(6, 'Toán 7', 3, 1, 1, 20190402, 290, 'Toan-7.jpg', 1220000, 1),
(7, 'Sách tham khảo toán 5', 4, 3, 1, 20130403, 180, 'tham-khao-toan-5.jpg', 12000, 1),
(8, 'Những bài văn hay 6', 1, 3, 1, 20160405, 120, 'bai-van-hay-6.jpg', 10000, 1),
(9, 'Sách giải bài tập 3', 3, 3, 3, 20150408, 100, 'giai-bai-tap-3.jpg', 1320000, 1),
(10, 'Sách kỹ năng ăn nói', 4, 4, 3, 20140409, 111, 'ky-nang-an-noi.jpg', 128800, 1),
(11, 'Sách dạy cách ăn cơm', 1, 4, 2, 20111113, 120, 'day-cach-an-com.png', 111111, 1),
(12, 'Kỹ năng tin học', 5, 4, 1, 20170805, 144, 'ky-nang-tin-hoc.png', 17890, 1),
(13, 'Truyện kiều', 1, 5, 1, 20230420, 270, 'truyen-kieu.jpg', 128800, 1),
(14, 'Tắt đèn', 3, 5, 2, 20150407, 200, 'tat-den.jpg', 128800, 1),
(15, 'Tôi khổ quá', 2, 5, 3, 20230401, 199, 'toi-kho-qua.jpg', 12800, 1),
(16, 'Lười làm đồ án java', 1, 5, 2, 20230531, 111, 'luoilamjava.png', 12008800, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `GioiTinh` varchar(30) NOT NULL,
  `SoDienThoai` varchar(11) NOT NULL,
  `TrangThai` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`Ma`, `Ten`, `Ho`, `GioiTinh`, `SoDienThoai`, `TrangThai`) VALUES
(1, 'Gia 1', 'Tac', 'nam', '0985555000', 1),
(2, 'Gia 2', 'Tac', 'nu', '0985555001', 1),
(3, 'Gia 3', 'Tac', 'nam', '0985555055', 1),
(4, 'Gia 4', 'Tac', 'nam', '0985543688', 1),
(5, 'Gia 5', 'Tac', 'nu', '0808550844', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`tendangnhap`, `matkhau`) VALUES
('duc', '123456'),
('linh', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloaisach`
--

CREATE TABLE `theloaisach` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `theloaisach`
--

INSERT INTO `theloaisach` (`Ma`, `Ten`) VALUES
(1, 'Sách Giáo Khoa'),
(2, 'Sách Truyện Tranh'),
(3, 'Sách Tham Khảo'),
(4, 'Sách Kỹ Năng'),
(5, 'Sách Văn Học');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD PRIMARY KEY (`MaPhieuMuon`,`MaSach`) USING BTREE,
  ADD KEY `chitietphieumuon_ibfk_1` (`MaSach`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`,`MaSach`),
  ADD KEY `MaSach` (`MaSach`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Chỉ mục cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Chỉ mục cho bảng `noiquyphat`
--
ALTER TABLE `noiquyphat`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `NoiDung` (`NoiDung`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaDocGia` (`MaDocGia`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNhaCungCap` (`MaNhaCungCap`),
  ADD KEY `MaNhanVien` (`MaNhanVien`);

--
-- Chỉ mục cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `phieuphat_ibfk_1` (`MaViPham`),
  ADD KEY `phieuphat_ibfk_3` (`MaSach`),
  ADD KEY `MaPhieuMuon` (`MaPhieuMuon`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNhaSanXuat` (`MaNhaSanXuat`),
  ADD KEY `MaTacGia` (`MaTacGia`),
  ADD KEY `MaTheLoai` (`MaTheLoai`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `SoDienThoai` (`SoDienThoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD UNIQUE KEY `tendangnhap` (`tendangnhap`);

--
-- Chỉ mục cho bảng `theloaisach`
--
ALTER TABLE `theloaisach`
  ADD PRIMARY KEY (`Ma`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`Ma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`),
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`Ma`);

--
-- Các ràng buộc cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`),
  ADD CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`Ma`),
  ADD CONSTRAINT `phieumuon_ibfk_3` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`Ma`),
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`Ma`);

--
-- Các ràng buộc cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD CONSTRAINT `phieuphat_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`),
  ADD CONSTRAINT `phieuphat_ibfk_2` FOREIGN KEY (`MaViPham`) REFERENCES `noiquyphat` (`Ma`),
  ADD CONSTRAINT `phieuphat_ibfk_3` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`Ma`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaNhaSanXuat`) REFERENCES `nhaxuatban` (`Ma`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`Ma`),
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaTheLoai`) REFERENCES `theloaisach` (`Ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
