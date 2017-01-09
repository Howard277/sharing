package com.ms.encryptsharing.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

/**
 * MD5 信息摘要算法
 * 
 * @author Administrator
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String content = null;
		while ((content = scanner.nextLine()) != null) {
			System.out.println("原文:" + content);
			System.out.println("摘要:" + printMD5(content));
			System.out.println("---------------------");
		}
	}

	private static String printMD5(String txt) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(txt.getBytes());
		byte[] bs = md5.digest();
		return new String(Base64.getEncoder().encode(bs));
	}
}
