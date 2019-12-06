package creditAuto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SimulationService {
	
	private Simulation newSimul;
	
	private List<Simulation> listSimul;
	
	private BigDecimal rateCalculation(Simulation simul) {
		BigDecimal rateValue = BigDecimal.valueOf(0);
		return rateValue;
	}
	
	public void createSimul(BigDecimal purchaseAmount, BigDecimal loanAmount, int loanDuration, VehicleCategory vehicleCategory) { 
		newSimul= new Simulation(purchaseAmount, loanAmount, loanDuration, vehicleCategory);
		System.out.println(newSimul);
		//listSimul.add(newSimul);
		
	}
	
	public BigDecimal sendBackRate(Simulation newSimul) {
		BigDecimal rateValue=rateCalculation(newSimul);
		return rateValue;
	}
/*
	public Simulation findSimul(Long id) { 
		return userRepository.findById(id);
		
	}
	*/
	/*public void deleteSimul(Long id) { 
		if 
	}*/

}
