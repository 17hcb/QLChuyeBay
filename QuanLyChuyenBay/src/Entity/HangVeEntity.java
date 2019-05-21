package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hangve")
public class HangVeEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3795538198910339251L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;	

	@Column(name="tenhangve")
	private String tenHangVe;

	public HangVeEntity(int id,String tenHangVe) {
		super();
		this.id = id;
		this.tenHangVe = tenHangVe;
	}

	public HangVeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdChuyenBay() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHangVe() {
		return tenHangVe;
	}

	public void setTenHangVe(String tenHangVe) {
		this.tenHangVe = tenHangVe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
