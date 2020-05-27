package jp.co.esckey.model.form;

import java.io.Serializable;

public class LoginForm implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;
	
	
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

}

//adminindex.htmlの入力フォームから入力した値をjavaに渡す
/*Serializable → Java言語では直列化したいクラスに Serializable または Externalizable インタフェースを実装することで、
そのクラスのオブジェクトは直列化できるクラスを作ることができる。*/