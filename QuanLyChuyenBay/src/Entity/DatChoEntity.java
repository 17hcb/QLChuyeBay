package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbldatcho")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DatChoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatChoEntity(int idDatCho, String maChuyenBay, int idKhachHang, int hangVe) {
		super();
		this.idDatCho = idDatCho;
		this.maChuyenBay = maChuyenBay;
		this.idKhachHang = idKhachHang;
		this.hangVe = hangVe;
	}	  
	
	
}
