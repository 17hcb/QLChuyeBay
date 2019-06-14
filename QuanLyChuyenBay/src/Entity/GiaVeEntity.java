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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdGiaVe")
	private int idGiaVe;	
	
	@Column(name="IdChuyenBay")
	private String idChuyenBay;	

	@Column(name="HangVe")
	private int hangVe;

	@Column(name="GiaTien")
	private int giaTien;	  


	public GiaVeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GiaVeEntity(int idGiaVe, String idChuyenBay, int hangVe, int giaTien) {
		super();
		this.idGiaVe = idGiaVe;
		this.idChuyenBay = idChuyenBay;
		this.hangVe = hangVe;
		this.giaTien = giaTien;
	}


	public int getIdGiaVe() {
		return idGiaVe;
	}


	public void setIdGiaVe(int idGiaVe) {
		this.idGiaVe = idGiaVe;
	}


	public String getIdChuyenBay() {
		return idChuyenBay;
	}


	public void setIdChuyenBay(String idChuyenBay) {
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

}
