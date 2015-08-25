package com.ziroom.common.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.common.exception.GeneralException;
import com.common.util.ImageUtils;

/**
 * 自如图片处理类
 * 
 * @author 孙树林
 */
public class ZiroomImagesUtils {

	/**
	 * 自如:闺宿，经典，原创图片处理方法
	 * 
	 * @param srcPath
	 *            原图片地址
	 * @param destPath
	 *            目的图片地址
	 * @param pressPath
	 *            水印图片地址
	 * @param x
	 *            截取x坐标
	 * @param y
	 *            截取y坐标
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 * @param filePartten
	 *            文件后缀
	 */
	public static void handlerCMSProject(String srcPath, String destPath, String pressPath, int x, int y, int width,
			int height, String filePartten) throws GeneralException {
		BufferedImage targetImage = null;
		Graphics2D g = null;
		int sourceWidth = 0;
		int sourceHeight = 0;
		try {
			BufferedImage sourceImage = ImageIO.read(new URL(srcPath)); // 读取原图
			sourceWidth = sourceImage.getWidth(); // 源图宽度
			sourceHeight = sourceImage.getHeight(); // 源图高度
			if (sourceWidth >= width && sourceHeight >= height) {
				// 进行图片剪切
				Image image = sourceImage.getScaledInstance(sourceWidth, sourceHeight, Image.SCALE_SMOOTH);
				ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
				Image newImage = Toolkit.getDefaultToolkit().createImage(
						new FilteredImageSource(image.getSource(), cropFilter));
				targetImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				g = targetImage.createGraphics();
				// g = targetImage.createGraphics();
				g.drawImage(newImage, 0, 0, null); // 绘制剪切后的图
			}
			// 图片加水印
			BufferedImage pressImage = ImageIO.read(new File(pressPath)); // 读取水印图片
			int pressWidth = pressImage.getWidth(); // 水印图片宽度
			int pressHeight = pressImage.getHeight(); // 水印图片高度
			int start = targetImage.getWidth() - pressWidth;
			int end = targetImage.getHeight() - pressHeight;
			g.drawImage(pressImage, start, end, pressWidth, pressHeight, null); // 增加水印
			g.dispose();
			// 按长度，宽度缩小图像, 按292*219压缩图片
			targetImage = ImageUtils.scaleByWidthAndHeight(targetImage, 219, 292, false);
			ImageIO.write(targetImage, filePartten, new File(destPath));
		} catch (MalformedURLException e) {
			throw new GeneralException(e);
		} catch (IOException e) {
			throw new GeneralException(e);
		} finally {
			if (g != null) {
				g.dispose();
			}
		}
	}

	/**
	 * 自如:闺宿，经典，原创图片处理方法;按等比例缩放
	 * 
	 * @param srcPath
	 * @param destPath
	 * @param pressPath
	 * @param left
	 * @param top
	 * @param ratio
	 * @param filePartten
	 * @throws GeneralException
	 */
	public static void handlerCMSProject(String srcPath, String destPath, String pressPath, int left, int top,
			Float ratio, String filePartten) throws GeneralException {
		BufferedImage targetImage = null;
		Graphics2D g = null;
		int sourceWidth = 0;
		int sourceHeight = 0;
		int calculationWidth = 0;
		int calculationHeight = 0;
		try {
			BufferedImage sourceImage = ImageIO.read(new URL(srcPath)); // 读取原图
			sourceWidth = sourceImage.getWidth(); // 源图宽度
			sourceHeight = sourceImage.getHeight(); // 源图高度
			// 计算缩放后图像高度，宽度
			calculationWidth = (int) (290 / ratio.floatValue());
			calculationHeight = (int) (220 / ratio.floatValue());
			// 对图像进行剪切
			targetImage = new BufferedImage(calculationWidth, calculationHeight, BufferedImage.TYPE_INT_RGB);
			ImageFilter cropFilter = new CropImageFilter((int)(left/ratio), (int)(top/ratio), (int)(290/ratio), (int)(220/ratio));
			Image newImage = Toolkit.getDefaultToolkit().createImage(
					new FilteredImageSource(sourceImage.getSource(), cropFilter));
			g = targetImage.createGraphics();
			g.drawImage(newImage, 0, 0, null); // 绘制
			g.dispose();
			//ImageIO.write(targetImage, filePartten, new File("d:\\jieqie.jpg"));
			// 图片加水印
			BufferedImage pressImage = ImageIO.read(new File(pressPath)); // 读取水印图片
			int pressWidth = pressImage.getWidth(); // 水印图片宽度
			int pressHeight = pressImage.getHeight(); // 水印图片高度
			int start = targetImage.getWidth() - pressWidth;
			int end = targetImage.getHeight() - pressHeight;
			g = targetImage.createGraphics();
			g.drawImage(pressImage, start, end, pressWidth, pressHeight, null); // 增加水印
			g.dispose();
			//ImageIO.write(targetImage, filePartten, new File("d:\\suiyin.jpg"));
			
			// 创建缩放后大小的缓冲
			//targetImage = ImageUtils.scaleByWidthAndHeight(sourceImage, calculationHeight, calculationWidth, false);
			ImageIO.write(targetImage, filePartten, new File(destPath));
		} catch (MalformedURLException e) {
			throw new GeneralException(e);
		} catch (IOException e) {
			throw new GeneralException(e);
		} finally {
			if (g != null) {
				g.dispose();
			}
		}
	}
}
