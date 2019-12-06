package creditAuto;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditauto.contract.VehicleCategory;
import fr.diginamic.erwan.spring_mvc.model.User;

@Service
public class SimulationService {
	
	@Autowired
	private Simulation newSimul;
	private List<Simulation> listSimul;
	
	private BigDecimal rateCalculation(Simulation simul) {
		BigDecimal rateValue = BigDecimal.valueOf(0);
		return rateValue;
	}
	
	public void createSimul(BigDecimal purchaseAmount, BigDecimal loanAmount, int loanDuration, VehicleCategory vehicleCategory) { 
		newSimul= new Simulation(purchaseAmount, loanAmount, loanDuration, vehicleCategory);
		//listSimul.add(newSimul);
		BigDecimal rateValue=rateCalculation(newSimul);
		//return rateValue;
		
	}
/*
	public Simulation findSimul(Long id) { 
		return userRepository.findById(id);
		
	}
	*/
//	public void deleteSimul(Long id) { 
//		if 
//	}

}
