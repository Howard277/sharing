package com.ms.encryptsharing.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

/**
 * SHA 信息摘要算法
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
			System.out.println("摘要:" + printSHA(content));
			System.out.println("---------------------");
		}
	}

	private static String printSHA(String txt) throws NoSuchAlgorithmException {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		sha1.update(txt.getBytes());
		byte[] bs = sha1.digest();
		return new String(Base64.getEncoder().encode(bs));

	}
}
