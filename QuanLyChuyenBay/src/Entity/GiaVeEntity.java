package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblgiave")
public class GiaVeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 683697712940111955L;

	@Id
	@Column(name="IdChuyenBay")
	private int idChuyenBay;	

	@Column(name="HangVe")
	private int hangVe;

	@Column(name="GiaTien")
	private int giaTien;	  

	public GiaVeEntity(int idChuyenBay, int hangVe, int giaTien) {
		super();
		this.idChuyenBay = idChuyenBay;
		this.hangVe = hangVe;
		this.giaTien = giaTien;
	}

	public GiaVeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdChuyenBay() {
		return idChuyenBay;
	}

	public void setIdChuyenBay(int idChuyenBay) {
		this.idChuyenBay = idChuyenBay;
	}

	public int getHangVe() {
		return hangVe;
	}

	public void setHangVe(int hangVe) {
		this.hangVe = hangVe;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
