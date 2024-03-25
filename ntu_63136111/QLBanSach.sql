CREATE DATABASE QLBanSach;
USE QLBanSach;

CREATE TABLE SanPham(
	MaSP int primary key IDENTITY(1,1),
	TenSP nvarchar(50),
	TheLoai nvarchar(40),
	Gia int
)
GO
CREATE TABLE HoaDon(
	MaHD int primary key IDENTITY(1,1),
	TenKhachHang nvarchar(50),
	NgayMua varchar(30),
	Gia int
)
GO
CREATE TABLE TaiKhoan(
	TaiKhoan varchar(50),
	MatKhau varchar(50),
	PRIMARY KEY (TaiKhoan, MatKhau)
)
GO
INSERT INTO SanPham VALUES(N'Sherlock Holmes',N'Trinh thám',100)
INSERT INTO SanPham VALUES(N'Chuyện ma dân gian',N'Kinh dị',50)
INSERT INTO SanPham VALUES(N'Hướng dẫn sinh tồn trong rừng',N'Hành động',70)
GO
INSERT TaiKhoan VALUES ('Admin','admin123')
INSERT TaiKhoan VALUES ('User', 'user123')