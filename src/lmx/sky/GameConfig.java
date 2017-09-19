package lmx.sky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.security.auth.login.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * @classname  GameConfig
 * @desc
 * @createtime 2017年9月14日 下午4:24:29      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1138747993761454166L;
	
	
	
	public BaseConfig base;
	public PathConfig path;
	
	
	private static GameConfig config;
	
	
	private GameConfig() {
		
	}
	
	
	public static GameConfig getInstance() {
		if (config== null) {
			loadConfig();
		}
		return config;
	}
	
	
	/**
	 * 加载config
	 */
	public static void loadConfig() {
		try {
			String pathname = "./props/config.json";
			FileInputStream fis = new FileInputStream(new File(pathname));
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			BufferedReader reader = new BufferedReader(isr);
			String str = null;
			StringBuilder sb = new StringBuilder();
			while ((str = reader.readLine()) != null) {
				sb.append(str);
				
			}
			Gson gson = new GsonBuilder().create();
			config = gson.fromJson(sb.toString(), GameConfig.class);
			System.out.println("加载静态资源成功...");
			
		} catch (Exception e) {

		}
	}
	
	
	/**
	 * 生成config
	 */
	public static void createConfig() {
		GameConfig config = new GameConfig();
		config.base = new GameConfig.BaseConfig();
		config.base.title = "SkyFight";
		
		try {
			String pathname = "./props/config.json";
			File file = new File(pathname);
			PrintWriter pw = new PrintWriter(file);
			Gson gson = new GsonBuilder().create();
			String str = gson.toJson(config);
			pw.write(str);
			pw.flush();
			pw.close();
			
		} catch (Exception e) {

		}
	}
	
	/**
	 * @classname  BaseConfig	基础配置
	 * @desc	
	 * @createtime 2017年9月14日 下午4:24:20      
	 * @author liyan
	 *
	 * @version V1.0.1
	 */
	public static class BaseConfig implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 8777816134965360710L;
		
		
		
		/**
		 * title
		 */
		public String title;
		
		/**
		 * width
		 */
		public int width;
		
		
		/**
		 * height
		 */
		public int height;
		
	}
	

	/**
	 * @classname  PathConfig	路径配置
	 * @desc
	 * @createtime 2017年9月14日 下午5:37:35      
	 * @author liyan
	 *
	 * @version V1.0.1
	 */
	public static class PathConfig implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -4300140164174530550L;
		
		public String imgBackground;	//背景图	
		
	}
	
}
