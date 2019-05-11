package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblkhachhang")
public class KhachHangEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5811063174131968138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDKhachHang")
	private int idKhachHang;	

	@Column(name="CMND")
	private String cmnd;

	@Column(name="TenKhachHang")
	private String tenKhachHang;	  

	@Column(name="SoDienThoai")
	private String soDienThoai;

	
	public KhachHangEntity(int idKhachHang, String cmnd, String tenKhachHang, String soDienThoai) {
		super();
		this.idKhachHang = idKhachHang;
		this.cmnd = cmnd;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
	}

	public KhachHangEntity() {
		super();
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	

}
