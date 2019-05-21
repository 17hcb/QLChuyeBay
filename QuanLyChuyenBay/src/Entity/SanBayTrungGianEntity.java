package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblsanbaytrunggian")
public class SanBayTrungGianEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2496599791921106715L;

	@Id
	@Column(name="MaChuyenBay")
	private String maChuyenBay;	

	@Column(name="MaSanBay")
	private int maSanBay;

	@Column(name="ThoiGianDung")
	private int thoiGianDung;

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public int getMaSanBay() {
		return maSanBay;
	}

	public void setMaSanBay(int maSanBay) {
		this.maSanBay = maSanBay;
	}

	public int getThoiGianDung() {
		return thoiGianDung;
	}

	public void setThoiGianDung(int thoiGianDung) {
		this.thoiGianDung = thoiGianDung;
	}

	public SanBayTrungGianEntity(String maChuyenBay, int maSanBay, int thoiGianDung) {
		super();
		this.maChuyenBay = maChuyenBay;
		this.maSanBay = maSanBay;
		this.thoiGianDung = thoiGianDung;
	}

	public SanBayTrungGianEntity() {
		super();
	}	  
	
	
}
