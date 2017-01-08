package com.ms.encryptsharing.dsa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class DSAGenerator {

	/**
	 * 生成公钥文件和私钥文件
	 */
	public static void generate() {
		generate(DSACommons.DEFAULT_SEED, DSACommons.PUBLIC_KEY_FILE, DSACommons.PRIVATE_KEY_FILE);
	}

	/**
	 * 生成公钥文件和私钥文件
	 * 
	 * @param seed
	 *            种子
	 * @param publicKeyFile
	 *            公钥文件
	 * @param privateKeyFile
	 *            私钥文件
	 */
	public static void generate(String seed, String publicKeyFile, String privateKeyFile) {
		// 生成公钥和私钥
		KeyPairGenerator keygen;
		try {
			keygen = KeyPairGenerator.getInstance(DSACommons.KEY_ALGORITHM);
			// 初始化随机产生器
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.setSeed(seed.getBytes());
			keygen.initialize(1024, secureRandom);

			KeyPair keys = keygen.genKeyPair();

			PublicKey pubkey = keys.getPublic();
			PrivateKey prikey = keys.getPrivate();
			// 分别保存在myprikey.dat和mypubkey.dat中,以便下次不在生成
			java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(
					new java.io.FileOutputStream(privateKeyFile));
			out.writeObject(prikey);
			out.close();
			out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(publicKeyFile));
			out.writeObject(pubkey);
			out.close();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
