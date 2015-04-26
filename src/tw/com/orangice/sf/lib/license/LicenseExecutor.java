package tw.com.orangice.sf.lib.license;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

import tw.com.orangice.sf.lib.license.manager.KeyPairManager;

public class LicenseExecutor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyPairManager manager = new KeyPairManager();
		try {
			manager.generateKeyPair();
			PublicKey publicKey = manager.readPublicKeyFromFile(new File("public.key"));
			PrivateKey privateKey = manager.readPrivateKeyFromFile(new File("private.key"));
			
			String test = "ABCDEFG";
			byte[] encrypt = manager.rsaEncrypt(test.getBytes(), new File("public.key"));
			byte[] decrypt = manager.rsaDecrypt(encrypt, new File("private.key"));
			
			System.out.println("decrypt:"+new String(decrypt));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
