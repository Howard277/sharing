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
		while (true) {
			System.out.println("input:");
			String data = scanner.nextLine();
			byte[] sign = DSAUtils.sign(data.getBytes());
			System.out.println("数字签名：" + sign);
			System.out.println("验证签名：" + DSAUtils.verify(data.getBytes(), sign));
			System.out.println("--------------");
			String str = scanner.nextLine();
		}
	}
}
