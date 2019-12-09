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
		
		System.out.println("getSimulation");
		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
		newSimul.setLoanRate(new BigDecimal(2));
		newSimul.setMonthlyPayment(new BigDecimal(350));
		newSimul.setLoanTotalCost(new BigDecimal(15000));
		
		// adding rate calcul into object newSimul
		newSimulService.sendBackRate(newSimul);
		System.out.println("after : " + newSimul);
		return newSimul;
		//return newSimul;
	}

	
	
}
