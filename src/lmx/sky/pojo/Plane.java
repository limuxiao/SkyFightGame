package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.Icon;

/**
 * @classname  Plane		--		飞行器
 * @desc
 * @createtime 2017年9月21日 上午10:22:52      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Plane extends Elf implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5225308653335053068L;
	
	public int HP;	//血量
	
	
	
	public Plane() {
		this.canMove = true;	//可以移动
	}
	
	

}