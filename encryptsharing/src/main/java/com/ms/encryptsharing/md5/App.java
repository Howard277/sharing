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
		while (true) {
			System.out.println("input:");
			String str = scanner.nextLine();
			System.out.println("output:");
			printMD5(str);
			System.out.println("---------------------");
			String next = scanner.nextLine();
		}
	}

	private static void printMD5(String txt) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(txt.getBytes());
		byte[] bs = md5.digest();
		System.out.println(new String(Base64.getEncoder().encode(bs)));

	}
}
