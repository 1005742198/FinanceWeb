package com.obob.encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.Banner.Mode;

import com.obob.support.ConfigProperties;

/**
 * 对称加密解密
 * @author hongbo.zhao
 * 2016年7月10日 下午3:28:51
 */
public class SymmetricEncrypt {
	
	private static final String initkey = "key.init";//必须为8位
	
	private static final String key = ConfigProperties.getProperty("encryptkey");//建议写在配置文件中

	public static Base64EncodedCipherer getInstance(Mode mode){
		Base64EncodedCiphererImpl cipherer = new Base64EncodedCiphererImpl();
		cipherer.setMode(mode);
		return cipherer;
	}
	
	/**
	 * 得到一个初始化向量，用于操作密码
	 * @return String
	 * @author hongbo.zhao
	 * 2016年7月10日 下午3:29:52
	 */
	public static String getInitVector(){
		byte[] keyBytes = Base64.encodeBase64(initkey.getBytes());
		return new String(keyBytes);
	}
	
	/**
	 * 获取key
	 * @return String
	 * @author hongbo.zhao
	 * 2016年7月10日 下午3:30:05
	 */
	public static String getKey(){
		Base64EncodedKeyGeneratorImpl keygenerator = new Base64EncodedKeyGeneratorImpl();
		try {
			keygenerator.afterPropertiesSet();
			String key = keygenerator.generate();
			return key;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * 加密字符串
	 * @return String
	 * @author hongbo.zhao
	 * 2016年7月10日 下午3:30:19
	 */
	public static String encryptStr(String message){
		String initializationVector = getInitVector();
		if(key == null)
			return null;
		Base64EncodedCipherer cipherer = getInstance(Mode.ENCRYPT); 
		String encryptStr = cipherer.encrypt(key, initializationVector, message);
		return encryptStr;
	}
	
	/**
	 * 解密字符串
	 * @return String
	 * @author hongbo.zhao
	 * 2016年7月10日 下午3:30:34
	 */
	public static String decryptStr(String message){
		String initializationVector = getInitVector();
		if(key == null)
			return null;
		Base64EncodedCipherer cipherer = getInstance(Mode.DECRYPT); 
		String decryptStr = cipherer.encrypt(key, initializationVector, message);
		return decryptStr;
	}
	
	public static void main(String[] args) {
		String str = "ddsfasasdf";
		String enstr = encryptStr(str);
		System.out.println(enstr);
		System.out.println(decryptStr(enstr));
	}
	
}
