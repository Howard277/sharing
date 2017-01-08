package com.ms.encryptsharing.dsa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/**
 * DSA工具类
 * 
 * @author Administrator
 *
 */
public class DSAUtils {
	// 获取签名
	public static byte[] sign(byte[] myinfo) {

		// 读取私钥文件
		ObjectInputStream in;
		try {
			in = new java.io.ObjectInputStream(new FileInputStream(DSACommons.PRIVATE_KEY_FILE));
			PrivateKey myprikey = (PrivateKey) in.readObject();
			in.close();
			// 初始一个Signature对象,并用私钥对信息签名
			java.security.Signature signet = Signature.getInstance(DSACommons.KEY_ALGORITHM);
			signet.initSign(myprikey);
			signet.update(myinfo);
			return signet.sign();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean verify(byte[] myinfo, byte[] sign) {
		try {
			// 读取公钥文件
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(DSACommons.PUBLIC_KEY_FILE));
			PublicKey pubkey = (PublicKey) in.readObject();
			in.close();

			// 初始一个Signature对象,并用公钥和签名进行验证
			Signature signetcheck = Signature.getInstance(DSACommons.KEY_ALGORITHM);
			signetcheck.initVerify(pubkey);
			signetcheck.update(myinfo);
			if (signetcheck.verify(sign))
				return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return false;
	}
}
