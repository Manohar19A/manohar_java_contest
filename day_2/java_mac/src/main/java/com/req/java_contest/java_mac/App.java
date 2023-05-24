package com.req.java_contest.java_mac;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Apple {
	private void repair(int cost) {
		System.out.println("Repairing" + cost);
	}
}

interface reflect {
}

public class App {

	public static void main(String[] args) throws Exception {
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