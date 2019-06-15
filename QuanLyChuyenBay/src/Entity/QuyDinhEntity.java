package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblquydinh")
public class QuyDinhEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2871676782003472840L;

	@Id
	@Column(name="Masterkey")
	private int masterkey;	

	@Column(name="TgBayToiThieu")
	private int tgBayToiThieu;

	@Column(name="SanBayTrungGianToiDa")
	private int sanBayTrungGianToiDa;	  

	@Column(name="ThoiGianDungToiThieu")
	private int thoiGianDungToiThieu;	  

	@Column(name="ThoiGianDungToiDa")
	private int thoiGianDungToiDa;	  

	@Column(name="ThoiGianChamNhatDatVe")
	private int thoiGianChamNhatDatVe;
	
	@Column(name="ThoiGianChamNhatHuyDatVe")
	private int thoiGianChamNhatHuyDatVe;

	public QuyDinhEntity(int masterkey, int tgBayToiThieu, int sanBayTrungGianToiDa, int thoiGianDungToiThieu,
			int thoiGianDungToiDa, int thoiGianChamNhatDatVe, int thoiGianChamNhatHuyDatVe) {
		super();
		this.masterkey = masterkey;
		this.tgBayToiThieu = tgBayToiThieu;
		this.sanBayTrungGianToiDa = sanBayTrungGianToiDa;
		this.thoiGianDungToiThieu = thoiGianDungToiThieu;
		this.thoiGianDungToiDa = thoiGianDungToiDa;
		this.thoiGianChamNhatDatVe = thoiGianChamNhatDatVe;
		this.thoiGianChamNhatHuyDatVe = thoiGianChamNhatHuyDatVe;
	}

	public QuyDinhEntity() {
		super();
	}

	public int getMasterkey() {
		return masterkey;
	}

	public void setMasterkey(int masterkey) {
		this.masterkey = masterkey;
	}

	public int getTgBayToiThieu() {
		return tgBayToiThieu;
	}

	public void setTgBayToiThieu(int tgBayToiThieu) {
		this.tgBayToiThieu = tgBayToiThieu;
	}

	public int getSanBayTrungGianToiDa() {
		return sanBayTrungGianToiDa;
	}

	public void setSanBayTrungGianToiDa(int sanBayTrungGianToiDa) {
		this.sanBayTrungGianToiDa = sanBayTrungGianToiDa;
	}

	public int getThoiGianDungToiThieu() {
		return thoiGianDungToiThieu;
	}

	public void setThoiGianDungToiThieu(int thoiGianDungToiThieu) {
		this.thoiGianDungToiThieu = thoiGianDungToiThieu;
	}

	public int getThoiGianDungToiDa() {
		return thoiGianDungToiDa;
	}

	public void setThoiGianDungToiDa(int thoiGianDungToiDa) {
		this.thoiGianDungToiDa = thoiGianDungToiDa;
	}

	public int getThoiGianChamNhatDatVe() {
		return thoiGianChamNhatDatVe;
	}

	public void setThoiGianChamNhatDatVe(int thoiGianChamNhatDatVe) {
		this.thoiGianChamNhatDatVe = thoiGianChamNhatDatVe;
	}

	public int getThoiGianChamNhatHuyDatVe() {
		return thoiGianChamNhatHuyDatVe;
	}

	public void setThoiGianChamNhatHuyDatVe(int thoiGianChamNhatHuyDatVe) {
		this.thoiGianChamNhatHuyDatVe = thoiGianChamNhatHuyDatVe;
	}	  

}
