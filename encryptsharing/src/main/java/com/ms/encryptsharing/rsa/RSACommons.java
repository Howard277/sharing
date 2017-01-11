package com.ms.encryptsharing.rsa;

public class RSACommons {

	public static final String KEY_ALGORITHM = "RSA";
	/**
	 * 默认种子
	 */
	public static final String DEFAULT_SEED = "0f22507a10bbddd07d8a3082122966e3";
	/**
	 * 公钥文件路径
	 */
	public static final String PUBLIC_KEY_FILE = System.getProperty("user.dir") + "\\src\\main\\resource\\pubkey.dat";
	/**
	 * 私钥文件路径
	 */
	public static final String PRIVATE_KEY_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\resource\\privatekey.dat";
}
