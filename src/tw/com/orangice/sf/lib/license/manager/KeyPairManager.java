package tw.com.orangice.sf.lib.license.manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KeyPairManager {
	public static void generateKeyPair() throws NoSuchAlgorithmException,
			InvalidKeySpecException, IOException {

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair kp = kpg.genKeyPair();
		Key publicKey = kp.getPublic();
		Key privateKey = kp.getPrivate();
		

		KeyFactory fact = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
				RSAPublicKeySpec.class);
		RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
				RSAPrivateKeySpec.class);

		saveToFile("public.key", pub.getModulus(), pub.getPublicExponent());
		saveToFile("private.key", priv.getModulus(), priv.getPrivateExponent());
	}

	public static void saveToFile(String fileName, BigInteger mod,
			BigInteger exp) throws IOException {
		ObjectOutputStream oout = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(fileName)));
		try {
			oout.writeObject(mod);
			oout.writeObject(exp);
		} catch (Exception e) {
			throw new IOException("Unexpected error", e);
		} finally {
			oout.close();
		}
	}

	public PublicKey readPublicKeyFromFile(File keyFile) throws IOException {
		InputStream in = new FileInputStream(keyFile);
		ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(
				in));
		try {
			BigInteger m = (BigInteger) oin.readObject();
			BigInteger e = (BigInteger) oin.readObject();
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PublicKey pubKey = fact.generatePublic(keySpec);
			return pubKey;
		} catch (Exception e) {
			throw new RuntimeException("Spurious serialisation error", e);
		} finally {
			oin.close();
		}
	}
	public PrivateKey readPrivateKeyFromFile(File keyFile) throws IOException {
		InputStream in = new FileInputStream(keyFile);
		ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(
				in));
		try {
			BigInteger m = (BigInteger) oin.readObject();
			BigInteger e = (BigInteger) oin.readObject();
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PrivateKey priKey = fact.generatePrivate(keySpec);
			return priKey;
		} catch (Exception e) {
			throw new RuntimeException("Spurious serialisation error", e);
		} finally {
			oin.close();
		}
	}
	
	
	public byte[] rsaEncrypt(byte[] data, File publicKeyFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		  PublicKey pubKey = readPublicKeyFromFile(publicKeyFile);
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		  byte[] cipherData = cipher.doFinal(data);
		  return cipherData;
		}
	public byte[] rsaDecrypt(byte[] data, File privateKeyFile) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		  PrivateKey privateKey = readPrivateKeyFromFile(privateKeyFile);
		  Cipher cipher = Cipher.getInstance("RSA");
		  cipher.init(Cipher.DECRYPT_MODE, privateKey);
		  byte[] cipherData = cipher.doFinal(data);
		  return cipherData;
		}

	/*
	 * 
	 * 
	 * public static void saveRSAKeyPair(File generateKeyPair) { try {
	 * SecureRandom sr = new SecureRandom(); KeyPairGenerator kg =
	 * KeyPairGenerator.getInstance("RSA", new
	 * org.bouncycastle.jce.provider.BouncyCastleProvider());
	 * 
	 * kg.initialize(1024, sr); FileOutputStream fos = new
	 * FileOutputStream(generateKeyPair); ObjectOutputStream oos = new
	 * ObjectOutputStream(fos);
	 * 
	 * oos.writeObject(kg.generateKeyPair()); oos.close(); } catch (Exception e)
	 * { e.printStackTrace(); } } public static KeyPair getKeyPair(File
	 * keyPairFile) {
	 * 
	 * KeyPair kp = null; try { String fileName = "conf/RASKey.xml"; InputStream
	 * is = new FileInputStream(keyPairFile); ObjectInputStream oos = new
	 * ObjectInputStream(is); kp = (KeyPair) oos.readObject(); oos.close(); }
	 * catch (Exception e) { e.printStackTrace(); } return kp; }
	 */

}
