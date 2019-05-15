package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblsanbay")
public class SanBayEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4925924028289169010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDSanBay")
	private int idSanBay;	

	@Column(name="MaSanBay")
	private String maSanBay;

	@Column(name="TenSanBay")
	private String tenSanBay;	  

	@Column(name="ThongTin")
	private String thongTin;

	public SanBayEntity(int idSanBay, String maSanBay, String tenSanBay, String thongTin) {
		super();
		this.idSanBay = idSanBay;
		this.maSanBay = maSanBay;
		this.tenSanBay = tenSanBay;
		this.thongTin = thongTin;
	}

	public SanBayEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSanBay() {
		return idSanBay;
	}

	public void setIdSanBay(int idSanBay) {
		this.idSanBay = idSanBay;
	}

	public String getMaSanBay() {
		return maSanBay;
	}

	public void setMaSanBay(String maSanBay) {
		this.maSanBay = maSanBay;
	}

	public String getTenSanBay() {
		return tenSanBay;
	}

	public void setTenSanBay(String tenSanBay) {
		this.tenSanBay = tenSanBay;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
