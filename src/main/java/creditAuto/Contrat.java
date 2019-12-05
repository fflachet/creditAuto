package creditAuto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contrat {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private double buyPrice;
	@Column
	private double creditPrice;
	@Column
	private int creditDuration;
	@Column
	private char vehiculeCategori;
	@Column
	private double rate;
	
	@ManyToOne
	private List<Client> clientList;
	
	
	
	// Constructor
	public Contrat(Long id, double buyPrice, double creditPrice, int creditDuration, char vehiculeCategori,
			double rate) {
		this.id = id;
		this.buyPrice = buyPrice;
		this.creditPrice = creditPrice;
		this.creditDuration = creditDuration;
		this.vehiculeCategori = vehiculeCategori;
		this.rate = rate;
	}

	public Contrat(Long id, double buyPrice, double creditPrice, int creditDuration, char vehiculeCategori, double rate,
			List<Client> clientList) {
		this.id = id;
		this.buyPrice = buyPrice;
		this.creditPrice = creditPrice;
		this.creditDuration = creditDuration;
		this.vehiculeCategori = vehiculeCategori;
		this.rate = rate;
		this.clientList = clientList;
	}

	// Getters/Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	
	

}
