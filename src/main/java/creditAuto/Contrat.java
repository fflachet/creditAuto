package creditAuto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Contrat {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private int contractNumber;//?;
	
	@Column
	private LocalDate paymentStartDate;
	
	@Column
	private LocalDate paymentEndDate;
	
	@Column
	private LocalDate closureDate;
	
	@Autowired
	private Client client;
	
	@Column
	private BigDecimal purchaseAmount;
	
	@Column
	private BigDecimal loanTotalCost;
	
	@Column
	private int loanDuration;
	
	@Column
	private VehicleCategory vehicleCategory;
	
	@Column
	private BigDecimal loanRate;
	
	@ManyToOne
	private List<Client> clientList;
	
	// constructor
	public Contrat(Long id, int contractNumber, LocalDate paymentStartDate, LocalDate paymentEndDate,
			LocalDate closureDate, Client client, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate) {
		super();
		this.id = id;
		this.contractNumber = contractNumber;
		this.paymentStartDate = paymentStartDate;
		this.paymentEndDate = paymentEndDate;
		this.closureDate = closureDate;
		this.client = client;
		this.purchaseAmount = purchaseAmount;
		this.loanTotalCost = loanTotalCost;
		this.loanDuration = loanDuration;
		this.vehicleCategory = vehicleCategory;
		this.loanRate = loanRate;
	}

	public Contrat(Long id, int contractNumber, LocalDate paymentStartDate, LocalDate paymentEndDate,
			LocalDate closureDate, Client client, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate, List<Client> clientList) {
		super();
		this.id = id;
		this.contractNumber = contractNumber;
		this.paymentStartDate = paymentStartDate;
		this.paymentEndDate = paymentEndDate;
		this.closureDate = closureDate;
		this.client = client;
		this.purchaseAmount = purchaseAmount;
		this.loanTotalCost = loanTotalCost;
		this.loanDuration = loanDuration;
		this.vehicleCategory = vehicleCategory;
		this.loanRate = loanRate;
		this.clientList = clientList;
	}

	// Getters/Setter

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getContractNumber() {
		return contractNumber;
	}


	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}


	public LocalDate getPaymentStartDate() {
		return paymentStartDate;
	}


	public void setPaymentStartDate(LocalDate paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}


	public LocalDate getPaymentEndDate() {
		return paymentEndDate;
	}


	public void setPaymentEndDate(LocalDate paymentEndDate) {
		this.paymentEndDate = paymentEndDate;
	}


	public LocalDate getClosureDate() {
		return closureDate;
	}


	public void setClosureDate(LocalDate closureDate) {
		this.closureDate = closureDate;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}


	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}


	public BigDecimal getLoanTotalCost() {
		return loanTotalCost;
	}


	public void setLoanTotalCost(BigDecimal loanTotalCost) {
		this.loanTotalCost = loanTotalCost;
	}


	public int getLoanDuration() {
		return loanDuration;
	}


	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}


	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}


	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}


	public BigDecimal getLoanRate() {
		return loanRate;
	}


	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}


	public List<Client> getClientList() {
		return clientList;
	}


	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}


}
