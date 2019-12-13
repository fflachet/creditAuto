package creditAuto.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditAuto.dao.ContractDAO;
import creditAuto.model.Client;
import creditAuto.model.Contract;
import creditAuto.model.VehicleCategory;

@Service
public class ContractService {

	@Autowired
	private ContractDAO contractDao;

	private Contract contract;

	public void createContract(Long id, int contractNumber, String paymentStartDate, String paymentEndDate,
			String closureDate, BigDecimal purchaseAmount, BigDecimal loanTotalCost, int loanDuration,
			VehicleCategory vehicleCategory, BigDecimal loanRate, Client client) {
		contract = new Contract(id, contractNumber, paymentStartDate, paymentEndDate, closureDate, purchaseAmount,
				loanTotalCost, loanDuration, vehicleCategory, loanRate, client);
		System.out.println(contract + "service");
		// System.out.println(client + " service" );
		contractDao.persist(contract);
		// listSimul.add(newSimul);

	}

}