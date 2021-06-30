CREATE SCHEMA `javais216`;
use javais216;

create table ThongTinChiTieu (
maChiTieu varchar(8) not null,
tenDangNhap varchar(20) not null,
luongTien double not null,
ngayChi date not null,
thoiGianChi date not null,
primary key (maChiTieu)
);

create table ChiTiet (
maChiTiet varchar(6) not null,
maChiTieu varchar(6) not null,
maHangHoa varchar(6) not null,
soLuong int not null,
primary key (maChiTiet)
);

create table NguoiDung (
tenDangNhap varchar(20) not null,
matKhau varchar(20) not null,
primary key (tenDangNhap)
);

create table GioiHanChiTieu (
maGioiHan varchar(6) not null,
tenDangNhap varchar(20) not null,
gioiHan int not null,
tongChiTieuThang double not null,
primary key (maGioiHan)
);

create table HangHoa (
maHangHoa varchar(6) not null,
tenHangHoa varchar(40) not null,
donGia double not null,
primary key (maHangHoa)
);

ALTER TABLE thongTinChiTieu
ADD CONSTRAINT FK_ThongTinChiTieu_NguoiDung FOREIGN KEY (tenDangNhap) REFERENCES NguoiDung(tenDangNhap);

ALTER TABLE chiTiet
ADD CONSTRAINT FK1_ChiTiet_ThongTinChiTieu FOREIGN KEY (maChiTieu) REFERENCES ThongTinChiTieu(maChiTieu);
ALTER TABLE chiTiet
ADD CONSTRAINT FK2_ChiTiet_HangHoa FOREIGN KEY (maHangHoa) REFERENCES HangHoa(maHangHoa);

ALTER TABLE gioiHanChiTieu
ADD CONSTRAINT FK_GioiHanChiTieu_NguoiDung FOREIGN KEY (tenDangNhap) REFERENCES NguoiDung(tenDangNhap);

insert into thongTinChiTieu (maChiTieu,tenDangNhap,luongTien,ngayChi,thoiGianChi) values (TTCT0001, "khoa", 100000, "2021-06-27", "09:05:30");
insert into thongTinChiTieu (maChiTieu,tenDangNhap,luongTien,ngayChi,thoiGianChi) values (TTCT0002, "khoa", 300000, "2021-03-28", "10:45:30");
insert into thongTinChiTieu (maChiTieu,tenDangNhap,luongTien,ngayChi,thoiGianChi) values (TTCT0003, "bao", 200000, "2021-05-27", "13:20:30");
insert into thongTinChiTieu (maChiTieu,tenDangNhap,luongTien,ngayChi,thoiGianChi) values (TTCT0003, "bao", 500000, "2021-04-10", "13:20:30");

insert into chiTiet (maChiTiet,maChiTieu,maHangHoa,soLuong) values (CT0001, TTCT001, HH0001, 3);
insert into chiTiet (maChiTiet,maChiTieu,maHangHoa,soLuong) values (CT0002, TTCT001, HH0002, 2);
insert into chiTiet (maChiTiet,maChiTieu,maHangHoa,soLuong) values (CT0003, TTCT001, HH0003, 5);
insert into chiTiet (maChiTiet,maChiTieu,maHangHoa,soLuong) values (CT0003, TTCT002, HH0004, 3);
insert into chiTiet (maChiTiet,maChiTieu,maHangHoa,soLuong) values (CT0003, TTCT002, HH0005, 1);

insert into nguoiDung (tenDangNhap, matKhau) values ("khoa", "khoa");
insert into nguoiDung (tenDangNhap, matKhau) values ("bao", "bao");

insert into gioiHanChiTieu (maGioiHan, tenDangNhap, gioiHan, tongChiTieuThang) values (GH0001, "khoa", 5000000, 4900000);
insert into gioiHanChiTieu (maGioiHan, tenDangNhap, gioiHan, tongChiTieuThang) values (GH0002, "khoa", 3000000, 2000000);
