package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblmaybay")
public class MayBayEntity implements Serializable {
	
	private static final long serialVersionUID = -5811063174131968138L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDMayBay")
	private int idMayBay;	

	@Column(name="MaMayBay")
	private String maMayBay;

	@Column(name="TenMayBay")
	private String tenMayBay;	  

	@Column(name="ThongTin")
	private String thongTin;

	public MayBayEntity(int idMayBay, String maMayBay, String tenMayBay, String thongTin) {
		super();
		this.idMayBay = idMayBay;
		this.maMayBay = maMayBay;
		this.tenMayBay = tenMayBay;
		this.thongTin = thongTin;
	}

	public MayBayEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMayBay() {
		return idMayBay;
	}

	public void setIdMayBay(int idMayBay) {
		this.idMayBay = idMayBay;
	}

	public String getMaMayBay() {
		return maMayBay;
	}

	public void setMaMayBay(String maMayBay) {
		this.maMayBay = maMayBay;
	}

	public String getTenMayBay() {
		return tenMayBay;
	}

	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
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
