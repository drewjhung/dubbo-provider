package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.junit.Test;
import org.slf4j.impl.Log4jLoggerFactory;

public class GeneralTest {

	@Test public void whereIsClass(){
		// TODO 找到jvm加载的类位置，用于确定冲突jar包。
		System.out.println(GeneralTest.where(Log4jLoggerFactory.class));
	}
	
	 public static String where(final Class cls) {  
         if (cls == null)throw new IllegalArgumentException("null input: cls");  
         URL result = null;  
         final String clsAsResource = cls.getName().replace('.', '/').concat(".class");  
         final ProtectionDomain pd = cls.getProtectionDomain();  
         if (pd != null) {  
             final CodeSource cs = pd.getCodeSource();  
             if (cs != null) result = cs.getLocation();  
             if (result != null) {  
                 if ("file".equals(result.getProtocol())) {  
                     try {  
                         if (result.toExternalForm().endsWith(".jar") ||  
                                 result.toExternalForm().endsWith(".zip"))  
                             result = new URL("jar:".concat(result.toExternalForm())  
                                     .concat("!/").concat(clsAsResource));  
                         else if (new File(result.getFile()).isDirectory())  
                             result = new URL(result, clsAsResource);  
                     }  
                     catch (MalformedURLException ignore) {}  
                 }  
             }  
         }  
         if (result == null) {  
             final ClassLoader clsLoader = cls.getClassLoader();  
             result = clsLoader != null ?  
                     clsLoader.getResource(clsAsResource) :  
                     ClassLoader.getSystemResource(clsAsResource);  
         }  
         return result.toString();  
     } 
	 @Test public void refreshCaptchaTest() throws Exception {
		 URL url = new URL("http://427studio.net/servlet/captchaCode");
		 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	 }
}
