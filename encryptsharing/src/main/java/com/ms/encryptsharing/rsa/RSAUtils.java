package com.ms.encryptsharing.rsa;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * DSA工具类
 * 
 * @author Administrator
 *
 */
public class RSAUtils {
	/**
	 * 加密
	 * 
	 * @throws Exception
	 */
	public static String encrypt(String content) throws Exception {
		// 获取公钥及参数e,n
		FileInputStream f = new FileInputStream(RSACommons.PUBLIC_KEY_FILE);
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPublicKey pbk = (RSAPublicKey) b.readObject();
		BigInteger e = pbk.getPublicExponent();
		BigInteger n = pbk.getModulus();
		// 获取明文
		byte ptext[] = Base64.getEncoder().encode(content.getBytes("UTF-8"));
		BigInteger m = new BigInteger(ptext);
		// 计算密文c
		BigInteger c = m.modPow(e, n);
		// 保存密文
		String cs = c.toString();
		return cs;
	}

	/**
	 * 解密
	 * 
	 * @throws Exception
	 */
	public static String decrypt(String encryptContent) throws Exception {
		// 读取密文
		BigInteger c = new BigInteger(encryptContent);
		// 读取私钥
		FileInputStream f = new FileInputStream(RSACommons.PRIVATE_KEY_FILE);
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPrivateKey prk = (RSAPrivateKey) b.readObject();
		b.close();
		f.close();
		BigInteger d = prk.getPrivateExponent();
		// 获取私钥参数及解密
		BigInteger n = prk.getModulus();
		BigInteger m = c.modPow(d, n);
		// 显示解密结果
		byte[] mt = m.toByteArray();
		byte[] bs = Base64.getDecoder().decode(mt);
		return new String(bs, "UTF-8");
	}
}
