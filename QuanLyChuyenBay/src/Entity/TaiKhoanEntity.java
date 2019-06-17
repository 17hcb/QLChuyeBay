package Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbltaikhoan")
public class TaiKhoanEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7538688226100128442L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTaiKhoan")
	private int idTaiKhoan;	

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;	  

	@Column(name="type")
	private int type;

	public TaiKhoanEntity(int idTaiKhoan, String username, String password, int type) {
		super();
		this.idTaiKhoan = idTaiKhoan;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public TaiKhoanEntity(String username, String password, int type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public TaiKhoanEntity() {
		super();
	}

	public int getIdTaiKhoan() {
		return idTaiKhoan;
	}

	public void setIdTaiKhoan(int idTaiKhoan) {
		this.idTaiKhoan = idTaiKhoan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}	  
}
