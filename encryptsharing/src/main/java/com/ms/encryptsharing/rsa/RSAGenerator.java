package com.ms.encryptsharing.rsa;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAGenerator {

	/**
	 * 生成公钥文件和私钥文件
	 */
	public static void generate() {
		generate(RSACommons.KEY_ALGORITHM, RSACommons.PUBLIC_KEY_FILE, RSACommons.PRIVATE_KEY_FILE);
	}

	public static void generate(String key, String publicKeyFile, String privateKeyFile) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance(key);
			kpg.initialize(1024);
			KeyPair kp = kpg.genKeyPair();
			PublicKey pbkey = kp.getPublic();
			PrivateKey prkey = kp.getPrivate();
			// 保存公钥
			FileOutputStream f1 = new FileOutputStream(publicKeyFile);
			ObjectOutputStream b1 = new ObjectOutputStream(f1);
			b1.writeObject(pbkey);
			b1.close();
			f1.close();
			// 保存私钥
			FileOutputStream f2 = new FileOutputStream(privateKeyFile);
			ObjectOutputStream b2 = new ObjectOutputStream(f2);
			b2.writeObject(prkey);
			b2.close();
			f2.close();
		} catch (Exception e) {
		}
	}
}
