package creditAuto;

public class Simulation {
	
	private double buyPrice;
	private double creditPrice;
	private int creditDuration;
	private char vehiculeCategori;
	private double rate;
	
	
	// Constructor
	public Simulation() {}
	
	public Simulation(double buyPrice, double creditPrice, int creditDuration, char vehiculeCategori, double rate) {
		this.buyPrice = buyPrice;
		this.creditPrice = creditPrice;
		this.creditDuration = creditDuration;
		this.vehiculeCategori = vehiculeCategori;
		this.rate = rate;
	}
	
	//getters/setters

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getCreditPrice() {
		return creditPrice;
	}

	public void setCreditPrice(double creditPrice) {
		this.creditPrice = creditPrice;
	}

	public int getCreditDuration() {
		return creditDuration;
	}

	public void setCreditDuration(int creditDuration) {
		this.creditDuration = creditDuration;
	}

	public char getVehiculeCategori() {
		return vehiculeCategori;
	}

	public void setVehiculeCategori(char vehiculeCategori) {
		this.vehiculeCategori = vehiculeCategori;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	

	
	
	

}
