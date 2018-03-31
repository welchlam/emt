package com.welch.emt;

import com.welch.emt.util.Encryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmtApplication {

	public static void main(String[] args) {
		init();
		SpringApplication.run(EmtApplication.class, args);
	}

	public static void init(){
		loadProperties();
	}

	public static void loadProperties(){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("application.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String home = (String) properties.get("emt.app.home");
			String key = (String) properties.get("emt.app.key");
			String pwd = (String) properties.get("emt.db.pwd");
			String dbPassword = Encryptor.decrypt(key, pwd);
			System.setProperty("emt.app.home",home);
			System.setProperty("emt.app.key",key);
			System.setProperty("dbPassword", dbPassword);
			//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			//System.out.println(dbPassword);
			//System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*@Bean
	public in.virit.WidgetSet viritinCdnInitializer() {
		return new in.virit.WidgetSet();
	}*/

}
