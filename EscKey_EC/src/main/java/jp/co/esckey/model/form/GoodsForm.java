package jp.co.esckey.model.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class GoodsForm implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private long id;
	
	private String goodsName;
	
	private long price;
	
	private MultipartFile  imgFile;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

}
