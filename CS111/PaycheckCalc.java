import javax.swing.JOptionPane;

public class PaycheckCalc {
	public static void main(String [] args) {
		
		String empName = null;
		String grossAmt = null;
		double grossAmt2 = 0;
		double fedInTax = 0;
		double stateTax = 0;
		double socialSecTax = 0;
		double medicareTax = 0;
		double pensionPlan = 0;
		double netPay = 0;
		final double FED_IN_TAX = 0.15;
		final double STATE_TAX = 0.035;
		final double SOCIAL_SEC_TAX = 0.0575;
		final double MEDICARE_TAX = 0.0275;
		final double PENSION_PLAN = 0.05;
		final double HEALTH_INS = 75;
		
		empName = JOptionPane.showInputDialog("Please enter the employee's name.");
		grossAmt = JOptionPane.showInputDialog("Please enter the gross amount the employee gets paid.");
		grossAmt2 = Integer.parseInt(grossAmt);
		
		fedInTax = grossAmt2 * FED_IN_TAX;
		stateTax = grossAmt2 * STATE_TAX;
		socialSecTax = grossAmt2 * SOCIAL_SEC_TAX;
		medicareTax = grossAmt2 * MEDICARE_TAX;
		pensionPlan = grossAmt2 * PENSION_PLAN;
		netPay = (grossAmt2 - fedInTax - stateTax - socialSecTax - medicareTax - pensionPlan - HEALTH_INS);
		
		System.out.printf("%s", empName);
		System.out.printf("\n%-30s $%8.2f", "Gross Amount: ", grossAmt2);
		System.out.printf("\n%-30s $%8.2f", "Federal Tax: ", fedInTax);
		System.out.printf("\n%-30s $%8.2f", "State Tax: ", stateTax);
		System.out.printf("\n%-30s $%8.2f", "Social Security Tax: ", socialSecTax);
		System.out.printf("\n%-30s $%8.2f", "Medicare/Medicaid Tax: ", medicareTax);
		System.out.printf("\n%-30s $%8.2f", "Pension Plan: ", pensionPlan);
		System.out.printf("\n%-30s $%8.2f", "Health Insurance: ", HEALTH_INS);
		System.out.printf("\n%-30s $%8.2f", "Net Pay: ", netPay);
		
		
	}
}
