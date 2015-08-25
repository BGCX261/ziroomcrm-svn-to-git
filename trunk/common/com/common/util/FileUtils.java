package com.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.common.exception.GeneralException;

/**
 * 文件操作辅助类
 * 
 * @author 孙树林
 */
public class FileUtils {

	/**
	 * 生成文件
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyFile(String source, String target) throws Exception {
		File sourceFile = new File(source);
		copyFile(sourceFile, target);
	}
	
	/**
	 * 生成文件
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyFile(File sourceFile, String target) throws Exception {
		if (!sourceFile.exists()) {
			// 如果源文件不存在，操作失败。
			throw new GeneralException("源文件不存在，操作失败！");
		}
		File targetFile = new File(target);
		if(!targetFile.exists()) {
			targetFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(targetFile);
		FileInputStream fis = new FileInputStream(sourceFile);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * 删除文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteFile(String file) throws Exception {
		return deleteFile(new File(file));
	}
	
	/**
	 * 删除文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteFile(File file) throws Exception {
		if(file.exists()) {
			return file.delete();
		} else {
			return false;
		}
	}
}
