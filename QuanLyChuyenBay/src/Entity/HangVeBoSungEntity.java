package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblhangvebosung")
public class HangVeBoSungEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3107980199968382447L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdHangVeBoSung")
	private String idHangVeBoSung;	
	
	@Column(name="MaChuyenBay")
	private String maChuyenBay;	
	
	@Column(name="STTHangVe")
	private int sttHangVe;	

	@Column(name="SoLuongGhe")
	private int soLuongGhe;

	public HangVeBoSungEntity(String idHangVeBoSung, String maChuyenBay, int sttHangVe, int soLuongGhe) {
		super();
		this.idHangVeBoSung = idHangVeBoSung;
		this.maChuyenBay = maChuyenBay;
		this.sttHangVe = sttHangVe;
		this.soLuongGhe = soLuongGhe;
	}

	public HangVeBoSungEntity() {
		super();
	}

	public String getIdHangVeBoSung() {
		return idHangVeBoSung;
	}

	public void setIdHangVeBoSung(String idHangVeBoSung) {
		this.idHangVeBoSung = idHangVeBoSung;
	}

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	public int getSttHangVe() {
		return sttHangVe;
	}

	public void setSttHangVe(int sttHangVe) {
		this.sttHangVe = sttHangVe;
	}

	public int getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}
}
