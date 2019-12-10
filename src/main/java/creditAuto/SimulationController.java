package creditAuto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
//@CrossOrigin(origins="*")
public class SimulationController {
	
	@Autowired
	private SimulationService newSimulService;
	
//	@RequestMapping(value = "/{purchaseAmount, loanAmount, loanDuration, vehicleCategory}", method = RequestMethod.POST)
//	//@RequestMapping(value = "/simulation", method = RequestMethod.POST)
//	@ResponseStatus(value=HttpStatus.CREATED)
//	public void createSimul(@RequestBody Simulation newSimul) {
//		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
//	}
	
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	//@ResponseStatus(value=HttpStatus.CREATED)
//	public BigDecimal sendBackRate2Front(@RequestBody Simulation newSimul) {
//		return newSimulService.sendBackRate(newSimul);
//	}
	
	//@GetMapping
	//@RequestMapping(value = "/simulation", method = RequestMethod.GET)
	//@ResponseStatus(value=HttpStatus.CREATED)
//	@RequestMapping(value = "/simulation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Simulation getSimulation(@RequestBody BigDecimal purchaseAmount, BigDecimal loanAmount) {
//		System.out.println("getSimulation");
//		return new Simulation(purchaseAmount, loanAmount);
//	}
	
	@RequestMapping(value = "/simulation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Simulation getSimulation(@RequestBody Simulation newSimul) {
		System.out.println("getSimulation");
		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
//		newSimul.setLoanRate(new BigDecimal(2));
//		newSimul.setMonthlyPayment(new BigDecimal(350));
//		newSimul.setLoanTotalCost(new BigDecimal(15000));
		RateCalculations.applyRateAndCalculateTotalCost(newSimul);
		
		return newSimul;
	}
	
	
}
