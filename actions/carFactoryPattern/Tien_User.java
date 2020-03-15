package carFactoryPattern;

public class Tien_User {

	public static void main(String[] args) {
		// Option 01
		//Tien wants to see Ford
		FordCar ford = new FordCar();
		ford.viewFordAddress();
		ford.viewCarVersion();
		
		//Tien wants to see Honda
		HondaCar honda = new HondaCar();
		honda.viewHondaAddress();
		honda.viewCarVersion();
		
		//Tien wants to see Huyndai
		HuyndaiCar huyndai = new HuyndaiCar();
		huyndai.viewHuyndaiAddress();
		huyndai.viewCarVersion();
		
		
		// Option 02
		CarFactory_01 carFactory = new CarFactory_01();
		System.out.println("=================================");
		carFactory.viewCarVersion("Ford");
		carFactory.viewCarVersion("Huyndai");
		carFactory.viewCarVersion("Honda");
	}
}
