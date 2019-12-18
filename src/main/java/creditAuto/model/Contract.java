package creditAuto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Contract {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer contractNumber;
	
	@Column
	private LocalDate paymentStartDate;
	
	@Column
	private LocalDate paymentEndDate;
	
	@Column
	private LocalDate closureDate;
	
	@Column
	private BigDecimal purchaseAmount;
	
	@Column
	private BigDecimal loanTotalCost;
	
	@Column
	private Integer loanDuration;
	
	@Enumerated(EnumType.STRING)
	@Column
	private VehicleCategory vehicleCategory;
	
	@Column
	private BigDecimal loanRate;
	
	@ManyToOne
	private Client client;
	
	// constructor
	public Contract() {
		
	}
	
	public Contract(Long id, int contractNumber, LocalDate paymentStartDate, LocalDate paymentEndDate,
			LocalDate closureDate, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate, Client client) {
		super();
		this.id = id;
		this.contractNumber = contractNumber;
		this.paymentStartDate = paymentStartDate;
		this.paymentEndDate = paymentEndDate;
		this.closureDate = closureDate;
		this.purchaseAmount = purchaseAmount;
		this.loanTotalCost = loanTotalCost;
		this.loanDuration = loanDuration;
		this.vehicleCategory = vehicleCategory;
		this.loanRate = loanRate;
		this.client = client;
	}
	
	public Contract(Long id, int contractNumber, LocalDate paymentStartDate, LocalDate paymentEndDate,
			LocalDate closureDate, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate) {
		super();
		this.id = id;
		this.contractNumber = contractNumber;
		this.paymentStartDate = paymentStartDate;
		this.paymentEndDate = paymentEndDate;
		this.closureDate = closureDate;
		this.purchaseAmount = purchaseAmount;
		this.loanTotalCost = loanTotalCost;
		this.loanDuration = loanDuration;
		this.vehicleCategory = vehicleCategory;
		this.loanRate = loanRate;
	}
	
	public Contract(int contractNumber, LocalDate paymentStartDate, LocalDate paymentEndDate,
			LocalDate closureDate, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate) {
		super();
		this.contractNumber = contractNumber;
		this.paymentStartDate = paymentStartDate;
		this.paymentEndDate = paymentEndDate;
		this.closureDate = closureDate;
		this.purchaseAmount = purchaseAmount;
		this.loanTotalCost = loanTotalCost;
		this.loanDuration = loanDuration;
		this.vehicleCategory = vehicleCategory;
		this.loanRate = loanRate;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Integer contractNumber) {
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

	public void setLoanDuration(Integer loanDuration) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Contract [id=" + id + ", contractNumber=" + contractNumber + ", paymentStartDate=" + paymentStartDate
				+ ", paymentEndDate=" + paymentEndDate + ", closureDate=" + closureDate + ", purchaseAmount="
				+ purchaseAmount + ", loanTotalCost=" + loanTotalCost + ", loanDuration=" + loanDuration
				+ ", vehicleCategory=" + vehicleCategory + ", loanRate=" + loanRate + ", client=" + client + "]";
	}

	


}
