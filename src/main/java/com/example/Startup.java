package com.example;

import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Startup {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(    
                new String[]{"application-provider.xml"});    
      context.start();  
      TimeUnit.HOURS.sleep(1l);
	}

}
