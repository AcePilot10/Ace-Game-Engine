package com.codygordon.game.assets;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class AssetLoader {

	private static AssetLoader instance;
	
	public static AssetLoader getInstance() {
		if(instance == null) {
			instance = new AssetLoader();
		}
		return instance;
	}
	
	public static BufferedImage getSprite(String fileName) {
		try {
			File file = new File("Assets/" + fileName);
			return ImageIO.read(file);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage getSprite(String fileName, int width, int height) {
		return resize(getSprite(fileName), width, height);
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    return dimg;
	}  
}