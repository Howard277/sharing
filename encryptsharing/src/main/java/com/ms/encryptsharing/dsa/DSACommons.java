package com.ms.encryptsharing.dsa;

public class DSACommons {

	public static final String KEY_ALGORITHM = "DSA";
	/**
	 * 默认种子
	 */
	public static final String DEFAULT_SEED = "0f22507a10bbddd07d8a3082122966e3";
	/**
	 * 公钥文件路径
	 */
	public static final String PUBLIC_KEY_FILE = System.getProperty("user.dir") + "\\src\\main\\resource\\mypubkey.dat";
	/**
	 * 私钥文件路径
	 */
	public static final String PRIVATE_KEY_FILE = System.getProperty("user.dir") + "\\src\\main\\resource\\myprikey.dat";
}
