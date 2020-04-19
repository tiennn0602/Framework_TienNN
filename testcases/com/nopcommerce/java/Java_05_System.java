package com.nopcommerce.java;

public class Java_05_System {

	public static void main(String[] args) {
		String rootFolder = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		String osArch = System.getProperty("os.arch");
		String osVer = System.getProperty("os.version");
		System.out.println("OS name = " + osName);
		System.out.println("OS arch = " + osArch);
		System.out.println("OS version = " + osVer);
		System.out.println("rootFolder = " + rootFolder);
	}
}
