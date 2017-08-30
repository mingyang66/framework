
package framework.yaomy.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import framework.yaomy.log.GGLogger;

/**
 * @Description:图片处理工具类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月21日 下午1:29:31
 */
public class ImageUtil {

	/**
	 * 
	 * @Description:获取图片的原始宽度
	 * @author yaomy
	 * @date 2017年8月21日 下午1:35:30
	 */
	public static Integer getImageWidth(File image){
		int width = 0;
		try {
			BufferedImage img = ImageIO.read(image);
			width = img.getWidth();
		} catch (IOException e) {
			GGLogger.error(e);
		}
		return width;
	}
	/**
	 * 
	 * @Description:获取图片的原始高度
	 * @author yaomy
	 * @date 2017年8月21日 下午1:42:30
	 */
	public static Integer getImageHeight(File image){
		Integer height = 0;
		try {
			BufferedImage img = ImageIO.read(image);
			height = img.getHeight();
		} catch (IOException e) {
			GGLogger.error(e);
		}
		return height;
	}
}
