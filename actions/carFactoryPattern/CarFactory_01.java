package carFactoryPattern;

public class CarFactory_01 {
	
	public void viewCarVersion(String carName) {
		if (carName.equalsIgnoreCase("Honda")) {
			HondaCar honda = new HondaCar();
			honda.viewHondaAddress();
			honda.viewCarVersion();
		} else if (carName.equalsIgnoreCase("Ford")) {
			FordCar ford = new FordCar();
			ford.viewFordAddress();
			ford.viewCarVersion();
		} else {
			HuyndaiCar huyndai = new HuyndaiCar();
			huyndai.viewHuyndaiAddress();
			huyndai.viewCarVersion();		
			}
		}
	}

