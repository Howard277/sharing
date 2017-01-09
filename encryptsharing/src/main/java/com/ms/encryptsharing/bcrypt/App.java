package com.ms.encryptsharing.bcrypt;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * BCrypt加密算法
 * 
 * @author Administrator
 *
 */
public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String content = null;
		while ((content = scanner.nextLine()) != null) {
			System.out.println("加密前：" + content);
			String encryptpw = BCrypt.hashpw(content, BCrypt.gensalt());
			System.out.println("加密后：" + encryptpw);
			System.out.println("审核结果：" + BCrypt.checkpw(content, encryptpw));
			System.out.println("-------------------------------------------");
		}
	}
}
