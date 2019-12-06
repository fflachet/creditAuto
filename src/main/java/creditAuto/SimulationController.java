package creditAuto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimulationController {
	
	@Autowired
	private SimulationService newSimulService;
	
	@RequestMapping(value = "/{purchaseAmount, loanAmount, loanDuration, vehicleCategory}", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public void createSimul(@RequestBody Simulation newSimul) {
		newSimulService.createSimul(newSimul.getPurchaseAmount(), newSimul.getLoanAmount(), newSimul.getLoanDuration(), newSimul.getVehicleCategory());
	}
	
	
}
