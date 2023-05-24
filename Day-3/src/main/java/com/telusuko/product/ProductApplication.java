package com.telusuko.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.constructor.Constructor;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) throws ClassNotFoundException {
//		SpringApplication.run(ProductApplication.class, args);
//		
//		System.out.println("HI Manohar");
		Class c = Class.forName("Apple");
		System.out.println(c.getName());

		// loading interface .
		Class c2 = Class.forName("My");
		System.out.println(c2.isInterface());

		System.out.println(c.getConstructors().length);

		Constructor constructor[] = c.getConstructors();
		for (Constructor cons : constructor) {
			System.out.println(cons);
		}

		Apple apple = (Apple) c.newInstance();
		Apple apple1 = (Apple) c.newInstance();

		Method m = c.getDeclaredMethod("repair", int.class);
		m.setAccessible(true);
		m.invoke(apple, 40);

	}

}
