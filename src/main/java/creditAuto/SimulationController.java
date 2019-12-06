package creditAuto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SimulationController {
	
	@Autowired
	private SimulationService newSimulService;
	
	@RequestMapping(value = "/{purchaseAmount, loanAmount, loanDuration, vehicleCategory}", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public void createSimul(@RequestBody Simulation newSimul) {
		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@ResponseStatus(value=HttpStatus.CREATED)
	public BigDecimal sendBackRate2Front(@RequestBody Simulation newSimul) {
		return newSimulService.sendBackRate(newSimul);
	}
	
	
}
