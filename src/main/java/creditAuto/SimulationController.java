package creditAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SimulationController {
	
	@Autowired
	private SimulationService newSimulService;

	@RequestMapping(value = "/simulation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Simulation getSimulation(@RequestBody Simulation newSimul) {	
		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
		RateCalculations.applyRateAndCalculateTotalCost(newSimul);
		return newSimul;
	}
	


	
	
}
