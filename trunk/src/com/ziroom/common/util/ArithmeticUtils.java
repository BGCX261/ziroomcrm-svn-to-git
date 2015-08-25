package com.ziroom.common.util;

import java.security.NoSuchAlgorithmException;

/**
 * 加密/解密算法工具类
 * 
 * @author 孙树林
 */
public class ArithmeticUtils {

	/**
	 * md5加密算法
	 * 
	 * @param s
	 * @return
	 */
	public static String md5(String source) {
		String target = null;
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			target = new String(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return target;
	}
	
	public static void main(String[] args) {
		String source = "BJC1280006517002cd574c3cfcc5afb82d5f1f578278c5dws";
		System.out.print(ArithmeticUtils.md5(source));
	}
}