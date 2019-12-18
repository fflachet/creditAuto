package creditAuto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import creditAuto.model.Contract;
import creditAuto.services.ContractService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {

	@Autowired
	private ContractService contractService;

	@RequestMapping(value = "/contract", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Contract sendContract(@RequestBody Contract contract) {
		this.contractService.createContract(contract);
		System.out.println(contract + " contract controller ");

		return contract;
	}
	
	@RequestMapping(value = "/statistics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Contract> getContractListByDate(@RequestBody String[] dates) {

		System.out.println(dates);
		
		LocalDate beginingDate = LocalDate.parse(dates[0]);
		LocalDate endDate = LocalDate.parse(dates[1]);
		
		
//		System.out.print(this.contractService.findContractsByDates(dates[0], dates[1]));
		this.contractService.findContractsByDates(beginingDate, endDate);
//		List<Contract>
		
		
		return this.contractService.findContractsByDates(beginingDate, endDate);
	}

//	@RequestMapping(value = "/contract", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Contract sendContract(@RequestBody Contract contract, Client client) {
//
//		this.contractService.createContract(contract.getId(), contract.getContractNumber(),
//				contract.getPaymentStartDate(), contract.getPaymentEndDate(), contract.getClosureDate(),
//				contract.getPurchaseAmount(), contract.getLoanTotalCost(), contract.getLoanDuration(),
//				contract.getVehicleCategory(), contract.getLoanRate());
//
//		System.out.println(contract + " contract controller ");
//
//		return contract;
//	}
}
