package com.ms.encryptsharing.rsa;

import java.util.Scanner;

/**
 * RSA加密算法
 * 
 * @author Administrator
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// //生成秘钥文件。只需生成一次。
		// RSAGenerator.generate();
		String content = null;
		while ((content = scanner.nextLine()) != null) {
			System.out.println("原文:" + content);
			String encryptContent = RSAUtils.encrypt(content);
			System.out.println("密文：" + encryptContent);
			System.out.println("原文：" + RSAUtils.decrypt(encryptContent));
			System.out.println("--------------");
		}
	}
}
