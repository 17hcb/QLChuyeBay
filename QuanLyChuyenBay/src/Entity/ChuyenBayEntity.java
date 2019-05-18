package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblchuyenbay")
public class ChuyenBayEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6128488731574364904L;

	@Id
	@Column(name="MaChuyenBay")
	private String maChuyenBay;	

	@Column(name="MaSanBayDi")
	private int maSanBayDi;

	@Column(name="MaSanBayDen")
	private int maSanBayDen;	  

	@Column(name="GioCatCanh")
	private int gioCatCanh;	  

	@Column(name="PhutCatCanh")
	private int phutCatCanh;	  

	@Column(name="NgayBay")
	private String ngayBay;
	
	@Column(name="GioBay")
	private int gioBay;	  

	@Column(name="PhutBay")
	private int phutBay;	  

	@Column(name="SoLuongGheHang1")
	private int soLuongGheHang1;	  

	@Column(name="SoLuongGheHang2")
	private int soLuongGheHang2;	  
	
	@Column(name="CoHangVeBoSung")
	private int coHangVeBoSung;

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public int getMaSanBayDi() {
		return maSanBayDi;
	}

	public void setMaSanBayDi(int maSanBayDi) {
		this.maSanBayDi = maSanBayDi;
	}

	public int getMaSanBayDen() {
		return maSanBayDen;
	}

	public void setMaSanBayDen(int maSanBayDen) {
		this.maSanBayDen = maSanBayDen;
	}

	public int getGioCatCanh() {
		return gioCatCanh;
	}

	public void setGioCatCanh(int gioCatCanh) {
		this.gioCatCanh = gioCatCanh;
	}

	public int getPhutCatCanh() {
		return phutCatCanh;
	}

	public void setPhutCatCanh(int phutCatCanh) {
		this.phutCatCanh = phutCatCanh;
	}

	public String getNgayBay() {
		return ngayBay;
	}

	public void setNgayBay(String ngayBay) {
		this.ngayBay = ngayBay;
	}

	public int getGioBay() {
		return gioBay;
	}

	public void setGioBay(int gioBay) {
		this.gioBay = gioBay;
	}

	public int getPhutBay() {
		return phutBay;
	}

	public void setPhutBay(int phutBay) {
		this.phutBay = phutBay;
	}

	public int getSoLuongGheHang1() {
		return soLuongGheHang1;
	}

	public void setSoLuongGheHang1(int soLuongGheHang1) {
		this.soLuongGheHang1 = soLuongGheHang1;
	}

	public int getSoLuongGheHang2() {
		return soLuongGheHang2;
	}

	public void setSoLuongGheHang2(int soLuongGheHang2) {
		this.soLuongGheHang2 = soLuongGheHang2;
	}

	public int getCoHangVeBoSung() {
		return coHangVeBoSung;
	}

	public void setCoHangVeBoSung(int coHangVeBoSung) {
		this.coHangVeBoSung = coHangVeBoSung;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ChuyenBayEntity() {
		super();
	}

	public ChuyenBayEntity(String maChuyenBay, int maSanBayDi, int maSanBayDen, int gioCatCanh, int phutCatCanh,
			String ngayBay, int gioBay, int phutBay, int soLuongGheHang1, int soLuongGheHang2, int coHangVeBoSung) {
		this.maChuyenBay = maChuyenBay;
		this.maSanBayDi = maSanBayDi;
		this.maSanBayDen = maSanBayDen;
		this.gioCatCanh = gioCatCanh;
		this.phutCatCanh = phutCatCanh;
		this.ngayBay = ngayBay;
		this.gioBay = gioBay;
		this.phutBay = phutBay;
		this.soLuongGheHang1 = soLuongGheHang1;
		this.soLuongGheHang2 = soLuongGheHang2;
		this.coHangVeBoSung = coHangVeBoSung;
	}	
	
}
