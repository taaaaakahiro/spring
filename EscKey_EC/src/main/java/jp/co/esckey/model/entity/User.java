package jp.co.esckey.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	//@id → プライマリーキーであることを指定する
	//@column →　テーブルのどのカラムとマッピングするかを指定する
	//@GeneratedValue →　IDフィールドの振舞い方を指定する(今回はauto_incrementとして振る舞う)
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String  password;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="isAdmin")
	private long isAdmin;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public long getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(long isAdmin) {
		this.isAdmin = isAdmin;
	}

}
