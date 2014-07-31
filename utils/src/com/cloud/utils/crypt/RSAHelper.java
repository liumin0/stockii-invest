// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.utils.crypt;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSAHelper {
    
	static {
		BouncyCastleProvider provider = new BouncyCastleProvider();
		if (Security.getProvider(provider.getName()) == null)
			Security.addProvider(provider);
	}
	
	private static RSAPublicKey readKey(String key) throws Exception {
		byte[] encKey = Base64.decodeBase64(key.split(" ")[1]);
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(encKey));
		
		byte[] header = readElement(dis);
		String pubKeyFormat = new String(header);
		if (!pubKeyFormat.equals("ssh-rsa")) 
			throw new RuntimeException("Unsupported format");
			
		byte[] publicExponent = readElement(dis);
		byte[] modulus = readElement(dis);
		
		KeySpec spec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
		RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(spec);
	
		return pubKey;
	}

	private static byte[] readElement(DataInput dis) throws IOException {
        int len = dis.readInt();
        byte[] buf = new byte[len];
        dis.readFully(buf);
        return buf;
	}

	public static String encryptWithSSHPublicKey(String sshPublicKey, String content) {
		String returnString = null;
		try {
	        RSAPublicKey publicKey = readKey(sshPublicKey);
	        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", BouncyCastleProvider.PROVIDER_NAME);
	        cipher.init(Cipher.ENCRYPT_MODE, publicKey , new SecureRandom());
	        byte[] encrypted = cipher.doFinal(content.getBytes());
	        returnString = Base64.encodeBase64String(encrypted);
		} catch (Exception e) {}
		
        return returnString;
	}
	
	//RSA-VMpasswordRest
	private static RSAPublicKey readPubKey(String key) {
		RSAPublicKey pubKey = null;
		try {
			byte[] decKey = Base64.decodeBase64(key);
			DataInputStream dis = new DataInputStream(new ByteArrayInputStream(decKey));
				
			byte[] modulus = readElement(dis);
			byte[] publicExponent = readElement(dis);
				
			KeySpec spec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
			pubKey = (RSAPublicKey) keyFactory.generatePublic(spec);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return pubKey;
	}
	
	private static RSAPrivateKey readPriKey(String key) {
		RSAPrivateKey priKey = null;
		try {
				
			byte[] decKey = Base64.decodeBase64(key);
			DataInputStream dis = new DataInputStream(new ByteArrayInputStream(decKey));
				
			byte[] modulus = readElement(dis);
			byte[] privateExponent = readElement(dis);
				

			KeySpec spec = new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(privateExponent));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
			priKey = (RSAPrivateKey) keyFactory.generatePrivate(spec);
			} catch (Exception e) {
				System.out.println(e.toString());
				}
			
		return priKey;
	}
	
	public static String encryptWithPubKeyStr(String keyStr, String content) {
		
		RSAPublicKey readedPubKey = RSAHelper.readPubKey(keyStr);
		String returnString = null;
		try {
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", BouncyCastleProvider.PROVIDER_NAME);
			cipher.init(Cipher.ENCRYPT_MODE, readedPubKey, new SecureRandom());
			byte[] encrypted = cipher.doFinal(content.getBytes());
			returnString = Base64.encodeBase64String(encrypted);
			} catch (Exception e) {
				System.out.println(e.toString());
		}
		return returnString;
	}
	
	public static String decryptWithPriKeyStr(String keyStr, String content) {
		
		RSAPrivateKey readedPriKey = RSAHelper.readPriKey(keyStr);
		String returnString = null;
		try {	        
			byte[] encrypted = Base64.decodeBase64(content);
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", BouncyCastleProvider.PROVIDER_NAME);
			cipher.init(Cipher.DECRYPT_MODE, readedPriKey, new SecureRandom());
			byte[] decrypted = cipher.doFinal(encrypted);
			returnString = new String(decrypted);
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		return returnString;
	}
}
