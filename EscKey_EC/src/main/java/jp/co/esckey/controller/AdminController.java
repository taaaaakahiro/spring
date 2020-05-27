package jp.co.esckey.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jp.co.esckey.model.dao.GoodsRepository;
import jp.co.esckey.model.dao.UserRepository;
import jp.co.esckey.model.entity.Goods;
import jp.co.esckey.model.entity.User;
import jp.co.esckey.model.form.GoodsForm;
import jp.co.esckey.model.form.LoginForm;

@Controller
@RequestMapping("/esckey/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private GoodsRepository goodsRepos;
	
	@RequestMapping("/")
	public String index() {
		return "adminindex";
		
	}
	
	@PostMapping("/welcome")
	public String welcome(LoginForm form,Model m) {
		//デバック
		//System.out.println(form.getUserName()+" "+form.getPassword());
		List<User> users = userRepos.findByUserNameAndPassword(form.getUserName(),form.getPassword());
		
		if(users != null && users.size() > 0) {
			boolean isAdmin = users.get(0).getIsAdmin() !=  0;
			System.out.println(users);
			if(isAdmin) {
				List<Goods> goods = goodsRepos.findAll();
				m.addAttribute("userName",users.get(0).getUserName());
				m.addAttribute("password",users.get(0).getPassword());
				m.addAttribute("goods",goods);
			}
		}
		
		return "welcome";
	}
	
	@PostMapping("/goodsMst")
	public String goodsMst(LoginForm form,Model m) {
		m.addAttribute("userName",form.getUserName());
		m.addAttribute("password",form.getPassword());		
		
		return "goodsmst";		
	}
	
	@RequestMapping("/addGoods")
	public String addGoods(@RequestParam("imgFile") MultipartFile multiaprtFile,GoodsForm goodsForm,LoginForm loginForm,Model m) {
		m.addAttribute("userName",loginForm.getUserName());
		m.addAttribute("password",loginForm.getPassword());
		
		Goods goods = new Goods();
		goods.setGoodsName(goodsForm.getGoodsName());
		goods.setPrice(goodsForm.getPrice());
		
		// 2020/5/25 -------------------------------------------------------------------------
		//goodsへアップロードファイル名を格納
		
		goods.setImgFile(goodsForm.getImgFile().getOriginalFilename());
		
		//データのsaveとDBへの反映
		goodsRepos.saveAndFlush(goods);
		
		
	// 2020/5/27--------------------------------------------------------------------------------
		
		//ディレクトリがない場合の画像ディレクトリの作成
//		Path path = (Path) Paths.get("Users/takahiro/Desktop/workspace/spring/EscKey_EC/src/main/resources/image");
//		if(!Files.exists(path)) {
//			try {
//				Files.createDirectory(path);
//			}catch(NoSuchFileException e){
//				System.err.println(e);
//				
//			}catch(IOException e) {
//				System.err.println(e);
//			}
//		}
		
//		
//		int dot = goodsForm.getImgFile().getOriginalFilename().lastIndexOf(".");
//		String extention = "";
//		if(dot > 0) {
//			extention =  goodsForm.getImgFile().getOriginalFilename().substring(dot).toLowerCase();
//		}
// 		
//		String filename = DateFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()); 
//		
//		Path uploadfile = Paths.get("/Users/takahiro/Desktop/workspace/spring/EscKey_EC/src/main/resources/image/" + filename + extention);
//		
//		try(OutputStream os = Files.newOutputStream(uploadfile,StandardOpenOption.CREATE)){
//			byte[] bytes = goodsForm.getImgFile().getBytes();
//			os.write(bytes);
//		}catch(IOException e) {
//			System.err.println(e);
//		}
//		
		
		
		
		
		return "forward:/esckey/admin/welcome";	
	}
	
	
	
	@ResponseBody
	@PostMapping("/api/deleteGoods")
	public String deleteApi(@RequestBody GoodsForm f,Model m){
		
		try{
			goodsRepos.deleteById(f.getId());
	}catch(IllegalArgumentException e) {
		return "-1";
	}
		return "1";
		
	}
	
	

}
