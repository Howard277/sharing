package com.ms.encryptsharing.dsa;

import java.util.Scanner;

/**
 * DSA 数字签名算法
 * 
 * @author Administrator
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// //生成秘钥文件。只需生成一次。
		// DSAGenerator.generate();
		String content = null;
		while ((content = scanner.nextLine()) != null) {
			System.out.println("原文:" + content);
			byte[] sign = DSAUtils.sign(content.getBytes());
			System.out.println("数字签名：" + sign);
			System.out.println("验证签名：" + DSAUtils.verify(content.getBytes(), sign));
			System.out.println("--------------");
		}
	}
}
