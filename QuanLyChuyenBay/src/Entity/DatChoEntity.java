package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblvedatcho")
public class DatChoEntity implements Serializable{
	private static final long serialVersionUID = -6128488731574364904L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDDatCho")
	private int idDatCho;
	
	@Column(name="MaChuyenBay")
	private String maChuyenBay;	

	@Column(name="IDKhachHang")
	private int idKhachHang;

	@Column(name="HangVe")
	private int hangVe;

	@Column(name="GiaVe")
	private int giaVe;

	@Column(name="SoLuong")
	private int soLuong;

	@Column(name="GhiChu")
	private String ghiChu;
	
	@Column(name="TinhTrang")
	private String tinhTrang;

	public DatChoEntity(int idDatCho, String maChuyenBay, int idKhachHang, int hangVe, int giaVe, int soLuong,
			String ghiChu, String tinhTrang) {
		super();
		this.idDatCho = idDatCho;
		this.maChuyenBay = maChuyenBay;
		this.idKhachHang = idKhachHang;
		this.hangVe = hangVe;
		this.giaVe = giaVe;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.tinhTrang = tinhTrang;
	}

	public DatChoEntity() {
		super();
	}

	public int getIdDatCho() {
		return idDatCho;
	}

	public void setIdDatCho(int idDatCho) {
		this.idDatCho = idDatCho;
	}

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getHangVe() {
		return hangVe;
	}

	public void setHangVe(int hangVe) {
		this.hangVe = hangVe;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
