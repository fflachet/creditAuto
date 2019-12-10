package creditAuto;

import java.math.BigDecimal;
import java.math.RoundingMode;

class RateCalculations {

	private RateCalculations() {

	}

	static BigDecimal monthlyRateT1 = BigDecimal.valueOf(0.0065);
	static BigDecimal monthlyRateT2 = BigDecimal.valueOf(0.0034);
	static BigDecimal monthlyRateT3 = BigDecimal.valueOf(0.0045);
	static BigDecimal monthlyRateT4 = BigDecimal.valueOf(0.0021);
	static BigDecimal monthlyRateT5 = BigDecimal.valueOf(0.0044);
	static BigDecimal monthlyRateT6 = BigDecimal.valueOf(0.0074);

	static BigDecimal chosenMonthlyRate;			// Applied periodic Rate   
	static BigDecimal amountSchedulePayment;		// Monthly payment
	static BigDecimal annualRate;					// Annual Rate

	static BigDecimal threshold1 = new BigDecimal(10000);
	static BigDecimal threshold2 = new BigDecimal(15000);
	static BigDecimal threshold3 = new BigDecimal(25000);

	public static void applyRateAndCalculateTotalCost(Simulation simul) {

		switch (simul.getVehicleCategory().name()) {

		case "A":
			applyRateVehicleA(simul);
			break;
		case "B":
			applyRateVehicleB(simul);
			break;
		}
		newValuesFromProductOwnerCalculateTotalCost(simul);
	}

	public static void applyRateVehicleA(Simulation simul) {
		if (simul.getPurchaseAmount().compareTo(threshold1) == -1 && simul.getLoanDuration() <= 30) {
			chosenMonthlyRate = monthlyRateT1;
		} else if ((simul.getPurchaseAmount().compareTo(threshold1) == -1 && simul.getLoanDuration() > 30)
				|| ((simul.getPurchaseAmount().compareTo(threshold1) == 0
						|| simul.getPurchaseAmount().compareTo(threshold1) == 1) && simul.getLoanDuration() <= 24)) {
			chosenMonthlyRate = monthlyRateT2;
		} else if ((simul.getPurchaseAmount().compareTo(threshold1) == 0
				|| simul.getPurchaseAmount().compareTo(threshold1) == 1) && simul.getLoanDuration() > 24) {
			chosenMonthlyRate = monthlyRateT3;
		}
	}

	public static void applyRateVehicleB(Simulation simul) {
		if (simul.getPurchaseAmount().compareTo(threshold2) == -1 && simul.getLoanDuration() <= 18) {
			chosenMonthlyRate = monthlyRateT3;
		} else if ((simul.getPurchaseAmount().compareTo(threshold2) == -1
				&& (18 < simul.getLoanDuration() && simul.getLoanDuration() <= 36))) {
			chosenMonthlyRate = monthlyRateT4;
		} else if ((simul.getPurchaseAmount().compareTo(threshold2) == -1 && simul.getLoanDuration() > 36)
				|| (((simul.getPurchaseAmount().compareTo(threshold2) == 0
						|| simul.getPurchaseAmount().compareTo(threshold2) == 1)
						&& (simul.getPurchaseAmount().compareTo(threshold3) == -1
								|| simul.getPurchaseAmount().compareTo(threshold3) == 0))
						&& simul.getLoanDuration() <= 24)) {
			chosenMonthlyRate = monthlyRateT5;
		} else if (simul.getPurchaseAmount().compareTo(threshold3) == 1) {
			chosenMonthlyRate = monthlyRateT6;
		}
	}

	public static void newValuesFromProductOwnerCalculateTotalCost(Simulation simul) {

		double numberSchedulePayment = simul.getLoanDuration();

		BigDecimal nominator = chosenMonthlyRate.multiply(simul.getLoanAmount()); // Calculation of the nominator

		BigDecimal calculationBeforePow = chosenMonthlyRate.add(BigDecimal.valueOf(1)); // calculationBeforePow

		double dbConvertCalculationBeforePow = calculationBeforePow.doubleValue(); // Converting to double because BigDecimal.pow doesn't work with negative exponent
																				
		double powOfTheDenominator = Math.pow(dbConvertCalculationBeforePow, -numberSchedulePayment); // Calculating in double value of the pow inside the denominator

		BigDecimal bdPowOfTheDenominator = BigDecimal.valueOf(powOfTheDenominator); // Converting back to BigDecimal value
																					// 
		BigDecimal denominator = BigDecimal.valueOf(1).subtract(bdPowOfTheDenominator); // Denominator calculation

		amountSchedulePayment = nominator.divide(denominator, 4, RoundingMode.HALF_EVEN); // Calculating Formula with roundingMode to avoid arithmeticException in

		annualRate = chosenMonthlyRate.multiply(BigDecimal.valueOf(12));

		simul.setLoanRate(annualRate);
		simul.setMonthlyPayment(amountSchedulePayment);
		simul.setLoanTotalCost(amountSchedulePayment.multiply(BigDecimal.valueOf(numberSchedulePayment)));

	}

	/* OLD CALCULATION FORMULA */

//	public static void calculateTotalCost(Simulation simul) {
//	
//	static int numberSchedulePayment = simul.getLoanDuration();
//
//	annualRate = chosenMonthlyRate.multiply(BigDecimal.valueOf(12));
//
//	amountSchedulePayment = (chosenMonthlyRate.multiply(simul.getLoanAmount())
//			.multiply(chosenMonthlyRate.add(BigDecimal.valueOf(1)).pow(numberSchedulePayment)))
//					.divide((BigDecimal.valueOf(1))
//							.subtract((chosenMonthlyRate.add(BigDecimal.valueOf(1))).pow(-numberSchedulePayment)));
//
//	simul.setLoanTotalCost(BigDecimal.valueOf(numberSchedulePayment).multiply(amountSchedulePayment));
//	System.out.println(simul.getLoanTotalCost());
//	simul.setMonthlyPayment(amountSchedulePayment); // to set monthly payment in class Simulation
//	simul.setLoanRate(annualRate); // to set loan rate in class Simulation
//	System.out.println(amountSchedulePayment);
//	System.out.println(annualRate);
//	System.out.println(chosenMonthlyRate);
//}

}