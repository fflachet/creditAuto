package creditAuto;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		System.out.println("Context loaded !");
		
//		Simulation simulation = new Simulation(new BigDecimal(2), new BigDecimal(2), 12, VehicleCategory.A);
//		RateCalculations rate = new RateCalculations();
//		
//		rate.applyRateAndCalculateTotalCost(simulation);
//		
//		System.out.println(simulation);
		
	}

}
