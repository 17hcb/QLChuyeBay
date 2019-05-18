package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanbay")
public class SanBayEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4925924028289169010L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	

	@Column(name="tensanbay")
	private String tensanbay;

	@Column(name="tendiemden")
	private String tendiemden;	  

	@Column(name="ghichu")
	private String ghichu;

	public SanBayEntity(int id, String tensanbay, String tendiemden, String ghichu) {
		super();
		this.id = id;
		this.tensanbay = tensanbay;
		this.tendiemden = tendiemden;
		this.ghichu = ghichu;
	}

	public SanBayEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanBay() {
		return tensanbay;
	}

	public void setTenSanBay(String tensanbay) {
		this.tensanbay = tensanbay;
	}

	public String getTenDiemDen() {
		return tendiemden;
	}

	public void setTenDiemDen(String tendiemden) {
		this.tendiemden = tendiemden;
	}

	public String getGhiChu() {
		return ghichu;
	}

	public void setGhiChu(String ghichu) {
		this.ghichu = ghichu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
