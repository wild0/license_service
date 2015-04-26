package tw.com.orangice.sf.lib.license.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;

public class RSAUtility {
	
	
	/*
	public static void encryptFile(File srcFile, File destFile)
			throws Exception {
		OutputStream outputWriter = null;
		InputStream inputReader = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			byte[] buf = new byte[100];
			int bufl;
			cipher.init(Cipher.ENCRYPT_MODE, getKeyPair().getPublic());
			outputWriter = new FileOutputStream(destFile);
			inputReader = new FileInputStream(srcFile);
			while ((bufl = inputReader.read(buf)) != -1) {
				byte[] encText = null;
				byte[] newArr = null;
				if (buf.length == bufl) {
					newArr = buf;
				} else {
					newArr = new byte[bufl];
					for (int i = 0; i < bufl; i++) {
						newArr[i] = (byte) buf[i];
					}
				}
				encText = cipher.doFinal(newArr);
				outputWriter.write(encText);
			}
			outputWriter.flush();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (outputWriter != null) {
					outputWriter.close();
				}
				if (inputReader != null) {
					inputReader.close();
				}
			} catch (Exception e) {
			}
		}
	}

	public static void decryptFile(File srcFile, File destFile)
			throws Exception {
		OutputStream outputWriter = null;
		InputStream inputReader = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding",
					new org.bouncycastle.jce.provider.BouncyCastleProvider());
			byte[] buf = new byte[128];
			int bufl;
			cipher.init(Cipher.DECRYPT_MODE, getKeyPair().getPrivate());
			
			outputWriter = new FileOutputStream(destFile);
			inputReader = new FileInputStream(srcFile);
			while ((bufl = inputReader.read(buf)) != -1) {
				byte[] encText = null;
				byte[] newArr = null;
				if (buf.length == bufl) {
					newArr = buf;
				} else {
					newArr = new byte[bufl];
					for (int i = 0; i < bufl; i++) {
						newArr[i] = (byte) buf[i];
					}
				}
				encText = cipher.doFinal(newArr);
				outputWriter.write(encText);
			}
			outputWriter.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (outputWriter != null) {
					outputWriter.close();
				}
				if (inputReader != null) {
					inputReader.close();
				}
			} catch (Exception e) {
			}
		}
	}
	*/
}
