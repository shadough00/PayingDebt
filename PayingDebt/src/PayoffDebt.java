
import java.text.DecimalFormat;        //import Decimal format  
import java.util.Scanner;	           //import scanner class

	public class PayoffDebt {
	
		private static DecimalFormat df = new DecimalFormat("0.00");
	
		public static void main(String[] args) {

			//create a new scanner object
			Scanner keyboard = new Scanner(System.in);  
	
			//declare input variables
			double principal, annual_interest_rate, monthly_payment;
	
			//declare resulting variables
			double months_needed_to_pay_off, total_amount_paid, total_interest_paid, overpayment;
	
			//ask for user input
			System.out.print("Principal: \t\t\t");
			principal = keyboard.nextDouble();
			System.out.print("Annual Interest Rate (%):\t");
			annual_interest_rate = keyboard.nextDouble();
			System.out.print("Monthly Payment: \t\t");
			monthly_payment = keyboard.nextDouble();
	
			//close the keyboard
			keyboard.close();
	
			//mathematical formula for months needed to pay off
			double numerator_of_formula = Math.log(monthly_payment) - Math.log(monthly_payment - (annual_interest_rate / 1200.0) * principal);
			double denominator_of_formula = Math.log((annual_interest_rate / 1200.0) +1.0);
			months_needed_to_pay_off = numerator_of_formula / denominator_of_formula;
	
			//change variable from double to int, while also including a ceiling
			double months_needed_to_pay_off_ceil = Math.ceil(months_needed_to_pay_off);
			int value = (int)months_needed_to_pay_off_ceil;	
	
			double double_months_needed_to_pay_off = numerator_of_formula / denominator_of_formula;
	
			//print months needed to pay off answer
			System.out.println("");
			System.out.println("Months Needed To Pay Off:\t" + df.format(months_needed_to_pay_off_ceil));
	
			//mathematical formula for total amount paid
			total_amount_paid = months_needed_to_pay_off_ceil * monthly_payment;
			System.out.println("Total Amount Paid: \t\t" + df.format(total_amount_paid));
	
			//mathematical formula for total interest paid
			total_interest_paid = total_amount_paid - principal;
			System.out.println("Total Interest Paid: \t\t" + df.format(total_interest_paid));
	
			//mathematical formula for overpaymemt
			double extra_month = months_needed_to_pay_off_ceil - double_months_needed_to_pay_off;
			overpayment = extra_month * monthly_payment;
			//overpayment = overpayment * 100;
			System.out.print("Overpayment:\t\t\t" + "$" + df.format(overpayment));





	}
}
