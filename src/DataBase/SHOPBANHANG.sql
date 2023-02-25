create database SHOPBANHANG
use SHOPBANHANG



CREATE TABLE CHITIETHOADON (
  SoHD int(10) NOT NULL,
  MaHH int(11) NOT NULL,
  TenHH varchar(50) NOT NULL,
  GiaBan int(11) NOT NULL,
  SoLuong int(11) NOT NULL,
  Tong int(11) NOT NULL
)

--
-- Đang đổ dữ liệu cho bảng CHITIETHOADON
--

INSERT INTO CHITIETHOADON (SoHD, MaHH, TenHH, GiaBan, SoLuong, Tong) VALUES
(1, 1, 'Áo Thun Cá Sấu', 1000000, 2, 2000000),
(3, 3, 'Quần bò xanh', 200000, 2, 400000),
(6, 6, 'Áo Thun Cá Voi', 1000000, 7, 7000000),
(7, 7, 'Áo Thun Cá Voi', 1000000, 4, 3000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng HOADON
--

CREATE TABLE HOADON (
  SoHD int(11) NOT NULL,
  NgayLap date NOT NULL,
  MaNV varchar(10) NOT NULL,
  TenKH varchar(50) NOT NULL,
  Tong int(11) NOT NULL
) 

--
-- Đang đổ dữ liệu cho bảng HOADON
--

INSERT INTO HOADON (SoHD, NgayLap, MaNV, TenKH, Tong) VALUES
(1, '2021-10-04', 'NV01', 'Nguyễn Thành Đông', 10000000),
(2, '2021-02-03', 'NV02', 'Nguyễn Thành Danh', 200000000),
(3, '2018-02-03', 'NV03', 'Nguyễn Thành Thiên', 4000000),
(4, '2017-02-03', 'NV04', 'Nguyễn Hoàng Thiên', 5000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng KHACHHANG
--

CREATE TABLE KHACHHANG (
  MaKH varchar(10) NOT NULL,
  TenKH varchar(50) NOT NULL,
  GioiTinh varchar(10) NOT NULL,
  DiaChi varchar(50) NOT NULL,
  SDT varchar(12) NOT NULL
)

--
-- Đang đổ dữ liệu cho bảng KHACHHANG
--

INSERT INTO KHACHHANG (MaKH, TenKH, GioiTinh, DiaChi, SDT) VALUES
('KH01', 'Nguyễn Thành Nam', 'Nam', '170/90 Hoàng Văn Thụ, P7, Quận Phú Nhuận', '09127893234'),
('KH02', 'Nguyễn Thành Danh', 'Nam', '190/90 Hoàng Văn Thụ, P7, Quận Tân Phú', '09123456754'),
('KH03', 'Nguyễn Trọng Tường', 'Khác', '89/93/22 Mai Chí Thọ', '0123456785');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng LOGIN
--

CREATE TABLE LOGIN (
  TenTaiKhoan varchar(50) NOT NULL,
  MatKhau varchar(50) NOT NULL
)

--
-- Đang đổ dữ liệu cho bảng LOGIN
--

INSERT INTO LOGIN (TenTaiKhoan, MatKhau) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng QUANLYQUANAO
--

CREATE TABLE QUANLYQUANAO (
  MaHH int(10) NOT NULL,
  TenHH varchar(50) NOT NULL,
  GiaBan int(11) NOT NULL,
  DVT varchar(20) NOT NULL,
  MaNCC varchar(10) NOT NULL
)

--
-- Đang đổ dữ liệu cho bảng QUANLYQUANAO
--

INSERT INTO QUANLYQUANAO (MaHH, TenHH, GiaBan, DVT, MaNCC) VALUES
(1, 'Áo Thun Cá Sấu', 1000000, 'VND', 'NCC01'),
(2, 'Áo Thun Con Thỏ', 200, 'USD', 'NCC02'),
(3, 'Quần bò xanh lá đậm', 100, 'USD', 'NCC03'),
(4, 'Quần bò xanh dương', 1000, 'USD', 'NCC04'),
(5, 'Áo thun Hello Kitty', 10000, 'USD', 'NCC05'),
(6, 'Áo ba lỗ', 30000, 'VND', 'NCC06'),
(7, 'Quần Jean đen', 250000, 'VND', 'NCC07'),
(8, 'Quần Jean Xanh', 350000, 'VND', 'NCC08');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng CHITIETHOADON
--
ALTER TABLE CHITIETHOADON
  ADD PRIMARY KEY (SoHD);

--
-- Chỉ mục cho bảng HOADON
--
ALTER TABLE HOADON
  ADD PRIMARY KEY (SoHD);

--
-- Chỉ mục cho bảng KHACHHANG
--
ALTER TABLE KHACHHANG
  ADD PRIMARY KEY (MaKH);

--
-- Chỉ mục cho bảng LOGIN
--
ALTER TABLE LOGIN
  ADD PRIMARY KEY (TenTaiKhoan);

--
-- Chỉ mục cho bảng QUANLYQUANAO
--
ALTER TABLE QUANLYQUANAO
  ADD PRIMARY KEY (MaHH);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng CHITIETHOADON
--
ALTER TABLE CHITIETHOADON
  ADD PRIMARY KEY (SoHD);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
